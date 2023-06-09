package com.example.demo;

import com.example.demo.model.Colaborador;
import com.example.demo.model.Empresa;
import com.example.demo.model.Horas;
import com.example.demo.model.Iniciativa;
import com.example.demo.repository.ColaboradorRepository;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner commandLineRunner(EmpresaRepository empresaRepository,
                                        ColaboradorRepository colaboradorRepository) {
        return args -> {
            System.out.println("---------------------------------");
            Empresa empresa1 = new Empresa(
                    "nike",
                    "nike@empresa.com",
                    "FECHADO");

            Empresa empresa2 = new Empresa(
                    "puma",
                    "puma@empresa.com",
                    "ABERTO");

            Empresa empresa3 = new Empresa(
                    "razer",
                    "razer@empresa.com",
                    "POOL");

            empresa1.addIniciativa(new Iniciativa("projeto 1", empresa1));
            empresa2.addIniciativa(new Iniciativa("projeto 2", empresa2));
            empresa3.addIniciativa(new Iniciativa("projeto 3", empresa3));

            empresaRepository.saveAll(List.of(empresa1, empresa2, empresa3));

            empresaRepository.findAll().forEach((empresa) -> {
                System.out.println(empresa);
                empresa.getIniciativas().forEach((iniciativa) -> {
                    System.out.println("--" + iniciativa.toString());
                });
            });

            Colaborador colaborador1 = new Colaborador(
                    "joao",
                    "joao@gmail.com");
            Colaborador colaborador2 = new Colaborador(
                    "maria",
                    "maria@gmail.com");
            Colaborador colaborador3 = new Colaborador(
                    "pedro",
                    "pedro@gmail.com");

            colaborador1.addHoras(new Horas(colaborador1, empresa1.getIniciativas().get(0), LocalDateTime.now(), 5));
            colaborador2.addHoras(new Horas(colaborador2, empresa1.getIniciativas().get(0), LocalDateTime.now(), 5));
            colaborador3.addHoras(new Horas(colaborador3, empresa1.getIniciativas().get(0), LocalDateTime.now(), 5));

            colaboradorRepository.saveAll(List.of(colaborador1, colaborador2, colaborador3));

            colaboradorRepository.findAll().forEach((colaborador) -> {
                System.out.println(colaborador);
                colaborador.getHoras().forEach((horas) -> {
                    System.out.println("--" + horas.toString());
                });
            });
            System.out.println("---------------------------------");
        };
    }
}
