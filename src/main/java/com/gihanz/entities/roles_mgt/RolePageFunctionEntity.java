package com.gihanz.entities.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.entities.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "index_Role_Page_FUNCTION_index",columnList = "pageId,roleId")

},name = "TBL_ROLES_PAGES_FUNCTIONS")
public class RolePageFunctionEntity extends SuperEntity {
    private Long pageId;
    private Long roleId;
    private Long functionId;
    private boolean enabled = false;
}
