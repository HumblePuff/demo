package com.example.demo.controller;

import com.example.demo.model.Empresa;
import com.example.demo.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> findAllEmpresas() {
        return empresaService.findAllEmpresas();
    }

    @GetMapping("/{id}")
    public Optional<Empresa> findEmpresaById(@PathVariable Long id) {
        return empresaService.findEmpresaById(id);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        return empresaService.saveEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresaById(@PathVariable Long id) {
        empresaService.deleteEmpresaById(id);
    }
}
