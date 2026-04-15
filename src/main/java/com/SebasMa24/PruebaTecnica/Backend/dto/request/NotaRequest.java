package com.SebasMa24.PruebaTecnica.Backend.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaRequest {
    private Double valor;
    private LocalDate fecha_registro;
    private Long alumnoId;
    private Long materiaId;
}
