package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.model.Empleado;

import java.util.List;

public interface EmpleadoService {
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(Integer id);
    Empleado saveEmpleado(Empleado empleado) throws RuntimeException;
    Empleado updateEmpleado(Integer id,Empleado empleado);
    void deleteEmpleado(Integer id);
}
