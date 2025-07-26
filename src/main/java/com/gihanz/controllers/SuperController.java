package com.gihanz.controllers;

import com.gihanz.dtos.SuperDto;
import com.gihanz.utils.CustomPage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SuperController<T extends SuperDto> {

    @PostMapping("")
    ResponseEntity<T> save(@RequestBody T dto);

    @PutMapping
    ResponseEntity<T> update(@RequestBody T dto);

    @DeleteMapping("/{id}")
    ResponseEntity<T> delete(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<List<T>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<T> findById(@PathVariable("id") Long id);

    @PostMapping("/search")
    ResponseEntity<CustomPage<T>> search(@RequestBody T dto, @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable);

}
