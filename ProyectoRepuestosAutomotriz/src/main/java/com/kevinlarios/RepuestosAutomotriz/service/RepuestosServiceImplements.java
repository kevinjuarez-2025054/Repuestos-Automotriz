package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.entity.Repuestos;
import com.kevinlarios.RepuestosAutomotriz.repository.RepuestosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestosServiceImplements implements RepuestosService{
    private final RepuestosRepository repuestosRepository;

    public RepuestosServiceImplements(RepuestosRepository repuestosRepository) {
        this.repuestosRepository = repuestosRepository;
    }

    @Override
    public List<Repuestos> getAllRepuestos() {
        return List.of();
    }

    @Override
    public Repuestos getRepuestosById(Integer id) {
        return repuestosRepository.findById(id).orElse(null);
    }

    @Override
    public Repuestos saveRepuestos(Repuestos repuestos) throws RuntimeException {
        try {
            if (repuestos == null ||
                    repuestos.getNombreRepuesto().isBlank() ||repuestos.getNombreRepuesto() == null ||
                    repuestos.getCategoriaRepuesto().isBlank() ||repuestos.getCategoriaRepuesto() == null ||
                    repuestos.getPrecioCompra() == null ||
                    repuestos.getPrecioVenta() == null||
                    repuestos.getProveedores() == null) {
                throw new IllegalArgumentException("Todos los datos del Repuesto son obligatorios");
            }

            if (!(repuestosRepository.exixtsByNombreRepuestoAndCategoriaRepuestoAndPrecioCompraAndPrecioVentaAndProveedores(
                    repuestos.getNombreRepuesto(),
                    repuestos.getCategoriaRepuesto(),
                    repuestos.getPrecioCompra(),
                    repuestos.getPrecioVenta(),
                    repuestos.getProveedores()))){
                throw new RuntimeException("Ya hay un repuesto con esos datos");
            }
            return repuestosRepository.save(repuestos);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Repuestos updateRepuestos(Integer id, Repuestos repuestos) {
        try {
            if (repuestos == null ||
                    repuestos.getIdRepuesto() == null ||
                    repuestos.getNombreRepuesto().isBlank() ||repuestos.getNombreRepuesto() == null ||
                    repuestos.getCategoriaRepuesto().isBlank() ||repuestos.getCategoriaRepuesto() == null ||
                    repuestos.getPrecioCompra() == null ||
                    repuestos.getPrecioVenta() == null||
                    repuestos.getProveedores() == null) {
                throw new IllegalArgumentException("Todos los datos del Repuesto son obligatorios");
            }
            return repuestosRepository.save(repuestos);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteRepuestos(Integer id) {
        try {
            if (id == null || id == 0){
                throw new IllegalArgumentException("El id tiene que ser mayor a 0");
            }

            if (!repuestosRepository.existsById(id)){
                throw new RuntimeException("Id inexistente");
            }

            repuestosRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
