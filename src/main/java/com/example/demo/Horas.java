package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Horas")
public class Horas {

    @Id
    @SequenceGenerator(name = "horas_sequence", sequenceName = "horas_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "horas_sequence")
    @Column(name = "horas_id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", nullable = false)
    private Colaborador colaborador;

    @OneToOne
    @JoinColumn(name = "iniciativa_id", nullable = false)
    private Iniciativa iniciativa;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @Column(name = "colaborador_nome", nullable = false, columnDefinition = "TEXT")
    private String colaborador_nome;;

    @Column(name = "iniciativa_nome", nullable = false, columnDefinition = "TEXT")
    private String iniciativa_nome;;

    @Column(name = "empresa_nome", nullable = false, columnDefinition = "TEXT")
    private String empresa_nome;

    @Column(name = "horas", nullable = false, columnDefinition = "INTEGER")
    private Integer horas;

    public Horas(Colaborador colaborador, Iniciativa iniciativa, LocalDateTime createdAt, Integer horas) {
        this.colaborador = colaborador;
        this.iniciativa = iniciativa;
        this.createdAt = createdAt;
        this.colaborador_nome = colaborador.getNome();
        this.iniciativa_nome = iniciativa.getNome();
        this.empresa_nome = iniciativa.getEmpresa().getNome();
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "horas: " + colaborador_nome + " -> " + empresa_nome + "[" + iniciativa_nome + "]" +" -> +" + horas + "h";
    }
}
