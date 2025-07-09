package com.gihanz.repositories.specification;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageFunctionDto;
import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PageFunctionSpecification  {

    private PageFunctionSpecification(){}

    public static Specification<PageFunctionEntity> build(PageFunctionDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getFunctionCode() != null && !dto.getFunctionCode().isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("functionCode")), dto.getFunctionCode().toLowerCase()));
            }
            if (dto.getPageCode() != null) {
                predicates.add(cb.equal(cb.lower(root.get("pageCode")), dto.getPageCode().toLowerCase()));
            }
            if (dto.getPageId() != null) {
                predicates.add(cb.equal(cb.lower(root.get("pageId")), dto.getPageId()));
            }
            if (dto.getFunctionId() != null) {
                predicates.add(cb.equal(cb.lower(root.get("functionId")), dto.getFunctionId()));
            }
            if (dto.getId() != null) {
                predicates.add(cb.equal(cb.lower(root.get("id")), dto.getId()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
