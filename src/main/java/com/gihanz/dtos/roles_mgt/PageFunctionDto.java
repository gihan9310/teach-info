package com.gihanz.dtos.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */


import com.gihanz.dtos.SuperDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageFunctionDto extends SuperDto {

    private String pageCode;
    private String functionCode;
    private Long pageId;
    private Long functionId;
}
