package com.krakedev.inventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idP;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreP;

    @Column(name = "descripcion_producto")
    private String descripcionP;

    @Column(name = "precio_producto", nullable = false)
    private Double precioP;

    @Column(name = "cantidad_producto", nullable = false)
    private int cantidadP;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoProducto estadoP;

   
}
