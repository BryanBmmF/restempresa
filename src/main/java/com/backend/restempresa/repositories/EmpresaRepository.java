package com.backend.restempresa.repositories;

import com.backend.restempresa.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Empresa repository.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
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
     * Exists by numero nit boolean.
     *
     * @param nit the nit
     * @return the boolean
     */
    boolean existsByNumeroNit(String nit);

    /**
     * Find by nombre optional.
     *
     * @param nombre the nombre
     * @return the optional
     */
    Optional<Empresa> findByNombre(String nombre);

    /**
     * Find by numero nit optional.
     *
     * @param nit the nit
     * @return the optional
     */
    Optional<Empresa> findByNumeroNit(String nit);
}
