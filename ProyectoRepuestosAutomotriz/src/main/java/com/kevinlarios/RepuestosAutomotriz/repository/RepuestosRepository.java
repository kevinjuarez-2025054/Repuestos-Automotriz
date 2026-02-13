package com.kevinlarios.RepuestosAutomotriz.repository;

import com.kevinlarios.RepuestosAutomotriz.entity.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosRepository extends JpaRepository<Repuestos,Integer> {

    boolean existsByNombreRepuestoAndCategoriaRepuestoAndPrecioCompraAndPrecioVentaAndIdProveedor(
            String nombreRepuesto,
            String categoriaRepuesto,
            Double precioCompra,
            Double precioVenta,
            Integer idProveedor
    );
}
