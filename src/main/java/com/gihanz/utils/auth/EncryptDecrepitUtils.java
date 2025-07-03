package com.gihanz.utils.auth;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

@Slf4j
@Service
public class EncryptDecrepitUtils {

    @Value("${string.encode.aes}")
    private String aes;

    @Value("${string.encode.secrete}")
    private String secret;


    private static final byte[] SALT = {(byte) 0x21, (byte) 0x21, (byte) 0xF0, (byte) 0x55, (byte) 0xC3, (byte) 0x9F, (byte) 0x5A, (byte) 0x75};
    private final static int ITERATION_COUNT = 31;

    @SneakyThrows
    public String encode(String input) {
        KeySpec keySpec = new PBEKeySpec(secret.toCharArray(), SALT, ITERATION_COUNT);
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT, ITERATION_COUNT);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        byte[] enc = ecipher.doFinal(input.getBytes());
        String res = new String(Base64.encode(enc));
        return res.replace('+', '-').replace('/', '_').replace("%", "%25").replace("\n", "%0A");
    }
    @SneakyThrows
    public String decode(String token) {
        String input = token.replace("%0A", "\n").replace("%25", "%").replace('_', '/').replace('-', '+');
        byte[] dec = Base64.decode(input.getBytes());
        KeySpec keySpec = new PBEKeySpec(secret.toCharArray(), SALT, ITERATION_COUNT);
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT, ITERATION_COUNT);
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
        Cipher dcipher = Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        log.info("Decrypt result: {}", dec);
        byte[] decoded = dcipher.doFinal(dec);
        return new String(decoded);
    }

}
