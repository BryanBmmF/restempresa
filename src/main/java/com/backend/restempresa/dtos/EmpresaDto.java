package com.backend.restempresa.dtos;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Empresa dto.
 */
public class EmpresaDto {
    private int id;
    private String nombre;
    private String numeroNit;
    private Date fechaFundacion;
    private String direccion;

    /**
     * Instantiates a new Empresa dto.
     */
    public EmpresaDto() {
    }

    /**
     * Instantiates a new Empresa dto.
     *
     * @param id             the id
     * @param nombre         the nombre
     * @param numeroNit      the numero nit
     * @param fechaFundacion the fecha fundacion
     * @param direccion      the direccion
     */
    public EmpresaDto(int id, String nombre, String numeroNit, Date fechaFundacion, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.numeroNit = numeroNit;
        this.fechaFundacion = fechaFundacion;
        this.direccion = direccion;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets numero nit.
     *
     * @return the numero nit
     */
    public String getNumeroNit() {
        return numeroNit;
    }

    /**
     * Sets numero nit.
     *
     * @param numeroNit the numero nit
     */
    public void setNumeroNit(String numeroNit) {
        this.numeroNit = numeroNit;
    }

    /**
     * Gets fecha fundacion.
     *
     * @return the fecha fundacion
     */
    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    /**
     * Sets fecha fundacion.
     *
     * @param fechaFundacion the fecha fundacion
     */
    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    /**
     * Gets direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets direccion.
     *
     * @param direccion the direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
