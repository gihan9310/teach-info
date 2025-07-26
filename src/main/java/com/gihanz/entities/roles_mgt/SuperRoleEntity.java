package com.gihanz.entities.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.entities.SuperEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class SuperRoleEntity extends SuperEntity {
    @Column(nullable = false,length = 40,unique = true)
    private String code;
    @Column(nullable = false,length = 70,unique = true)
    private String name;
    private String description;
}
