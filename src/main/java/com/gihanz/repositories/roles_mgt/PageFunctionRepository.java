package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface PageFunctionRepository extends JpaRepository<PageFunctionEntity,Long> {

    boolean existsByFunctionIdAndFunctionId(Long funId, Long pageId);
//    boolean existsByFunctionId
}
