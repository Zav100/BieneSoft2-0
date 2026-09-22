/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ana
 */
public class SuscripcionDTO implements Serializable{
    private Integer idSuscripcion;
    private Date fechaInicio;
    private Date fechaVencimiento;
    
    private PagoDTO pago;                          // idPago (1:1) → DTO anidado
    private SocioDTO socio;                         // idSocio (M:1) → DTO anidado

    public SuscripcionDTO() {
    }

    public SuscripcionDTO(Integer idSuscripcion, Date fechaInicio, Date fechaVencimiento, PagoDTO pago, SocioDTO socio) {
        this.idSuscripcion = idSuscripcion;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.pago = pago;
        this.socio = socio;
    }

    public Integer getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(Integer idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }

    public SocioDTO getSocio() {
        return socio;
    }

    public void setSocio(SocioDTO socio) {
        this.socio = socio;
    }
    
    
    
}
