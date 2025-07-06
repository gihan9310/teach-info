package com.gihanz.dtos.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.SuperDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PageDto extends SuperDto {
    private String code;
    private String name;
    private String description;
    private List<PageFunctionDto> functions;
}
