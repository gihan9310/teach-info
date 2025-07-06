package com.gihanz.entities.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */


import com.gihanz.entities.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "index_page_func_index",columnList = "pageId,functionId")

},name = "TBL_PAGE_FUNCTIONS")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageFunctionEntity extends SuperEntity {

    private String pageCode;
    private String functionCode;
    private Long pageId;
    private Long functionId;
}
