package com.aldeamo.prueba.service.impl;

import com.aldeamo.prueba.model.BarTentity;
import com.aldeamo.prueba.repository.BartRepository;
import com.aldeamo.prueba.service.BartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Service
public class BartServiceimpl implements BartService {

    @Autowired
    private BartRepository bartRepository;

    @Override
    public BarTentity findOne(Long id) {
        return bartRepository.findAllById(id);
    }
}
