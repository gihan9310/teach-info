package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.dtos.roles_mgt.PageFunctionDto;
import com.gihanz.entities.roles_mgt.FunctionEntity;
import com.gihanz.entities.roles_mgt.PageEntity;
import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.FunctionEntityRepository;
import com.gihanz.repositories.roles_mgt.PageEntityRepository;
import com.gihanz.repositories.roles_mgt.PageFunctionRepository;
import com.gihanz.repositories.specification.PageSpecification;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.PageFunctionMapper;
import com.gihanz.utils.mappers.PageMapper;
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
public class PageServiceImpl implements SuperService< PageDto> {

    private final PageEntityRepository pageEntityRepository;
    private final PageFunctionRepository pageFunctionRepository;
    private final FunctionEntityRepository functionEntityRepository;

    @Override
    public PageDto create(PageDto dto) {
        if (pageEntityRepository.existsByNameAndCodeAndIdNot(dto.getName(), dto.getCode(), dto.getId())) {
            throw new CustomException("Page already exists");
        }
        return PageMapper.INSTANCE.toDto(pageEntityRepository.save(PageMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public PageDto update(PageDto dto) {
        if (pageEntityRepository.existsByNameAndIdNot(dto.getName(), dto.getId())) {
            throw new CustomException("Function already exists");
        }
        return PageMapper.INSTANCE.toDto(pageEntityRepository.save(PageMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public PageDto delete(Long id) {
        Optional<PageEntity> entity = pageEntityRepository.findById(id);
        if (entity.isPresent()) {
            pageEntityRepository.deleteById(id);
            return PageMapper.INSTANCE.toDto(entity.get());
        }
        return null;
    }

    @Override
    public List<PageDto> findAll() {
        return pageEntityRepository.findAll().stream().map(PageMapper.INSTANCE::toDto).toList();
    }

    @Override
    public PageDto findById(Long id) {
        return pageEntityRepository.findById(id).map(PageMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    public Page<PageDto> search(PageDto dto, Pageable pageable) {
        return pageEntityRepository.findAll(PageSpecification.build(dto), pageable).map(p -> {
            PageDto pageDto = PageMapper.INSTANCE.toDto(p);
            pageDto.setFunctions(pageFunctionRepository.findAllByPageId(p.getId()).stream().map(PageFunctionMapper.INSTANCE::toDto).toList());
            return pageDto;
        });
    }

    /*
        Save Page with Functions
     */

    @Transactional
    public PageDto createOrUpdateWithFunctions(PageDto dto) {
        if (dto.getFunctions() == null) {
            throw new CustomException("Functions cannot be null");
        }
        if (pageEntityRepository.existsByNameAndCodeAndIdNot(dto.getName(), dto.getCode(), dto.getId())) {
            throw new CustomException("Page already exists");
        }
        PageDto pageDto = PageMapper.INSTANCE.toDto(pageEntityRepository.save(PageMapper.INSTANCE.toEntity(dto)));
        List<Long> functionIds = dto.getFunctions().stream().map(PageFunctionDto::getFunctionId).toList();

        if (pageFunctionRepository.existsAllByFunctionIdInAndPageId(functionIds, pageDto.getId())) {
            throw new CustomException("Function already exists");
        }

        List<PageFunctionEntity> entities = pageFunctionRepository.saveAll(dto.getFunctions().stream().map(res -> {
            res.setPageId(pageDto.getId());
            Optional<FunctionEntity> functionEntity = functionEntityRepository.findById(res.getFunctionId());
            if (functionEntity.isEmpty()) {
                throw new CustomException("Function does not exist");
            }
            res.setFunctionCode(functionEntity.get().getCode());
            res.setPageCode(pageDto.getCode());
            return PageFunctionMapper.INSTANCE.toEntity(res);
        }).toList());
        pageDto.setFunctions(entities.stream().map(PageFunctionMapper.INSTANCE::toDto).toList());
        return pageDto;
    }

    public List<PageDto> findAllWithFunctions() {
        List<PageDto> list = pageEntityRepository.findAll().stream().map(PageMapper.INSTANCE::toDto).toList();
        List<PageDto> result = new ArrayList<>();
        for (PageDto p : list) {
            p.setFunctions((pageFunctionRepository.findAllByPageId(p.getId()).stream().map(PageFunctionMapper.INSTANCE::toDto).toList()));
            result.add(p);
        }
        return result;

    }

}
