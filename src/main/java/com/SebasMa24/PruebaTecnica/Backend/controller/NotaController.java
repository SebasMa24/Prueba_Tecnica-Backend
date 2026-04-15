package com.SebasMa24.PruebaTecnica.Backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SebasMa24.PruebaTecnica.Backend.dto.request.NotaRequest;
import com.SebasMa24.PruebaTecnica.Backend.dto.response.NotaResponse;
import com.SebasMa24.PruebaTecnica.Backend.model.Nota;
import com.SebasMa24.PruebaTecnica.Backend.service.NotaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/notas")
public class NotaController {
    @Autowired
    NotaService notaService;

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String,List<NotaResponse>>> getMethodName(@Valid @PathVariable Long userId) {
        return ResponseEntity.ok(notaService.getNotasByAlumno(userId));
    }
    
    @PostMapping
    public ResponseEntity<Nota> postMethodName(@Valid @RequestBody NotaRequest notaRequest) {
        return ResponseEntity.ok(notaService.createNota(notaRequest));
    }
    

}
