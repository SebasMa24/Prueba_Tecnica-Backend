package com.SebasMa24.PruebaTecnica.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SebasMa24.PruebaTecnica.Backend.model.Alumno;
import com.SebasMa24.PruebaTecnica.Backend.service.AlumnoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/alumnos")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.getAlumnoById(id));
    }
    
    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@Valid @RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.createAlumno(alumno));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> editAlumno(@Valid @RequestBody Alumno alumno,@Valid @PathVariable Long id) {       
        return ResponseEntity.ok(alumnoService.updateAlumno(id, alumno));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@Valid @PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return ResponseEntity.noContent().build();
    }
}
