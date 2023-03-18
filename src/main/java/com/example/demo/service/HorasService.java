package com.example.demo.service;

import com.example.demo.model.Horas;
import com.example.demo.repository.HorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorasService {

    @Autowired
    private HorasRepository horasRepository;

    public Horas saveHoras(Horas horas) {
        return horasRepository.save(horas);
    }

    public List<Horas> findAllHoras() {
        return horasRepository.findAll();
    }

    public Optional<Horas> findHorasById(Long id) {
        return horasRepository.findById(id);
    }

    public void deleteHorasById(Long id) {
        horasRepository.deleteById(id);
    }
}
