package com.kevinlarios.RepuestosAutomotriz.service;


import com.kevinlarios.RepuestosAutomotriz.entity.Empleado;
import com.kevinlarios.RepuestosAutomotriz.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplements implements EmpleadoService{
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplements(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {

        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {

        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws RuntimeException {
        try {
            if (empleado == null ||
            empleado.getNombreEmpleado() == null || empleado.getNombreEmpleado().isBlank() ||
            empleado.getApellidoEmpleado() == null || empleado.getApellidoEmpleado().isBlank()||
            empleado.getPuestoEmpleado() == null  || empleado.getPuestoEmpleado().isBlank()||
            empleado.getEmailEmpleado() == null || empleado.getEmailEmpleado().isBlank()) {
                throw new IllegalArgumentException("Los datos del empleado son obligatorios");
            }

            if (!(empleado.getEmailEmpleado().contains("@gmail.com")
            || empleado.getEmailEmpleado().contains("@yahoo.com")
            || empleado.getEmailEmpleado().contains("@outlook.com")
            || empleado.getEmailEmpleado().contains("@hotmail.com"))){
                throw new IllegalArgumentException("El email solo puede tener los dominios @gmail.com," +
                        "@yahoo.com,@outlook.com,@hotmail.com");
            }

            if (empleadoRepository.existsByNombreEmpleadoAndApellidoEmpleadoAndPuestoEmpleadoAndEmailEmpleado(
                    empleado.getNombreEmpleado(),
                    empleado.getApellidoEmpleado(),
                    empleado.getPuestoEmpleado(),
                    empleado.getEmailEmpleado()
            )) {
                throw new RuntimeException("Ya existe un empleado con datos similares");
            }
            return empleadoRepository.save(empleado);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        try {
            if (!(empleado.getEmailEmpleado().contains("@gmail.com")
                    || empleado.getEmailEmpleado().contains("@yahoo.com")
                    || empleado.getEmailEmpleado().contains("@outlook.com")
                    || empleado.getEmailEmpleado().contains("@hotmail.com"))){
                throw new IllegalArgumentException("El email solo puede tener los dominios @gmail.com," +
                        "@yahoo.com,@outlook.com,@hotmail.com");
            }
            return empleadoRepository.save(empleado);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteEmpleado(Integer id) {
        try {
            if (id == null || id <=0){
                throw new IllegalArgumentException("El id tiene que ser mallor a 0");
            }
            if (!empleadoRepository.existsById(id)) {
                throw new RuntimeException("id No encontrado");
            }
            empleadoRepository.deleteById(id);
        }catch (Exception e){
           throw  new RuntimeException(e.getMessage());
        }
    }
}
