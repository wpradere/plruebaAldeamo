package com.aldeamo.prueba.repository;

import com.aldeamo.prueba.model.BarTentity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BartRepository  extends CrudRepository<BarTentity,Long> {

    public BarTentity findAllById(Long id);
}
