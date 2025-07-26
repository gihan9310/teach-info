package com.gihanz.dtos.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.SuperDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolePageFunctionDto extends SuperDto {
    private Long pageId;
    private Long roleId;
    private Long functionId;
    private boolean enabled = false;
}
