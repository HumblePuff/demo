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
@Entity(name = "Empresa")
public class Empresa {

    @Id
    @SequenceGenerator(name = "empresa_sequence", sequenceName = "empresa_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "empresa_sequence")
    @Column(name = "empresa_id", updatable = false)
    private Long id;

    @Column(name = "empresa_nome", nullable = false, columnDefinition = "TEXT")
    private String nome;

    @Column(name = "empresa_email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "empresa_modelo_contrato", nullable = false, columnDefinition = "TEXT")
    private String modeloContrato;

    public Empresa(String nome, String email, String modeloContrato) {
        this.nome = nome;
        this.email = email;
        this.modeloContrato = modeloContrato;
    }

    @OneToMany(
            mappedBy = "empresa",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )

    private List<Iniciativa> iniciativas = new ArrayList<>();

    public List<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public void addIniciativa(Iniciativa iniciativa) {
        if (!iniciativas.contains(iniciativa)) {
            iniciativas.add(iniciativa);
        }
    }

    public void removeIniciativa(Iniciativa iniciativa) {
        iniciativas.remove(iniciativa);
    }

    @Override
    public String toString() {
        return "Empresa: " + nome;
    }
}
