package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.PageEntity;
import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface PageFunctionRepository extends JpaRepository<PageFunctionEntity, Long> {

    boolean existsByFunctionIdAndPageId(Long funId, Long pageId);

    boolean existsAllByFunctionIdInAndPageId(List<Long> functionCodes, Long pageId);

    List<PageFunctionEntity> findAllByPageId(Long pageId);

    Page<PageFunctionEntity> findAll(Specification<PageFunctionEntity> spec, Pageable pageable);

}
