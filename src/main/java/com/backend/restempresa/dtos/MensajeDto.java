package com.backend.restempresa.dtos;

/**
 * The type Mensaje dto.
 */
public class MensajeDto {

    private String mensaje;

    /**
     * Instantiates a new Mensaje dto.
     *
     * @param mensaje the mensaje
     */
    public MensajeDto(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Gets mensaje.
     *
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets mensaje.
     *
     * @param mensaje the mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
