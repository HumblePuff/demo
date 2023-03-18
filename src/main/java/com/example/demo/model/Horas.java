package com.example.demo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Horas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NonNull
    private Colaborador colaborador;
    @OneToOne
    @NonNull
    private Iniciativa iniciativa;
    @NonNull
    private LocalDateTime createdAt;
    @NonNull
    private Integer horas;
}
