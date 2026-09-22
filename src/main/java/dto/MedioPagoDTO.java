/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Ana
 */
public class MedioPagoDTO implements Serializable {
    
    private Integer idMedioPago;
    private String nombre;

    public MedioPagoDTO() {
    }

    public MedioPagoDTO(Integer idMedioPago, String nombre) {
        this.idMedioPago = idMedioPago;
        this.nombre = nombre;
    }

    public Integer getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(Integer idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
