package com.kevinlarios.RepuestosAutomotriz.controller;

import com.kevinlarios.RepuestosAutomotriz.entity.Repuestos;
import com.kevinlarios.RepuestosAutomotriz.service.RepuestosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestosController {
    public final RepuestosService repuestosService;

    public RepuestosController(RepuestosService repuestosService) {
        this.repuestosService = repuestosService;
    }
    @GetMapping
    public List<Repuestos> getAllRepuestos(){return repuestosService.getAllRepuestos();}

    @PostMapping
    public ResponseEntity<Object> createRepuestos(@Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos createRepuesto = repuestosService.saveRepuestos(repuestos);
            return new ResponseEntity<>(createRepuesto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public  ResponseEntity<Object> updateRepuestos(Integer id,@Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos updateRepuesto = repuestosService.updateRepuestos(id,repuestos);
            return new ResponseEntity<>(updateRepuesto,HttpStatus.OK);
        }catch (RuntimeException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuestos(@PathVariable Integer id){
        try {
            repuestosService.deleteRepuestos(id);
            return ResponseEntity.ok("Repuesto eliminado correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
