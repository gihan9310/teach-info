package com.gihanz.dtos.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.SuperDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto extends SuperDto {

    private Long userId;
    private Long roleId;
    private Boolean enable;
}
