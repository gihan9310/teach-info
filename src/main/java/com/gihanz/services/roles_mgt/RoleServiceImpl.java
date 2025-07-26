package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.dtos.roles_mgt.PageFunctionDto;
import com.gihanz.dtos.roles_mgt.RoleDto;
import com.gihanz.entities.roles_mgt.RoleEntity;
import com.gihanz.entities.roles_mgt.RolePageEntity;
import com.gihanz.entities.roles_mgt.RolePageFunctionEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.RolePageFunctionRepository;
import com.gihanz.repositories.roles_mgt.RolePageRepository;
import com.gihanz.repositories.roles_mgt.RoleRepository;
import com.gihanz.repositories.specification.RoleSpecification;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.RoleMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class RoleServiceImpl implements SuperService<RoleDto> {

    private final RoleRepository roleRepository;
    private final RolePageFunctionRepository rolePageFunctionRepository;
    private final RolePageRepository rolePageRepository;

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

    private RoleDto save(RoleDto dto) {
        if (roleRepository.existsByCodeAndNameAndIdNot(dto.getCode(), dto.getName(), dto.getId())) {
            throw new CustomException("Role already exists");
        }
        return RoleMapper.INSTANCE.toDto(roleRepository.save(RoleMapper.INSTANCE.toEntity(dto)));
    }

    @Transactional
    public RoleDto createRoleWithPageFunction(RoleDto dto) {
        if (roleRepository.existsByCodeAndNameAndIdNot(dto.getCode(), dto.getName(), dto.getId())) {
            throw new CustomException("Role already exists");
        }
        RoleDto roleDto = RoleMapper.INSTANCE.toDto(roleRepository.save(RoleMapper.INSTANCE.toEntity(dto)));

        if (dto.getPages() == null) {
            throw new CustomException("Pages is null");
        }

        dto.getPages().forEach(page -> {

            if (rolePageRepository.existsByRoleIdAndPageIdAndIdNot(page.getId(), roleDto.getId(), dto.getId())) {
                throw new CustomException("Page already exists");
            }

            Long roleId = roleDto.getId();
            RolePageEntity rolePageEntity = new RolePageEntity();
            rolePageEntity.setId(page.getId());
            rolePageEntity.setPageId(page.getId());
            rolePageEntity.setEnabled(page.isEnabled());
            rolePageEntity.setRoleId(roleId);
            RolePageEntity pageEntity = rolePageRepository.save(rolePageEntity);
            if (page.getFunctions() != null) {
                page.getFunctions().forEach(fun -> {
                    System.out.println("fun.getId()" +fun.getId());
                    RolePageFunctionEntity function = new RolePageFunctionEntity();
                    function.setId(fun.getId());
                    function.setRoleId(roleId);
                    function.setPageId(pageEntity.getPageId());
                    function.setEnabled(fun.isEnabled());
                    rolePageFunctionRepository.save(function);
                });
            }

        });
        return roleDto;
    }
}
