package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageFunctionDto;
import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.FunctionEntityRepository;
import com.gihanz.repositories.roles_mgt.PageEntityRepository;
import com.gihanz.repositories.roles_mgt.PageFunctionRepository;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.PageFunctionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PageFunctionServiceImpl implements SuperService<PageFunctionEntity, PageFunctionDto> {

    private final PageFunctionRepository pageFunctionRepository;
    private final PageEntityRepository pageEntityRepository;
    private final FunctionEntityRepository functionEntityRepository;


    @Override
    public PageFunctionDto create(PageFunctionDto dto) {
        if (pageFunctionRepository.existsByFunctionIdAndFunctionId(dto.getFunctionId(), dto.getPageId())) {
            throw new CustomException("Function already exists");
        }
        return PageFunctionMapper.INSTANCE.toDto(pageFunctionRepository.save(PageFunctionMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public PageFunctionDto update(PageFunctionDto dto) {
//        if (pageFunctionRepository.existsByFunctionCodeAndPageId(dto.getFunctionId(), dto.getPageId())) {
//            throw new CustomException("Function already exists");
//        }
        return PageFunctionMapper.INSTANCE.toDto(pageFunctionRepository.save(PageFunctionMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public PageFunctionDto delete(Long id) {
        Optional<PageFunctionEntity> entity = pageFunctionRepository.findById(id);
        if (entity.isEmpty()) {
            throw new CustomException("Record not found");
        }
        pageFunctionRepository.delete(entity.get());
        return PageFunctionMapper.INSTANCE.toDto(entity.get());
    }

    @Override
    public List<PageFunctionDto> findAll() {
        return pageFunctionRepository.findAll().stream().map(PageFunctionMapper.INSTANCE::toDto).toList();
    }

    @Override
    public PageFunctionDto findById(Long id) {
        return pageFunctionRepository.findById(id).map(PageFunctionMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    public List<PageFunctionDto> saveAsList(List<PageFunctionDto> dtos) {
        return pageFunctionRepository.saveAll(dtos.stream().map(PageFunctionMapper.INSTANCE::toEntity).toList()).stream().map(PageFunctionMapper.INSTANCE::toDto).toList();
    }
}
