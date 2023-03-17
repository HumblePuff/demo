package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EntityScan("com.example.demo")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmpresaRepository EmpresaRepository,
            ColaboradorRepository ColaboradorRepository) {
        return args -> {
            System.out.println("---------------------------------");
            Empresa empresa1 = new Empresa(
                    "nike",
                    "nike@empresa.com",
                    "preco fechado");

            Empresa empresa2 = new Empresa(
                    "puma",
                    "puma@empresa.com",
                    "pool de horas");

            Empresa empresa3 = new Empresa(
                    "razer",
                    "razer@empresa.com",
                    "hora aberta");

            empresa1.addIniciativa(new Iniciativa("projeto 1", empresa1));
            empresa2.addIniciativa(new Iniciativa("projeto 2", empresa2));
            empresa3.addIniciativa(new Iniciativa("projeto 3", empresa3));

            EmpresaRepository.saveAll(List.of(empresa1, empresa2, empresa3));

            EmpresaRepository.getAll().forEach((empresa) -> {
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

            ColaboradorRepository.saveAll(List.of(colaborador1, colaborador2, colaborador3));

            ColaboradorRepository.getAll().forEach((colaborador) -> {
                System.out.println(colaborador);
                colaborador.getHoras().forEach((horas) -> {
                    System.out.println("--" + horas.toString());
                });
            });
            System.out.println("---------------------------------");

        };
    }

}
