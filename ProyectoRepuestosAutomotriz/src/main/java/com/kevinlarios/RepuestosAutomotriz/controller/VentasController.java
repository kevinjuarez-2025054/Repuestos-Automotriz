package com.kevinlarios.RepuestosAutomotriz.controller;

import com.kevinlarios.RepuestosAutomotriz.entity.Ventas;
import com.kevinlarios.RepuestosAutomotriz.service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    public final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas(){return ventasService.getAllVenta();}

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Ventas ventas){
        try {
            Ventas createVenta = ventasService.saveVenta(ventas);
            return new ResponseEntity<>(createVenta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateVentas(Integer id,@Valid @RequestBody Ventas ventas){
        try {
            Ventas updateVenta = ventasService.updateVenta(id,ventas);
            return new ResponseEntity<>(updateVenta,HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVentas(@PathVariable Integer id){
        try {
            ventasService.deleteVentas(id);
            return ResponseEntity.ok("Dato eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
