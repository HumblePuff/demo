package com.example.demo.controller;

import com.example.demo.model.Colaborador;
import com.example.demo.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.saveColaborador(colaborador);
    }

    @GetMapping
    public List<Colaborador> findAllColaboradores() {
        return colaboradorService.findAllColaboradores();
    }

    @GetMapping("/{id}")
    public Optional<Colaborador> findColaboradorById(@PathVariable Long id) {
        return colaboradorService.findColaboradorById(id);
    }

    @PutMapping("/{id}")
    public Colaborador updateColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        colaborador.setId(id);
        return colaboradorService.saveColaborador(colaborador);
    }

    @DeleteMapping("/{id}")
    public void deleteColaboradorById(@PathVariable Long id) {
        colaboradorService.deleteColaboradorById(id);
    }
}
