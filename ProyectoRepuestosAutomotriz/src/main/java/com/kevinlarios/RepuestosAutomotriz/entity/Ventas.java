package com.kevinlarios.RepuestosAutomotriz.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private  Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_repuesto")
    private Repuestos repuestos;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Repuestos getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(Repuestos repuestos) {
        this.repuestos = repuestos;
    }
}
