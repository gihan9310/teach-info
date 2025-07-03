package com.gihanz.configs.filters;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.entities.UserEntity;
import com.gihanz.repositories.UserRepository;
import com.gihanz.services.auth.UserSecurityService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final UserSecurityService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthProvider(UserRepository userRepository, @Lazy UserSecurityService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
