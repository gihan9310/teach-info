package com.gihanz.services.roles_mgt;
/*
 * Copyright (c) 2025 Gihan Rathnayaka. All rights reserved.
 */

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.entities.roles_mgt.PageEntity;
import com.gihanz.exceptions.CustomException;
import com.gihanz.repositories.roles_mgt.PageEntityRepository;
import com.gihanz.repositories.roles_mgt.PageFunctionRepository;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.PageFunctionMapper;
import com.gihanz.utils.mappers.PageMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PageServiceImpl implements SuperService<PageEntity, PageDto> {

    private final PageEntityRepository pageEntityRepository;
    private final PageFunctionRepository pageFunctionRepository;

    @Override
    public PageDto create(PageDto dto) {
        if (pageEntityRepository.existsByNameAndCode(dto.getName(), dto.getCode())) {
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

    /*
        Save Page with Functions
     */

    public PageDto createOrUpdateWithFunctions(PageDto dto) {
        if(dto.getFunctions()==null){
            throw new CustomException("Functions cannot be null");
        }
//        pageFunctionRepository.existsByFunctionCodeAndPageId()
        PageDto pageDto = PageMapper.INSTANCE.toDto(pageEntityRepository.save(PageMapper.INSTANCE.toEntity(dto)));
         pageFunctionRepository.saveAll(dto.getFunctions().stream().map(PageFunctionMapper.INSTANCE::toEntity).toList()).stream().map(PageFunctionMapper.INSTANCE::toDto).toList();
         pageDto.setFunctions(dto.getFunctions());
         return pageDto;
    }

}
