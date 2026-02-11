package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.entity.Repuestos;

import java.util.List;

public interface RepuestosService {
    List<Repuestos> getAllRepuestos();
    Repuestos getRepuestosById(Integer id);
    Repuestos saveRepuestos(Repuestos repuestos) throws RuntimeException;
    Repuestos updateRepuestos(Integer id,Repuestos repuestos);
    void deleteRepuestos(Integer id);
}
