package com.gihanz.services.impl;

import com.gihanz.dtos.UserDto;
import com.gihanz.entities.UserEntity;
import com.gihanz.repositories.UserRepository;
import com.gihanz.services.SuperService;
import com.gihanz.utils.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements SuperService< UserDto> {

    private final UserRepository userRepository;


    @Override
    public UserDto create(UserDto dto) {
        UserEntity entity = UserMapper.INSTANCE.toEntity(dto);
        return UserMapper.INSTANCE.toDto(userRepository.save(entity));
    }

    @Override
    public UserDto update(UserDto dto) {
        return UserMapper.INSTANCE.toDto(userRepository.save(UserMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public UserDto delete(Long id) {
        UserEntity entity = userRepository.findById(id).orElse(null);
        if (entity != null) {
            userRepository.delete(entity);
        }
        return UserMapper.INSTANCE.toDto(entity) ;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserMapper.INSTANCE::toDto).toList();
    }

    @Override
    public UserDto findById(Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        return entity.map(UserMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    public Page<UserDto> search(UserDto dto, Pageable pageable) {
        return null;
    }
}
