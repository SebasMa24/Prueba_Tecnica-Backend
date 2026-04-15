package com.SebasMa24.PruebaTecnica.Backend.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nota {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Max(value = 5, message = "La nota no puede ser mayor a 5")
    @Min(value = 0, message = "La nota no puede ser menor a 0")
    private double valor;

    @Column(nullable = false)
    private LocalDate fecha_registro;

    @ManyToOne
    @JsonIgnore
    private Alumno alumno;

    @ManyToOne
    @JsonIgnore
    private Materia materia;
}
