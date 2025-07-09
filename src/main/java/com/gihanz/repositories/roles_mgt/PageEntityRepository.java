package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.PageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface PageEntityRepository extends JpaRepository<PageEntity, Long> {
    boolean existsByNameAndCodeAndIdNot(String name, String code,Long id);
    boolean existsByNameAndIdNot(String name, Long id);
    Page<PageEntity> findAll(Specification<PageEntity> spec, Pageable pageable);
}
