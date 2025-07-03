package com.gihanz.services.auth;

import com.gihanz.configs.AppConstant;
import com.gihanz.dtos.auth.TokenRefreshRequestDto;
import com.gihanz.entities.UserEntity;
import com.gihanz.entities.auth.RefreshTokenEntity;
import com.gihanz.exceptions.UnauthorizedException;
import com.gihanz.repositories.UserRepository;
import com.gihanz.repositories.auth.RefreshTokenRepository;
import com.gihanz.utils.auth.EncryptDecrepitUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class RefreshTokenService {


    private RefreshTokenRepository refreshTokenRepository;
    private UserRepository userRepository;
    @Lazy
    private final EncryptDecrepitUtils encryptDecrepitUtils;
    private final AppConstant appConstant;

    public RefreshTokenEntity findByRefreshToken(String token) {
        String decode = encryptDecrepitUtils.decode(token);
        log.info("Decrypted token: {}", decode);
        Optional<RefreshTokenEntity> byRefreshToken = refreshTokenRepository.findByRefreshTokenAndLogin(decode.split(",")[0],true);
        if (byRefreshToken.isPresent()) {

            RefreshTokenEntity entity = byRefreshToken.get();
            if (!entity.getUsername().equals(decode.split(",")[1])) {
                throw new UnauthorizedException("Invalid Refresh Token");
            }
            if (entity.getExpiryDate().isBefore(Instant.now())) {
                throw new UnauthorizedException("Expired Refresh Token");
            }
            return entity;
        }
        throw new UnauthorizedException("Refresh token not found");
    }

    public RefreshTokenEntity createRefreshToken(String userName, boolean isRefreshToken) {

        UserEntity user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UnauthorizedException("User not found");
        }
        RefreshTokenEntity refreshToken = new RefreshTokenEntity();
        refreshToken.setUserId(user.getId());

        if (isRefreshToken) {
            Optional<RefreshTokenEntity> refreshTokenEntity = refreshTokenRepository.findByUsername(userName);
            if (refreshTokenEntity.isPresent()) {
                RefreshTokenEntity entity = refreshTokenEntity.get();
                if(!entity.isLogin()) {
                    throw new UnauthorizedException("Invalid Refresh Token");
                }
                ZoneId zoneId = ZoneId.systemDefault(); // Get system default time zone
                LocalDateTime expireTime = LocalDateTime.ofInstant(entity.getExpiryDate(), zoneId);
                if (LocalDateTime.now().isAfter(expireTime)) {
                    try {
                        entity.setLogin(false);
                        refreshTokenRepository.save(entity);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                    throw new UnauthorizedException("Expired Refresh Token");
                }
                refreshToken = refreshTokenEntity.get();
                refreshToken.setRefreshToken(UUID.randomUUID().toString());
                refreshTokenRepository.save(refreshToken);
                return refreshToken;
            }
          throw  new UnauthorizedException("Expired Refresh Token");
        }else {
            refreshToken.setExpiryDate(Instant.now().plusSeconds(appConstant.getTokenExpirationRefresh()));
            refreshToken.setRefreshToken(UUID.randomUUID().toString());
            refreshToken.setUsername(userName);
            refreshToken.setLoginTime(LocalDateTime.now());
            refreshToken.setLogin(true);
            refreshTokenRepository.save(refreshToken);
            return refreshToken;
        }
    }


    public RefreshTokenEntity verifyExpiration(RefreshTokenEntity token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            return null;
        }

        return token;
    }


    public void deleteByUserId(String username) {
        refreshTokenRepository.deleteByUsername(username);
    }

    public void logout(TokenRefreshRequestDto request){
        if(request.getRefreshToken() == null) {
            throw new UnauthorizedException("Refresh token not found");
        }
        RefreshTokenEntity entity = findByRefreshToken(request.getRefreshToken());
        entity.setLogin(false);
        refreshTokenRepository.save(entity);

    }
}
