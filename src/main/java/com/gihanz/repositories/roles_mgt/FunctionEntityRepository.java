package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.FunctionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface FunctionEntityRepository extends JpaRepository<FunctionEntity, Long> {

    boolean existsByNameAndCode(String name, String code);

    boolean existsByNameAndIdNot(String name, Long id);

    Page<FunctionEntity> findAll(Specification<FunctionEntity> spec, Pageable pageable);


}
