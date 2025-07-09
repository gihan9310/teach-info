package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.FunctionDto;
import com.gihanz.entities.roles_mgt.FunctionEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.FunctionEntityRepository;
import com.gihanz.repositories.specification.FunctionSpecification;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.FunctionMapper;
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
public class FunctionServiceImpl implements SuperService< FunctionDto> {

    private final FunctionEntityRepository functionEntityRepository;

    @Override
    public FunctionDto create(FunctionDto dto) {
        log.info("Create function {}", dto.getName());
        if (functionEntityRepository.existsByNameAndCode(dto.getName(), dto.getCode())) {
            throw new CustomException("Function already exists");
        }
        return FunctionMapper.INSTANCE.toDto(functionEntityRepository.save(FunctionMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public FunctionDto update(FunctionDto dto) {

        if (functionEntityRepository.existsByNameAndIdNot(dto.getName(), dto.getId())) {
            throw new CustomException("Function already exists");
        }
        return FunctionMapper.INSTANCE.toDto(functionEntityRepository.save(FunctionMapper.INSTANCE.toEntity(dto)));

    }

    @Override
    public FunctionDto delete(Long id) {
        Optional<FunctionEntity> entity = functionEntityRepository.findById(id);
        if (entity.isPresent()) {
            functionEntityRepository.deleteById(id);
            return FunctionMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Override
    public List<FunctionDto> findAll() {
        return functionEntityRepository.findAll().stream().map(FunctionMapper.INSTANCE::toDto).toList();
    }


    @Override
    public FunctionDto findById(Long id) {
        return functionEntityRepository.findById(id).map(FunctionMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    public Page<FunctionDto> search(FunctionDto dto, Pageable pageable) {
        return functionEntityRepository.findAll(FunctionSpecification.build(dto), pageable)
                .map(FunctionMapper.INSTANCE::toDto);
    }
}
