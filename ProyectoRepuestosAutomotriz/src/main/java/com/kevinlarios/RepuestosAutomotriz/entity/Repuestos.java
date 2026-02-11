package com.kevinlarios.RepuestosAutomotriz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Repuestos")
public class Repuestos {
    @Id
    @GeneratedValue
    @Column(name = "id_repuesto")
    private Integer idRepuesto;

    @Column(name = "nombre_repuesto")
    private String nombreRepuesto;
}
