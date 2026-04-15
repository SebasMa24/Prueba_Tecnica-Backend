package com.SebasMa24.PruebaTecnica.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SebasMa24.PruebaTecnica.Backend.model.Materia;
import com.SebasMa24.PruebaTecnica.Backend.repository.MateriaRepository;

@Service
public class MateriaService {
    @Autowired
    MateriaRepository materiaRepository;

    public Materia getMateriaById(Long id){
        return materiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));
    }

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Materia createMateria(Materia materia) {
        if (materiaRepository.existsByCodigo(materia.getCodigo())) {
            throw new IllegalArgumentException("Ya existe una materia con ese código");
        }
        return materiaRepository.save(materia);
    }

    public Materia updateMateria(Long id, Materia materia) {
        Materia existingMateria = materiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));
        if (!(materia.getCodigo().equals(existingMateria.getCodigo())) && materiaRepository.existsByCodigo(materia.getCodigo())) {
            throw new IllegalArgumentException("Ya existe una materia con ese código");
        }
        existingMateria.setNombre(materia.getNombre());
        existingMateria.setCodigo(materia.getCodigo());
        existingMateria.setCreditos(materia.getCreditos());
        return materiaRepository.save(existingMateria);
    }
    

    public void deleteMateria(Long id) {
        Materia existingMateria = materiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));
        materiaRepository.delete(existingMateria);
    }
}
