package com.SebasMa24.PruebaTecnica.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SebasMa24.PruebaTecnica.Backend.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlumnoId(Long alumnoId);
}
