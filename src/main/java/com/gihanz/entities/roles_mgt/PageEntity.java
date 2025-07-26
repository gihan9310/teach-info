package com.gihanz.entities.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "index_page_index", columnList = "code,Id")

}, name = "TBL_PAGES")
@ToString
@NoArgsConstructor
public class PageEntity extends SuperRoleEntity {
}
