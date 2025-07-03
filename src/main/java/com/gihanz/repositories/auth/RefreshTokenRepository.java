package com.gihanz.repositories.auth;

import com.gihanz.entities.auth.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity,Long> {

    Optional<RefreshTokenEntity> findByRefreshTokenAndLogin(String refreshToken, boolean loginIs);
    Optional<RefreshTokenEntity> findByUsername(String username);
    @Modifying
    void deleteByUsername(String username);
}
