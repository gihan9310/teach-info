package com.gihanz.utils.mappers;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.UserRoleDto;
import com.gihanz.entities.roles_mgt.UserRoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoleMapper extends SuperMapper<UserRoleDto , UserRoleEntity>{
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);
}
