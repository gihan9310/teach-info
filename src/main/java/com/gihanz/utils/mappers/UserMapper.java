package com.gihanz.utils.mappers;

import com.gihanz.dtos.UserDto;
import com.gihanz.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper  extends SuperMapper<UserDto , UserEntity> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
