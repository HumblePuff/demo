package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Colaborador")
public class Colaborador {

    @Id
    @SequenceGenerator(name = "colaborador_sequence", sequenceName = "colaborador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "colaborador_sequence")
    @Column(name = "colaborador_id", updatable = false)
    private Long id;

    @Column(name = "colaborador_nome", nullable = false, columnDefinition = "TEXT")
    private String nome;

    @Column(name = "colaborador_email", nullable = false, columnDefinition = "TEXT")
    private String email;

    public Colaborador(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

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
