package com.gihanz.repositories.specification;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.entities.roles_mgt.PageEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PageSpecification {

    private PageSpecification() {}

    public static Specification<PageEntity> build(PageDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getCode() != null) {
                predicates.add(cb.equal(cb.lower(root.get("code")), dto.getCode().toLowerCase()));
            }
            if (dto.getName() != null) {
                predicates.add(cb.equal(cb.lower(root.get("name")), dto.getName().toLowerCase()));
            }
            if (dto.getDescription() != null) {
                predicates.add(cb.equal(cb.lower(root.get("description")), dto.getDescription().toLowerCase()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
