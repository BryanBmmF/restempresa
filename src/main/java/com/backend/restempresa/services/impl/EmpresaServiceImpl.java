package com.backend.restempresa.services.impl;

import com.backend.restempresa.models.Empresa;
import com.backend.restempresa.repositories.EmpresaRepository;
import com.backend.restempresa.services.EmpresaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * The type Empresa service.
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Resource
    private EmpresaRepository repository;

    @Override
    public void save(Empresa empresa) {
        repository.save(empresa);
    }

    @Override
    public void update(Empresa empresa) {
        repository.save(empresa);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return  repository.existsByNombre(nombre);
    }

    @Override
    public boolean existsByDireccion(String direccion) {
        return repository.existsByDireccion(direccion);
    }

    @Override
    public boolean existsByNit(String nit) {
        return repository.existsByNumeroNit(nit);
    }

    @Override
    public Optional<Empresa> getOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Empresa> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public Optional<Empresa> getByNumeroNit(String nit) {
        return repository.findByNumeroNit(nit);
    }
}
