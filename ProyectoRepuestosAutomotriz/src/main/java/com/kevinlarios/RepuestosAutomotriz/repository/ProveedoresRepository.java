package com.kevinlarios.RepuestosAutomotriz.repository;

import com.kevinlarios.RepuestosAutomotriz.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores,Integer> {

    boolean existByNombreProveedorAndTelefonoProveedorAndDireccionProveedorAndEmailProveedor(
            String nombreProveedor,
            Integer telefonoProveedor,
            String direccionProveedor,
            String emailProveedor
    );
}
