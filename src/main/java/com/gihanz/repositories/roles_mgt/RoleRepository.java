package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.FunctionEntity;
import com.gihanz.entities.roles_mgt.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
    boolean existsByCodeAndNameAndIdNot(String code, String name, Long id);
    Page<RoleEntity> findAll(Specification<RoleEntity> spec, Pageable pageable);

}
