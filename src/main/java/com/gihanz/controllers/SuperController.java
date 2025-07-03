package com.gihanz.controllers;

import com.gihanz.dtos.SuperDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SuperController <T extends SuperDto> {

    @PostMapping("")
    ResponseEntity<T>  save(@RequestBody T t);
    @PutMapping
    ResponseEntity<T>  update(@RequestBody T t);
    @DeleteMapping("/{id}")
    ResponseEntity<T>  delete(@PathVariable("id") Long id);
    @GetMapping
    ResponseEntity<List<T>>   findAll();
    @GetMapping("/{id}")
    ResponseEntity<T>  findById(@PathVariable("id") Long id);

}
