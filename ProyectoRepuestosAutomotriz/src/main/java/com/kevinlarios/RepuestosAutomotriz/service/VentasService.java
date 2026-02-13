package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.entity.Ventas;

import java.util.List;

public interface VentasService {
    List<Ventas> getAllVenta();
    Ventas getVentaById(Integer id);
    Ventas saveVenta(Ventas ventas)throws RuntimeException;
    Ventas updateVenta(Integer id,Ventas ventas);
    void deleteVentas(Integer id);
}
