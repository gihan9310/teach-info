package com.gihanz.repositories.roles_mgt;

import com.gihanz.entities.roles_mgt.FunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
public interface FunctionEntityRepository extends JpaRepository<FunctionEntity, Long> {

 boolean existsByNameAndCode(String name, String code);
 boolean existsByNameAndIdNot(String name, Long id);

}
