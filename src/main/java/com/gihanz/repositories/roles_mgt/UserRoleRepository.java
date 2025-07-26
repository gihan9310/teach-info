package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.UserRoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {

    boolean existsByRoleIdAndUserId(Long roleId, Long userId);
    Page<UserRoleEntity>  findAll(Specification<UserRoleEntity> spec, Pageable pageable);
}
