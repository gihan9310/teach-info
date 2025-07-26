package com.gihanz.controllers.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.controllers.SuperController;
import com.gihanz.dtos.roles_mgt.RoleDto;
import com.gihanz.services.roles_mgt.RoleServiceImpl;
import com.gihanz.utils.CustomPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "roles")
@AllArgsConstructor
public class RoleController implements SuperController<RoleDto> {

    private final RoleServiceImpl roleServiceImpl;

    @Override
    public ResponseEntity<RoleDto> save(RoleDto roleDto) {
        return ResponseEntity.ok(roleServiceImpl.create(roleDto));
    }

    @Override
    public ResponseEntity<RoleDto> update(RoleDto roleDto) {
        return ResponseEntity.ok(roleServiceImpl.create(roleDto));
    }

    @Override
    public ResponseEntity<RoleDto> delete(Long id) {
        return ResponseEntity.ok(roleServiceImpl.delete(id));
    }

    @Override
    public ResponseEntity<List<RoleDto>> findAll() {
        return ResponseEntity.ok(roleServiceImpl.findAll());
    }

    @Override
    public ResponseEntity<RoleDto> findById(Long id) {
        return ResponseEntity.ok(roleServiceImpl.findById(id));
    }

    @Override
    public ResponseEntity<CustomPage<RoleDto>> search(RoleDto dto, Pageable pageable) {
        return ResponseEntity.ok(new CustomPage<>(roleServiceImpl.search(dto, pageable)));
    }

    @PostMapping("create-role-with-page-and-function")
    public ResponseEntity<RoleDto> createRoleWithFunction(@RequestBody RoleDto roleDto) {
        log.info("createRoleWithFunction {}", roleDto.toString());
        return ResponseEntity.ok(roleServiceImpl.createRoleWithPageFunction(roleDto));
    }
}
