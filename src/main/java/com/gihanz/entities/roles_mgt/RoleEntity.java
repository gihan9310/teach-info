package com.gihanz.entities.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.entities.SuperEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "index_Role_index",columnList = "code,Id,name")

},name = "TBL_ROLES")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends SuperEntity {
    @Column(nullable = false,length = 40,unique = true)
    private String code;
    @Column(nullable = false,length = 70,unique = true)
    private String name;
    private String description;
    private Boolean enabled;

}
