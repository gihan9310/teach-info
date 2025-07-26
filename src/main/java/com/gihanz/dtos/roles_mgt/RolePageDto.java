package com.gihanz.dtos.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.entities.SuperEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolePageDto extends SuperEntity {

    private Long pageId;
    private Long roleId;
    private boolean enabled = false;
    private List<RolePageFunctionDto> functions;

}
