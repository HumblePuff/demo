package com.example.demo.service;

import com.example.demo.model.Iniciativa;
import com.example.demo.repository.IniciativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IniciativaService {

    @Autowired
    private IniciativaRepository iniciativaRepository;

    public Iniciativa saveIniciativa(Iniciativa iniciativa) {
        return iniciativaRepository.save(iniciativa);
    }

    public List<Iniciativa> findAllIniciativas() {
        return iniciativaRepository.findAll();
    }

    public Optional<Iniciativa> findIniciativaById(Long id) {
        return iniciativaRepository.findById(id);
    }

    public void deleteIniciativaById(Long id) {
        iniciativaRepository.deleteById(id);
    }
}
