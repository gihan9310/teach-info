package com.gihanz.utils.mappers;

import com.gihanz.dtos.roles_mgt.UserRoleDto;
import com.gihanz.entities.roles_mgt.UserRoleEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-26T20:54:36+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRoleDto toDto(UserRoleEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserRoleDto userRoleDto = new UserRoleDto();

        userRoleDto.setId( arg0.getId() );
        userRoleDto.setUserId( arg0.getUserId() );
        userRoleDto.setRoleId( arg0.getRoleId() );
        userRoleDto.setEnable( arg0.getEnable() );

        return userRoleDto;
    }

    @Override
    public UserRoleEntity toEntity(UserRoleDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserRoleEntity userRoleEntity = new UserRoleEntity();

        userRoleEntity.setId( arg0.getId() );
        userRoleEntity.setUserId( arg0.getUserId() );
        userRoleEntity.setRoleId( arg0.getRoleId() );
        userRoleEntity.setEnable( arg0.getEnable() );

        return userRoleEntity;
    }
}
