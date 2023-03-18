package com.example.demo.repository;

import com.example.demo.model.Horas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorasRepository extends JpaRepository<Horas, Long> {
}
