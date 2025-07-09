package com.gihanz.controllers;

import com.gihanz.dtos.UserDto;
import com.gihanz.services.impl.UserServiceImpl;
import com.gihanz.utils.CustomPage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RequestScope
@RestController
@RequestMapping(value = "users")
@AllArgsConstructor
public class UserController implements SuperController<UserDto>{

    private final UserServiceImpl userService;


    @Override
    public ResponseEntity<UserDto> save(UserDto userDto) {
        return ResponseEntity.ok(userService.create(userDto)) ;
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto userDto) {
        return ResponseEntity.ok(userService.create(userDto)) ;
    }

    @Override
    public ResponseEntity<UserDto> delete(Long id) {
        return ResponseEntity.ok(userService.delete(id)) ;
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll()) ;
    }

    @Override
    public ResponseEntity<UserDto> findById(Long id) {
        return ResponseEntity.ok(userService.findById(id)) ;
    }

    @Override
    public ResponseEntity<CustomPage<UserDto>> search(UserDto dto, Pageable pageable) {
        return null;
    }


}
