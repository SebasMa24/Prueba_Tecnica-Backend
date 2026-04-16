package com.SebasMa24.PruebaTecnica.Backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SebasMa24.PruebaTecnica.Backend.dto.request.NotaRequest;
import com.SebasMa24.PruebaTecnica.Backend.dto.response.NotaResponse;
import com.SebasMa24.PruebaTecnica.Backend.model.Alumno;
import com.SebasMa24.PruebaTecnica.Backend.model.Materia;
import com.SebasMa24.PruebaTecnica.Backend.model.Nota;
import com.SebasMa24.PruebaTecnica.Backend.repository.AlumnoRepository;
import com.SebasMa24.PruebaTecnica.Backend.repository.MateriaRepository;
import com.SebasMa24.PruebaTecnica.Backend.repository.NotaRepository;

@Service
public class NotaService {
    @Autowired
    NotaRepository notaRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    MateriaRepository materiaRepository;

    public Nota createNota(NotaRequest notaRequest) {
        Alumno alumno = alumnoRepository.findById(notaRequest.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        Materia materia = materiaRepository.findById(notaRequest.getMateriaId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Nota nota = new Nota();
        nota.setValor(notaRequest.getValor());
        nota.setFecha_registro(LocalDate.now());
        nota.setAlumno(alumno);
        nota.setMateria(materia);
        return notaRepository.save(nota);
    }

    public Map<String, List<NotaResponse>> getNotasByAlumno(Long alumnoId) {
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        List<Nota> notas = notaRepository.findByAlumnoId(alumno.getId());
        return notas.stream()
                .collect(Collectors.groupingBy(
                        n -> n.getMateria().getNombre(),
                        Collectors.mapping(n -> {
                            NotaResponse notaResponse = new NotaResponse();
                            notaResponse.setValor(n.getValor());
                            notaResponse.setFecha_registro(n.getFecha_registro());
                            return notaResponse;
                        }, Collectors.toList())));
    }
}
