package com.gihanz.dtos.roles_mgt;

import com.gihanz.dtos.SuperDto;
import lombok.*;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FunctionDto extends SuperDto {
    private String code;
    private String name;
    private String description;
}
