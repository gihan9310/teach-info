package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.RoleDto;
import com.gihanz.entities.roles_mgt.RoleEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.RoleRepository;
import com.gihanz.repositories.specification.RoleSpecification;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.RoleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class RoleServiceImpl implements SuperService< RoleDto> {

    private final RoleRepository roleRepository;

    @Override
    public RoleDto create(RoleDto dto) {
       return save(dto);
    }

    @Override
    public RoleDto update(RoleDto dto) {
        //checked
        return save(dto);
    }

    @Override
    public RoleDto delete(Long id) {

        Optional<RoleEntity> entity = roleRepository.findById(id);
        if (entity.isEmpty()) {
            throw new CustomException("Role not found");
        }
        roleRepository.delete(entity.get());
        return RoleMapper.INSTANCE.toDto(entity.get());
    }

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream().map(RoleMapper.INSTANCE::toDto).toList();
    }

    @Override
    public RoleDto findById(Long id) {
        RoleEntity entity = roleRepository.findById(id).orElseThrow(() -> new CustomException("Role not found"));
        return RoleMapper.INSTANCE.toDto(entity);
    }

    @Override
    public Page<RoleDto> search(RoleDto dto, Pageable pageable) {
        return roleRepository.findAll(RoleSpecification.build(dto), pageable).map(RoleMapper.INSTANCE::toDto);
    }

    private RoleDto  save(RoleDto dto) {
        if (roleRepository.existsByCodeAndNameAndIdNot(dto.getCode(), dto.getName(), dto.getId())) {
            throw new CustomException("Role already exists");
        }
        return RoleMapper.INSTANCE.toDto(roleRepository.save(RoleMapper.INSTANCE.toEntity(dto)));
    }
}
