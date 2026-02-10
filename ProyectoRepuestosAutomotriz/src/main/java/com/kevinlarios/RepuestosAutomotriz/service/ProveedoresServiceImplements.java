package com.kevinlarios.RepuestosAutomotriz.service;

import com.kevinlarios.RepuestosAutomotriz.entity.Proveedores;
import com.kevinlarios.RepuestosAutomotriz.repository.ProveedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImplements implements ProveedoresService{

    private final ProveedoresRepository proveedoresRepository;

    public ProveedoresServiceImplements(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<Proveedores> getAllProveedor() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Proveedores getProveedoresById(Integer id) {
        return proveedoresRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedores saveProvedores(Proveedores proveedores) {
        try {
            if(proveedores == null ||
            proveedores.getNombreProveedor().isBlank()||
            proveedores.getTelefonoProveedor() == null ||
            proveedores.getDireccionProveedor().isBlank() ||
            proveedores.getEmailProveedor().isBlank()){
                throw new IllegalArgumentException("Todos lo datos del proveedor son obligatorios");
            }

            if (!proveedores.getEmailProveedor().contains("@gmail.com") ||
                    proveedores.getEmailProveedor().contains("@yahoo.com") ||
                    proveedores.getEmailProveedor().contains("outlook.com") ||
                    proveedores.getEmailProveedor().contains("@icloud.com") ||
                    proveedores.getEmailProveedor().contains("@hotmail.com")
                ){
                throw new IllegalArgumentException("El email solo puede tener los dominios @gmail.com," +
                        "@yahoo.com,@outlook.com,@hotmail.com,@icloud.com");
            }

            if (proveedoresRepository.existByNombreProveedorAndTelefonoProveedorAndDireccionProveedorAndEmailProveedor(
                    proveedores.getNombreProveedor(),
                    proveedores.getTelefonoProveedor(),
                    proveedores.getDireccionProveedor(),
                    proveedores.getEmailProveedor()
                )){
                throw new RuntimeException("Ya existe un proveedor con esos datos");
            }
            return proveedoresRepository.save(proveedores);
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Proveedores updateProveedores(Integer id, Proveedores proveedores) {
        try {
            if (!proveedores.getEmailProveedor().contains("@gmail.com") ||
                    proveedores.getEmailProveedor().contains("@yahoo.com") ||
                    proveedores.getEmailProveedor().contains("outlook.com") ||
                    proveedores.getEmailProveedor().contains("@icloud.com") ||
                    proveedores.getEmailProveedor().contains("@hotmail.com")
            ){
                throw new IllegalArgumentException("El email solo puede tener los dominios @gmail.com," +
                        "@yahoo.com,@outlook.com,@hotmail.com,@icloud.com");
            }
            return  proveedoresRepository.save(proveedores);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteProveedores(Integer id) {
        try {
            if (id == null || id == 0){
                throw new IllegalArgumentException("El id tiene que ser mayor a 0");
            }

            if (!proveedoresRepository.existsById(id)){
                throw new RuntimeException("Id innexistente");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
