package com.backend.restempresa.services;

import com.backend.restempresa.models.Empresa;

import java.util.Optional;

/**
 * The interface Empresa service.
 */
public interface EmpresaService {
    /**
     * Save.
     *
     * @param empresa the empresa
     */
    void save(Empresa empresa);

    /**
     * Update.
     *
     * @param empresa the empresa
     */
    void update(Empresa empresa);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);

    /**
     * Exists by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean existsById(int id);

    /**
     * Exists by nombre boolean.
     *
     * @param nombre the nombre
     * @return the boolean
     */
    boolean existsByNombre(String nombre);

    /**
     * Exists by direccion boolean.
     *
     * @param direccion the direccion
     * @return the boolean
     */
    boolean existsByDireccion(String direccion);

    /**
     * Exists by nit boolean.
     *
     * @param nit the nit
     * @return the boolean
     */
    boolean existsByNit(String nit);

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    Optional<Empresa> getOne(int id);

    /**
     * Gets by nombre.
     *
     * @param nombre the nombre
     * @return the by nombre
     */
    Optional<Empresa> getByNombre(String nombre);

    /**
     * Gets by numero nit.
     *
     * @param nit the nit
     * @return the by numero nit
     */
    Optional<Empresa> getByNumeroNit(String nit);
}
