package com.example.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "Colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nome;
    @NonNull
    private String email;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    public List<Horas> horas = new ArrayList<>();

    public List<Horas> getHoras() {
        return horas;
    }

    public void addHoras(Horas horas) {
        this.horas.add(horas);
    }

    @Override
    public String toString() {
        return "colaborador: " + nome;
    }
}
