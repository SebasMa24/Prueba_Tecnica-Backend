package com.SebasMa24.PruebaTecnica.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SebasMa24.PruebaTecnica.Backend.model.Alumno;
import com.SebasMa24.PruebaTecnica.Backend.repository.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    public Alumno getAlumnoById(Long id) {
        Optional<Alumno> Alumno = alumnoRepository.findById(id);
        if(Alumno.isEmpty()) {
            throw new IllegalArgumentException("Alumno no encontrado");
        }
        return Alumno.get();
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
        Optional<Alumno> existingAlumno = alumnoRepository.findById(id);
        if(existingAlumno.isEmpty()) {
            throw new IllegalArgumentException("Alumno no encontrado");
        }
        if(!alumno.getEmail().equals(existingAlumno.get().getEmail())
            && alumnoRepository.existsByEmail(alumno.getEmail())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }
        Alumno AlumnoToUpdate = existingAlumno.get();
        AlumnoToUpdate.setNombre(alumno.getNombre());
        AlumnoToUpdate.setApellido(alumno.getApellido());
        AlumnoToUpdate.setEmail(alumno.getEmail());
        AlumnoToUpdate.setFecha_nacimiento(alumno.getFecha_nacimiento());
        return alumnoRepository.save(AlumnoToUpdate);
    }

    public void deleteAlumno(Long id) {
        Optional<Alumno> existingAlumno = alumnoRepository.findById(id);
        if(existingAlumno.isEmpty()) {
            throw new IllegalArgumentException("Alumno no encontrado");
        }
        alumnoRepository.deleteById(id);
    }
    
}
