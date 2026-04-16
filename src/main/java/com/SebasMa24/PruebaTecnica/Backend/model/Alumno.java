package com.SebasMa24.PruebaTecnica.Backend.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombre;

    @NotBlank(message = "El apellido no puede ser nulo")
    private String apellido;

    @Column(unique = true)
    @NotBlank(message = "El email no puede ser nulo")
    @Email(message = "El email debe tener el formato correcto")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe estar en el pasado")
    private LocalDate fecha_nacimiento;

    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas;
}
