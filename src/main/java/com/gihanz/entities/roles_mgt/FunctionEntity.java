package com.gihanz.entities.roles_mgt;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;

/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "index_functions_index",columnList = "code,Id")

},name = "TBL_R_FUNCTIONS")
@ToString
@NoArgsConstructor
public class FunctionEntity extends SuperRoleEntity {

}
