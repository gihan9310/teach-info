package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.FunctionDto;
import com.gihanz.entities.roles_mgt.FunctionEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T22:14:11+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class FunctionMapperImpl implements FunctionMapper {

    @Override
    public FunctionDto toDto(FunctionEntity e) {
        if ( e == null ) {
            return null;
        }

        FunctionDto functionDto = new FunctionDto();

        functionDto.setId( e.getId() );
        functionDto.setCode( e.getCode() );
        functionDto.setName( e.getName() );
        functionDto.setDescription( e.getDescription() );

        return functionDto;
    }

    @Override
    public FunctionEntity toEntity(FunctionDto dto) {
        if ( dto == null ) {
            return null;
        }

        FunctionEntity functionEntity = new FunctionEntity();

        if ( dto.getId() != null ) {
            functionEntity.setId( dto.getId() );
        }
        functionEntity.setCode( dto.getCode() );
        functionEntity.setName( dto.getName() );
        functionEntity.setDescription( dto.getDescription() );

        return functionEntity;
    }
}
