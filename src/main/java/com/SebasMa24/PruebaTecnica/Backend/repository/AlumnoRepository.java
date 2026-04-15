package com.SebasMa24.PruebaTecnica.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SebasMa24.PruebaTecnica.Backend.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Boolean existsByEmail(String email);
}
