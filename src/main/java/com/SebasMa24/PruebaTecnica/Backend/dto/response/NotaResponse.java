package com.SebasMa24.PruebaTecnica.Backend.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaResponse {
    private double valor;
    private LocalDate fecha_registro;
}
