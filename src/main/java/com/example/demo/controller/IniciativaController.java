package com.example.demo.controller;

import com.example.demo.model.Iniciativa;
import com.example.demo.service.IniciativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/iniciativas")
public class IniciativaController {

    @Autowired
    private IniciativaService iniciativaService;

    @PostMapping
    public Iniciativa createIniciativa(@RequestBody Iniciativa iniciativa) {
        return iniciativaService.saveIniciativa(iniciativa);
    }

    @GetMapping
    public List<Iniciativa> findAllIniciativas() {
        return iniciativaService.findAllIniciativas();
    }

    @GetMapping("/{id}")
    public Optional<Iniciativa> findIniciativaById(@PathVariable Long id) {
        return iniciativaService.findIniciativaById(id);
    }

    @PutMapping("/{id}")
    public Iniciativa updateIniciativa(@PathVariable Long id, @RequestBody Iniciativa iniciativa) {
        iniciativa.setId(id);
        return iniciativaService.saveIniciativa(iniciativa);
    }

    @DeleteMapping("/{id}")
    public void deleteIniciativaById(@PathVariable Long id) {
        iniciativaService.deleteIniciativaById(id);
    }
}
