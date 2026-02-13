package com.kevinlarios.RepuestosAutomotriz.repository;

import com.kevinlarios.RepuestosAutomotriz.entity.Empleado;
import com.kevinlarios.RepuestosAutomotriz.entity.Repuestos;
import com.kevinlarios.RepuestosAutomotriz.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface VentasRepository extends JpaRepository<Ventas,Integer> {

    boolean existsByFechaVentaAndCantidadAndTotalAndEmpleadoAndRepuestos(
            Date fechaVenta,
            Integer cantidad,
            Double total,
            Empleado empleado,
            Repuestos repuestos
    );
}
