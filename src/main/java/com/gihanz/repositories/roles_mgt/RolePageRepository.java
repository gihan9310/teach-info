package com.gihanz.repositories.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.entities.roles_mgt.RolePageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePageRepository extends JpaRepository<RolePageEntity, Long> {

    boolean existsByRoleIdAndPageIdAndIdNot(Long roleId, Long pageId, Long id);
}
