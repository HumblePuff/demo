package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Iniciativa")
public class Iniciativa {

    @Id
    @SequenceGenerator(name = "iniciativa_sequence", sequenceName = "iniciativa_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "iniciativa_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nome", nullable = false, columnDefinition = "TEXT")
    private String nome;

    @Column(name = "nomeEmpresa", nullable = false, columnDefinition = "TEXT")
    private String nomeEmpresa;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public Iniciativa(String nome, Empresa empresa) {
        this.nome = nome;
        this.nomeEmpresa = empresa.getNome();
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Iniciativa: " + nome;
    }
}
