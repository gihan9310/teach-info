package com.gihanz.services;

import com.gihanz.dtos.SuperDto;
import com.gihanz.entities.SuperEntity;

import java.util.List;

public interface SuperService <E extends SuperEntity,D extends SuperDto>{

    D create(D dto);
    D update(D dto);
    D delete(Long id);
    List<D> findAll();
    D findById(Long id);


}
