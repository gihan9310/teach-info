package com.gihanz.controllers.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.controllers.SuperController;
import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.services.roles_mgt.PageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("pages")
@AllArgsConstructor
public class PageController implements SuperController<PageDto> {

    private final PageServiceImpl pageService;

    @Override
    public ResponseEntity<PageDto> save(PageDto dto) {
        return ResponseEntity.ok(pageService.create(dto));
    }
    @Override
    public ResponseEntity<PageDto> update(PageDto dto) {
        return ResponseEntity.ok(pageService.update(dto));
    }
    @Override
    public ResponseEntity<PageDto> delete(Long id) {
        return ResponseEntity.ok(pageService.delete(id));
    }

    @Override
    public ResponseEntity<List<PageDto>> findAll() {
        return ResponseEntity.ok(pageService.findAll());
    }

    @Override
    public ResponseEntity<PageDto> findById(Long id) {
        return ResponseEntity.ok(pageService.findById(id));
    }

    @PostMapping("/save-with-functions")
    public ResponseEntity<PageDto> saveWithFullData( @RequestBody PageDto dto) {
        return ResponseEntity.ok(pageService.createOrUpdateWithFunctions(dto));
    }

}
