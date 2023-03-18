package com.example.demo.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String modeloContrato;

    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Iniciativa> iniciativas = new ArrayList<>();

    public void addIniciativa(Iniciativa iniciativa) {
        iniciativas.add(iniciativa);
        iniciativa.setEmpresa(this);
    }

    public void removeIniciativa(Iniciativa iniciativa) {
        iniciativas.remove(iniciativa);
        iniciativa.setEmpresa(null);
    }
}
