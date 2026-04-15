package com.SebasMa24.PruebaTecnica.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SebasMa24.PruebaTecnica.Backend.model.Materia;
import com.SebasMa24.PruebaTecnica.Backend.service.MateriaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/materias")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        return ResponseEntity.ok(materiaService.getAllMaterias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(materiaService.getMateriaById(id));
    }
    
    @PostMapping
    public ResponseEntity<Materia> createMateria(@Valid @RequestBody Materia materia) {
        return ResponseEntity.ok(materiaService.createMateria(materia));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Materia> editMateria(@Valid @RequestBody Materia materia,@Valid @PathVariable Long id) {       
        return ResponseEntity.ok(materiaService.updateMateria(id, materia));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@Valid @PathVariable Long id) {
        materiaService.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }
    
}
