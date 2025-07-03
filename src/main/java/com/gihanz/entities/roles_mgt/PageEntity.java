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
        @Index(name = "index_page_index",columnList = "code,Id")

},name = "TBL_PAGES")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageEntity extends SuperEntity {
    @Column(length = 20, nullable = false,unique = true,updatable = false)
    private String code;
    @Column(length = 50, nullable = false,unique = true)
    private String name;
    private String description;
}
