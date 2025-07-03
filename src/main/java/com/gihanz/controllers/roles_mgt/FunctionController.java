package com.gihanz.controllers.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.controllers.SuperController;
import com.gihanz.dtos.roles_mgt.FunctionDto;
import com.gihanz.services.roles_mgt.FunctionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("functions")
@AllArgsConstructor
public class FunctionController implements SuperController<FunctionDto> {

    private final FunctionServiceImpl functionService;

    @Override
    public ResponseEntity<FunctionDto> save(FunctionDto functionDto) {
        return ResponseEntity.ok(functionService.create(functionDto));
    }

    @Override
    public ResponseEntity<FunctionDto> update(FunctionDto functionDto) {
        return ResponseEntity.ok(functionService.update(functionDto));
    }

    @Override
    public ResponseEntity<FunctionDto> delete(Long id) {
        return ResponseEntity.ok(functionService.delete(id));
    }

    @Override
    public ResponseEntity<List<FunctionDto>> findAll() {
        return ResponseEntity.ok(functionService.findAll());
    }

    @Override
    public ResponseEntity<FunctionDto> findById(Long id) {
        return ResponseEntity.ok(functionService.findById(id));
    }
}
