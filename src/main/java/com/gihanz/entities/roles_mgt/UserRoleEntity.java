package com.gihanz.entities.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.SuperDto;
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
        @Index(name = "index_user_role_index",columnList = "userId,roleId")

},name = "TBL_USERS_ROLES")
public class UserRoleEntity extends SuperEntity {

    private Long userId;
    private Long roleId;
    private Boolean enable;
}
