package com.example.demo.service;

import com.example.demo.model.Colaborador;
import com.example.demo.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador saveColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public List<Colaborador> findAllColaboradores() {
        return colaboradorRepository.findAll();
    }

    public Optional<Colaborador> findColaboradorById(Long id) {
        return colaboradorRepository.findById(id);
    }

    public Optional<Colaborador> findColaboradorByEmail(String email) {
        return colaboradorRepository.findColaboradorByEmail(email);
    }

    public List<Colaborador> findColaboradorByNome(String nome) {
        return colaboradorRepository.findColaboradorByNome(nome);
    }

    public void deleteColaboradorById(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
