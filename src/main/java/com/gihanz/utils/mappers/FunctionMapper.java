package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.FunctionDto;
import com.gihanz.entities.roles_mgt.FunctionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
@Mapper
public interface FunctionMapper extends SuperMapper<FunctionDto, FunctionEntity> {
    FunctionMapper INSTANCE = Mappers.getMapper(FunctionMapper.class);
}
