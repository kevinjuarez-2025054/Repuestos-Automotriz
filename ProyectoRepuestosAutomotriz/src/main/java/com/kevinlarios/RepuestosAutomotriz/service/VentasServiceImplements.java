package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.entity.Ventas;
import com.kevinlarios.RepuestosAutomotriz.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    public final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVenta() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentaById(Integer id) {
        return null;
    }

    @Override
    public Ventas saveVenta(Ventas ventas) throws RuntimeException {
        try {
            if(ventas == null ||
            ventas.getFechaVenta() == null ||
            ventas.getCantidad() == null ||
            ventas.getTotal() == null ||
            ventas.getEmpleado() == null ||
            ventas.getRepuestos() == null){
                throw  new IllegalArgumentException("Todos los campos son obligatorios");
            }

            if (ventasRepository.existsByFechaVentaAndCantidadAndTotalAndEmpleadoAndRepuestos(
                    ventas.getFechaVenta(),
                    ventas.getCantidad(),
                    ventas.getTotal(),
                    ventas.getEmpleado(),
                    ventas.getRepuestos()
            )){
                throw new RuntimeException("Estos datos ya fueron registrdos anteriormente");
            }
            return ventasRepository.save(ventas);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ventas updateVenta(Integer id, Ventas ventas) {
        try {
            if(ventas == null ||
                    ventas.getFechaVenta() == null ||
                    ventas.getCantidad() == null ||
                    ventas.getTotal() == null ||
                    ventas.getEmpleado() == null ||
                    ventas.getRepuestos() == null){
                throw  new IllegalArgumentException("Todos los campos son obligatorios");
            }
            return ventasRepository.save(ventas);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteVentas(Integer id) {
        try {
            if (id == null || id == 0){
                throw new IllegalArgumentException("El id tiene que ser mayor a 0");
            }

            if (!ventasRepository.existsById(id)){
                throw new RuntimeException("id Inexistente");
            }
            ventasRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
