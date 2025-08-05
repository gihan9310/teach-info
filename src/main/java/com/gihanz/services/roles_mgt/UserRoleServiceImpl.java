package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.UserRoleDto;
import com.gihanz.entities.roles_mgt.UserRoleEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.UserRoleRepository;
import com.gihanz.repositories.specification.UserRoleSpecification;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.UserRoleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements SuperService<UserRoleDto> {

    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRoleDto create(UserRoleDto dto) {

        if (userRoleRepository.existsByRoleIdAndUserId(dto.getRoleId(), dto.getUserId())) {
            throw new CustomException("Role already exists");
        }
        return UserRoleMapper.INSTANCE.toDto(userRoleRepository.save(UserRoleMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public UserRoleDto update(UserRoleDto dto) {
        return UserRoleMapper.INSTANCE.toDto(userRoleRepository.save(UserRoleMapper.INSTANCE.toEntity(dto)));

    }

    @Override
    public UserRoleDto delete(Long id) {
        UserRoleEntity userRole = userRoleRepository.findById(id).orElseThrow(() -> new CustomException("Role does not exist"));
        userRoleRepository.deleteById(id);
        return UserRoleMapper.INSTANCE.toDto(userRole);
    }

    @Override
    public List<UserRoleDto> findAll() {
        final List<UserRoleEntity> userRoles = userRoleRepository.findAll();
        return userRoles.stream().map(UserRoleMapper.INSTANCE::toDto).toList();
    }

    @Override
    public UserRoleDto findById(Long id) {
        return UserRoleMapper.INSTANCE.toDto(userRoleRepository.findById(id).orElseThrow(() -> new CustomException("User Role does not exist  ")));
    }

    @Override
    public Page<UserRoleDto> search(UserRoleDto dto, Pageable pageable) {
        return userRoleRepository.findAll(UserRoleSpecification.build(dto), pageable).map(UserRoleMapper.INSTANCE::toDto);

    }

    @Override
    public List<UserRoleDto> saveAsList(List<UserRoleDto> dtos) {
        return SuperService.super.saveAsList(dtos);
    }


    public List<UserRoleDto> assignRoleAsList(List<UserRoleDto> list) {
      return   list.stream().map(dto -> {
          return UserRoleMapper.INSTANCE.toDto(userRoleRepository.save(UserRoleMapper.INSTANCE.toEntity(dto)));
        }).toList();
    }
}
