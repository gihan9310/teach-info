package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.PageFunctionDto;
import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
@Mapper
public interface PageFunctionMapper extends SuperMapper<PageFunctionDto, PageFunctionEntity>{

    PageFunctionMapper INSTANCE = Mappers.getMapper(PageFunctionMapper.class);

    @Mapping(target = "active", ignore = true)
    @Override
    PageFunctionDto toDto(PageFunctionEntity pageFunctionEntity);
}
