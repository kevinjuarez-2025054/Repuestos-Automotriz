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

    @Column(name = "categoria_repuesto")
    private String categoriaRepuesto;

    @Column(name = "precio_compra")
    private boolean precioCompra;

    @Column(name = "precio_venta")
    private boolean precioVenta;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedores;


    // Getters and Setters //


    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getCategoriaRepuesto() {
        return categoriaRepuesto;
    }

    public void setCategoriaRepuesto(String categoriaRepuesto) {
        this.categoriaRepuesto = categoriaRepuesto;
    }

    public boolean isPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(boolean precioCompra) {
        this.precioCompra = precioCompra;
    }

    public boolean isPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(boolean precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }
}
