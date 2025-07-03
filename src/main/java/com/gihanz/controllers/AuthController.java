package com.gihanz.controllers;

import com.gihanz.configs.AppConstant;
import com.gihanz.configs.security.TokenProvider;
import com.gihanz.services.auth.UserSecurityService;
import com.gihanz.dtos.UserDto;
import com.gihanz.dtos.auth.LoginRequestDto;
import com.gihanz.dtos.auth.LoginResponseDto;
import com.gihanz.dtos.auth.TokenRefreshRequestDto;
import com.gihanz.entities.auth.RefreshTokenEntity;
import com.gihanz.exceptions.UnauthorizedException;
import com.gihanz.services.auth.RefreshTokenService;
import com.gihanz.utils.auth.EncryptDecrepitUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserSecurityService userSecurityService;
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final EncryptDecrepitUtils encryptDecrepitUtils;
    private final AppConstant appConstant;

    @PostMapping("/login")
    LoginResponseDto login(@RequestBody LoginRequestDto loginRequest) {
        UserDetails userDetails = userSecurityService.loadUserByUsername(loginRequest.getUsername());
        if (!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new UnauthorizedException("Username or password is incorrect");
        }
        String token = tokenProvider.generateToken(userDetails, appConstant.getTokenExpiration());
        RefreshTokenEntity refreshToken = refreshTokenService.createRefreshToken(loginRequest.getUsername(), false);
        LoginResponseDto loginResponseDto = getTokenEntity();
        loginResponseDto.setToken(token);
        loginResponseDto.setUsername(loginRequest.getUsername());
        loginResponseDto.setRefreshToken(encryptDecrepitUtils.encode(refreshToken.getRefreshToken() + "," + loginRequest.getUsername()));
        log.info("RESFRESH TOKEN: {}", loginResponseDto.getRefreshToken());
        return loginResponseDto;
    }

    @PostMapping("/refresh-token")
    public LoginResponseDto refreshtoken(@Validated @RequestBody TokenRefreshRequestDto request) {
        log.info("REFRESH TOKEN: {}", request.getRefreshToken());
        if (request.getRefreshToken() == null || request.getRefreshToken().equals("null")) {
            throw new UnauthorizedException("Invalid refresh token");
        }
        RefreshTokenEntity entity = refreshTokenService.findByRefreshToken(request.getRefreshToken());
        if (entity == null) {
            throw new UnauthorizedException("Invalid refresh token");
        }
        UserDetails userDetails = userSecurityService.loadUserByUsername(entity.getUsername());
        String token = tokenProvider.generateToken(userDetails, appConstant.getTokenExpiration());
        RefreshTokenEntity refreshToken = refreshTokenService.createRefreshToken(entity.getUsername(), true);
        LoginResponseDto loginResponseDto = getTokenEntity();
        loginResponseDto.setToken(token);
        loginResponseDto.setUsername(entity.getUsername());
        loginResponseDto.setRefreshToken(encryptDecrepitUtils.encode(refreshToken.getRefreshToken() + "," + entity.getUsername()));
        log.info("RESFRESH TOKEN: {}", loginResponseDto.getRefreshToken());
        return loginResponseDto;


    }

    @PostMapping("/register")
    UserDto login(@RequestBody UserDto dto) {
        return userSecurityService.createUser(dto);
    }


    @PostMapping("logout")
    @ResponseStatus(HttpStatus.OK)
    public void logOut(@Validated @RequestBody TokenRefreshRequestDto request) {
        refreshTokenService.logout(request);
    }

    private LoginResponseDto getTokenEntity(){
        return new LoginResponseDto();
    }
}
