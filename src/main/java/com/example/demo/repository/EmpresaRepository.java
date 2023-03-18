package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

        Optional<Empresa> findEmpresaByEmail(String email);
        List<Empresa> findEmpresaByNome(String nome);

    @Transactional
    @Modifying
    @Query("DELETE FROM Empresa u WHERE u.id = ?1")
    int deleteEmpresaById(Long id);
}
