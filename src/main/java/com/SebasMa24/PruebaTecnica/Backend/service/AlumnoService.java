package com.SebasMa24.PruebaTecnica.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SebasMa24.PruebaTecnica.Backend.model.Alumno;
import com.SebasMa24.PruebaTecnica.Backend.repository.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno createAlumno(Alumno alumno) {
        if(alumnoRepository.existsByEmail(alumno.getEmail())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(Long id, Alumno alumno) {
        Alumno existingAlumno = alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
        if(!alumno.getEmail().equals(existingAlumno.getEmail())
            && alumnoRepository.existsByEmail(alumno.getEmail())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }
        existingAlumno.setNombre(alumno.getNombre());
        existingAlumno.setApellido(alumno.getApellido());
        existingAlumno.setEmail(alumno.getEmail());
        existingAlumno.setFecha_nacimiento(alumno.getFecha_nacimiento());
        return alumnoRepository.save(existingAlumno);
    }

    public void deleteAlumno(Long id) {
        Alumno existingAlumno = alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
        alumnoRepository.delete(existingAlumno);
    }
    
}
