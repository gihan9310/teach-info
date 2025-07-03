package com.gihanz.utils.mappers;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.entities.roles_mgt.PageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageMapper extends SuperMapper<PageDto, PageEntity> {
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);
}
