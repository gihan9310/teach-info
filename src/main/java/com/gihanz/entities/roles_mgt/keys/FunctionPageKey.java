package com.gihanz.entities.roles_mgt.keys;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;


@Data
@Embeddable
public class FunctionPageKey implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long pageId;
    private Long functionId;
}
