package com.gihanz.entities.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity(name = "Refresh_Token_Entity")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenEntity {

    @Id
    private Long userId;
    @Column(nullable = false, unique = true)
    private String refreshToken;
    @Column(nullable = false)
    private Instant expiryDate;
    private String username;
    private LocalDateTime loginTime;
    private boolean login;
    private long refreshTokenExpiresIn;

}
