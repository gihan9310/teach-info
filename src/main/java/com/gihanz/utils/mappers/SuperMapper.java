package com.gihanz.utils.mappers;

public interface SuperMapper <D,E>{

    D toDto(E e);
    E toEntity(D dto);
}
