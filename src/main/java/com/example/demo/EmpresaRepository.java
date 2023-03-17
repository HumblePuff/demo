package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

        @Query("SELECT u FROM Empresa u WHERE u.email = ?1")
        Optional<Empresa> findEmpresaByEmail(String email);

        @Query("SELECT u FROM Empresa u WHERE u.nome = ?1")
        List<Empresa> findEmpresaByNome(String nome);

        @Query("SELECT u FROM Empresa u")
        List<Empresa> getAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Empresa u WHERE u.id = ?1")
    int deleteEmpresaById(Long id);
}
