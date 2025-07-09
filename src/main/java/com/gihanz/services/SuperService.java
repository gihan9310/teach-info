package com.gihanz.services;

import com.gihanz.dtos.SuperDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SuperService<D extends SuperDto> {

    D create(D dto);

    D update(D dto);

    D delete(Long id);

    List<D> findAll();

    D findById(Long id);

    Page<D> search(D dto , Pageable pageable);

    /*
     it will Used
     */
    default List<D> saveAsList(List<D> dtos) {
        return dtos;
    }


}
