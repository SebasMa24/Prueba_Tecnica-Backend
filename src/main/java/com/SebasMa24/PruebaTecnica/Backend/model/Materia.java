package com.SebasMa24.PruebaTecnica.Backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombre;

    @Column(unique = true)
    @NotNull(message = "El código no puede ser nulo")
    @Positive(message = "El código debe ser positivo")
    private Integer codigo;

    @NotNull(message = "Los créditos no pueden ser nulos")
    @Positive(message = "Los creditos deben ser positivos")
    private Integer creditos;

    @OneToMany(mappedBy = "materia")
    private List<Nota> notas;
}
