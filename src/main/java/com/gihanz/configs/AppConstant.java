package com.gihanz.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class AppConstant {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token-expiration-seconds}")
    private long tokenExpiration;

    @Value("${jwt.token-expiration-seconds-refresh}")
    private long tokenExpirationRefresh;




}
