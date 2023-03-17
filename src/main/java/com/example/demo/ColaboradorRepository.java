package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

        @Query("SELECT u FROM Colaborador u WHERE u.email = ?1")
        Optional<Colaborador> findColaboradorByEmail(String email);

        @Query("SELECT u FROM Colaborador u WHERE u.nome = ?1")
        List<Colaborador> findColaboradorByNome(String nome);

        @Query("SELECT u FROM Colaborador u")
        List<Colaborador> getAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Colaborador u WHERE u.id = ?1")
    int deleteColaboradorById(Long id);
}
