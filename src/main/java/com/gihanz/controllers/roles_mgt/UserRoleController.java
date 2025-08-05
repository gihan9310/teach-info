package com.gihanz.controllers.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.controllers.SuperController;
import com.gihanz.dtos.roles_mgt.UserRoleDto;
import com.gihanz.services.roles_mgt.UserRoleServiceImpl;
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
@RequestMapping(value = "users-roles")
@AllArgsConstructor
public class UserRoleController implements SuperController<UserRoleDto> {

    private final UserRoleServiceImpl userRoleService;


    @Override
    public ResponseEntity<UserRoleDto> save(UserRoleDto dto) {
        return ResponseEntity.ok(userRoleService.create(dto));
    }

    @Override
    public ResponseEntity<UserRoleDto> update(UserRoleDto dto) {
        return ResponseEntity.ok(userRoleService.update(dto));
    }

    @Override
    public ResponseEntity<UserRoleDto> delete(Long id) {
        return ResponseEntity.ok(userRoleService.delete(id));
    }

    @Override
    public ResponseEntity<List<UserRoleDto>> findAll() {
        return ResponseEntity.ok(userRoleService.findAll());
    }

    @Override
    public ResponseEntity<UserRoleDto> findById(Long id) {
        return ResponseEntity.ok(userRoleService.findById(id));
    }

    @Override
    public ResponseEntity<CustomPage<UserRoleDto>> search(UserRoleDto dto, Pageable pageable) {
        return ResponseEntity.ok(new CustomPage<>(userRoleService.search(dto, pageable)));
    }

    @PostMapping("create-user-roles")
    public ResponseEntity<List<UserRoleDto>> assignRoleAsList(@RequestBody List<UserRoleDto> list) {
        log.info("assignRoleAsList {}", list);
        return ResponseEntity.ok(userRoleService.assignRoleAsList(list));
    }

}
