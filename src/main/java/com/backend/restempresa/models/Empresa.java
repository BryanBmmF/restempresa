package com.backend.restempresa.models;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Empresa.
 */
@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numeroNit")
    private String numeroNit;
    @Column(name = "fechaFundacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFundacion;
    @Column(name = "direccion")
    private String direccion;

    /**
     * Instantiates a new Empresa.
     *
     * @param nombre         the nombre
     * @param numeroNit      the numero nit
     * @param fechaFundacion the fecha fundacion
     * @param direccion      the direccion
     */
    public Empresa(String nombre, String numeroNit, Date fechaFundacion, String direccion) {
        this.nombre = nombre;
        this.numeroNit = numeroNit;
        this.fechaFundacion = fechaFundacion;
        this.direccion = direccion;
    }

    /**
     * Instantiates a new Empresa.
     */
    public Empresa() {
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
