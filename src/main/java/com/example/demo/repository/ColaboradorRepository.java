package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Colaborador;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

        Optional<Colaborador> findColaboradorByEmail(String email);
        List<Colaborador> findColaboradorByNome(String nome);

        @Transactional
        @Modifying
        @Query("DELETE FROM Colaborador u WHERE u.id = ?1")
        int deleteColaboradorById(Long id);
}
