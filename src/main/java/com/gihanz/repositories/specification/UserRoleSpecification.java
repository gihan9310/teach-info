package com.gihanz.repositories.specification;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.UserRoleDto;
import com.gihanz.entities.roles_mgt.UserRoleEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserRoleSpecification {

    private UserRoleSpecification() {}

    public static Specification<UserRoleEntity> build(UserRoleDto dto) {

        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getRoleId() != null) {
                predicates.add(cb.equal(cb.lower(root.get("roleId")), dto.getRoleId()));
            }
            if (dto.getUserId() != null) {
                predicates.add(cb.equal(cb.lower(root.get("userId")), dto.getUserId()));
            }
            if (dto.getEnable() != null) {
                predicates.add(cb.equal(cb.lower(root.get("enable")), dto.getEnable()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
