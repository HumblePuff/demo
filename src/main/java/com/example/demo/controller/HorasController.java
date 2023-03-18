package com.example.demo.controller;

import com.example.demo.model.Horas;
import com.example.demo.service.HorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horas")
public class HorasController {

    @Autowired
    private HorasService horasService;

    @PostMapping
    public Horas createHoras(@RequestBody Horas horas) {
        return horasService.saveHoras(horas);
    }

    @GetMapping
    public List<Horas> findAllHoras() {
        return horasService.findAllHoras();
    }

    @GetMapping("/{id}")
    public Optional<Horas> findHorasById(@PathVariable Long id) {
        return horasService.findHorasById(id);
    }

    @PutMapping("/{id}")
    public Horas updateHoras(@PathVariable Long id, @RequestBody Horas horas) {
        horas.setId(id);
        return horasService.saveHoras(horas);
    }

    @DeleteMapping("/{id}")
    public void deleteHorasById(@PathVariable Long id) {
        horasService.deleteHorasById(id);
    }
}
