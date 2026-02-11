package com.kevinlarios.RepuestosAutomotriz.repository;

import com.kevinlarios.RepuestosAutomotriz.entity.Proveedores;
import com.kevinlarios.RepuestosAutomotriz.entity.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestosRepository extends JpaRepository<Repuestos,Integer> {

    boolean exixtsByNombreRepuestoAndCategoriaRepuestoAndPrecioCompraAndPrecioVentaAndProveedores(
            String nombreRepuesto,
            String categoriaRepuesto,
            Double precioCompra,
            Double precioVenta,
            Proveedores proveedores
    );
}
