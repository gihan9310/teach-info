package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.entities.roles_mgt.PageEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-26T19:00:37+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class PageMapperImpl implements PageMapper {

    @Override
    public PageEntity toEntity(PageDto dto) {
        if ( dto == null ) {
            return null;
        }

        PageEntity pageEntity = new PageEntity();

        pageEntity.setId( dto.getId() );
        pageEntity.setCode( dto.getCode() );
        pageEntity.setName( dto.getName() );
        pageEntity.setDescription( dto.getDescription() );

        return pageEntity;
    }

    @Override
    public PageDto toDto(PageEntity pageEntity) {
        if ( pageEntity == null ) {
            return null;
        }

        PageDto pageDto = new PageDto();

        pageDto.setId( pageEntity.getId() );
        pageDto.setCode( pageEntity.getCode() );
        pageDto.setName( pageEntity.getName() );
        pageDto.setDescription( pageEntity.getDescription() );

        return pageDto;
    }
}
