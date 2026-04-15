package com.SebasMa24.PruebaTecnica.Backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    private double valor;

    @Column(nullable = false)
    private LocalDate fecha_registro;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private Materia materia;
}
