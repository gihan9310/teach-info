package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.PageDto;
import com.gihanz.entities.roles_mgt.PageEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-06T20:22:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class PageMapperImpl implements PageMapper {

    @Override
    public PageEntity toEntity(PageDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        PageEntity pageEntity = new PageEntity();

        if ( arg0.getId() != null ) {
            pageEntity.setId( arg0.getId() );
        }
        pageEntity.setCode( arg0.getCode() );
        pageEntity.setName( arg0.getName() );
        pageEntity.setDescription( arg0.getDescription() );

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
