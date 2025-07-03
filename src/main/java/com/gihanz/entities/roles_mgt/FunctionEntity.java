package com.gihanz.entities.roles_mgt;

import com.gihanz.dtos.SuperDto;
import com.gihanz.entities.SuperEntity;
import jakarta.persistence.Column;
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
@AllArgsConstructor
public class FunctionEntity extends SuperEntity {
    @Column(length = 20, nullable = false,unique = true,updatable = false)
    private String code;
    @Column(length = 50, nullable = false,unique = true)
    private String name;
    private String description;
}
