package com.krakedev.veterinaria.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Mascota")
    public Long id;

    @Column(name = "nombre_mascota", nullable = false, length = 100)
    public String nombre;

    @Column(name = "especie_mascota", nullable = false, length = 50)
    public String especie;

    @Column(name = "edad_mascota", nullable = false)
    public int edad;

    @Column(name = "nombre_dueno", nullable = false, length = 100)
    public String nombreDueno;

    @Column(name = "fecha_registro")
    public LocalDate fechaRegistro;
}
