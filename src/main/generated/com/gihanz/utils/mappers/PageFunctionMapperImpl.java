package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.PageFunctionDto;
import com.gihanz.entities.roles_mgt.PageFunctionEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-26T19:00:37+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class PageFunctionMapperImpl implements PageFunctionMapper {

    @Override
    public PageFunctionDto toDto(PageFunctionEntity e) {
        if ( e == null ) {
            return null;
        }

        PageFunctionDto pageFunctionDto = new PageFunctionDto();

        pageFunctionDto.setId( e.getId() );
        pageFunctionDto.setPageCode( e.getPageCode() );
        pageFunctionDto.setFunctionCode( e.getFunctionCode() );
        pageFunctionDto.setPageId( e.getPageId() );
        pageFunctionDto.setFunctionId( e.getFunctionId() );

        return pageFunctionDto;
    }

    @Override
    public PageFunctionEntity toEntity(PageFunctionDto dto) {
        if ( dto == null ) {
            return null;
        }

        PageFunctionEntity pageFunctionEntity = new PageFunctionEntity();

        pageFunctionEntity.setId( dto.getId() );
        pageFunctionEntity.setPageCode( dto.getPageCode() );
        pageFunctionEntity.setFunctionCode( dto.getFunctionCode() );
        pageFunctionEntity.setPageId( dto.getPageId() );
        pageFunctionEntity.setFunctionId( dto.getFunctionId() );

        return pageFunctionEntity;
    }
}
