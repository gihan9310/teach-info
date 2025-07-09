package com.gihanz.utils.mappers;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.RoleDto;
import com.gihanz.entities.roles_mgt.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends SuperMapper<RoleDto, RoleEntity> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}
