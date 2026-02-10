package com.kevinlarios.RepuestosAutomotriz.controller;

import com.kevinlarios.RepuestosAutomotriz.entity.Empleado;
import com.kevinlarios.RepuestosAutomotriz.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")

public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    @GetMapping
    public List<Empleado> getAllEmpleados(){return  empleadoService.getAllEmpleados();}


    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleado empleado){
        try{
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return  new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateEmpleado(Integer id , @Valid @RequestBody Empleado empleado){
        try {
            Empleado updatedEmpleado = empleadoService.updateEmpleado(id,empleado);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        }catch (RuntimeException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleado(@PathVariable Integer id){
        try {
            empleadoService.deleteEmpleado(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
