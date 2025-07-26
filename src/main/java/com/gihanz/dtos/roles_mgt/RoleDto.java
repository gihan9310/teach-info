package com.gihanz.dtos.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gihanz.dtos.SuperDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto extends SuperDto {
    private String code;
    private String name;
    private String description;
    private Boolean enabled;
    private List<RolePageDto> pages;
}
