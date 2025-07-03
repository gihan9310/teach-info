package com.gihanz.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

//    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*")); // Set your front-end app URL
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*","Access-Control-Allow-Headers", "Host", "Content-Type","X-Amz-Date","Authorization","X-Api-Key","X-Amz-Security-Token","X-XSRF-TOKEN", "Origin", "Access-Control-Request-Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Access-Control-Allow-Origin", "access-control-allow-origin", "Access-Control-Allow-Credentials", "access-control-allow-credentials", "Access-Control-Allow-Headers", "access-control-allow-headers", "Access-Control-Allow-Methods", "access-control-allow-methods"));
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setMaxAge(3600L); // Cache preflight response for an hour
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsWebFilter(source);
    }
}
