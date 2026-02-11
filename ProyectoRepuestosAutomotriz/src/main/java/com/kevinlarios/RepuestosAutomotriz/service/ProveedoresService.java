package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.entity.Proveedores;

import java.util.List;

public interface ProveedoresService {
    List<Proveedores> getAllProveedor();
    Proveedores getProveedoresById(Integer id);
    Proveedores saveProvedores(Proveedores proveedores) throws RuntimeException;
    Proveedores updateProveedores(Integer id,Proveedores proveedores);
    void deleteProveedores(Integer id);
}
