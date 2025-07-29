package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.RoleDto;
import com.gihanz.entities.roles_mgt.RoleEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-26T19:00:37+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleEntity toEntity(RoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( dto.getId() );
        roleEntity.setCode( dto.getCode() );
        roleEntity.setName( dto.getName() );
        roleEntity.setDescription( dto.getDescription() );
        roleEntity.setEnabled( dto.getEnabled() );

        return roleEntity;
    }

    @Override
    public RoleDto toDto(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( roleEntity.getId() );
        roleDto.setCode( roleEntity.getCode() );
        roleDto.setName( roleEntity.getName() );
        roleDto.setDescription( roleEntity.getDescription() );
        roleDto.setEnabled( roleEntity.getEnabled() );

        return roleDto;
    }
}
