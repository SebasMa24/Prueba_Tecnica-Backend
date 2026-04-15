package com.SebasMa24.PruebaTecnica.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SebasMa24.PruebaTecnica.Backend.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    public boolean existsByCodigo(Integer codigo);
}
