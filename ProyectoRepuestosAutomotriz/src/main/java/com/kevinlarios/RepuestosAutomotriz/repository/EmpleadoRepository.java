package com.kevinlarios.RepuestosAutomotriz.repository;

import com.kevinlarios.RepuestosAutomotriz.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    boolean existsByNombreEmpleadoAndApellidoEmpleadoAndPuestoEmpleadoAndEmailEmpleado(
            String nombreEmpleado,
            String apellidoEmpleado,
            String puestoEmpleado,
            String emailEmpleado
    );

}
