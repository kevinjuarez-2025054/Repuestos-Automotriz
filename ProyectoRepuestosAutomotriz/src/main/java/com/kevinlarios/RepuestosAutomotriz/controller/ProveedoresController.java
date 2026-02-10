package com.kevinlarios.RepuestosAutomotriz.controller;

import com.kevinlarios.RepuestosAutomotriz.entity.Proveedores;
import com.kevinlarios.RepuestosAutomotriz.service.ProveedoresService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
    public final ProveedoresService proveedoresService;

    public ProveedoresController(ProveedoresService proveedoresService) {this.proveedoresService = proveedoresService;}
    @GetMapping
    public List<Proveedores> getAllProveedor(){return proveedoresService.getAllProveedor();}

    @PostMapping
    public ResponseEntity<Object> createProveedores(@Valid @RequestBody Proveedores proveedores){
        try {
            Proveedores createProveedor = proveedoresService.saveProvedores(proveedores);
            return new ResponseEntity<>(createProveedor, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public  ResponseEntity<Object> updateProveedores(Integer id, @Valid @RequestBody Proveedores proveedores){
        try {
            Proveedores updateProveedor = proveedoresService.updateProveedores(id, proveedores);
            return new ResponseEntity<>(updateProveedor,HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProveedores(@PathVariable Integer id){
        try {
            proveedoresService.deleteProveedores(id);
            return ResponseEntity.ok("Proveedor eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

