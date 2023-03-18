package com.example.demo.service;

import com.example.demo.model.Empresa;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> findEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }

    public Optional<Empresa> findEmpresaByEmail(String email) {
        return empresaRepository.findEmpresaByEmail(email);
    }

    public List<Empresa> findEmpresaByNome(String nome) {
        return empresaRepository.findEmpresaByNome(nome);
    }

    public void deleteEmpresaById(Long id) {
        empresaRepository.deleteById(id);
    }
}
