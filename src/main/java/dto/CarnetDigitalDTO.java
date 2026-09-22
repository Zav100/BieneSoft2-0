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
public class CarnetDigitalDTO implements Serializable {
    
    private Integer idCarnetDigital;
    private String codigoQrUrl;
    private Date fechaEmision;
    private String estado;
    private SocioDTO socio; //DTO anidado (no la entidad) - para msotrar datos del socio en el carnet
    // parametros extras aqui...

    public CarnetDigitalDTO() {
    }

    public CarnetDigitalDTO(Integer idCarnetDigital, String codigoQrUrl, Date fechaEmision, String estado, SocioDTO socio) {
        this.idCarnetDigital = idCarnetDigital;
        this.codigoQrUrl = codigoQrUrl;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.socio = socio;
    }

    public Integer getIdCarnetDigital() {
        return idCarnetDigital;
    }

    public void setIdCarnetDigital(Integer idCarnetDigital) {
        this.idCarnetDigital = idCarnetDigital;
    }

    public String getCodigoQrUrl() {
        return codigoQrUrl;
    }

    public void setCodigoQrUrl(String codigoQrUrl) {
        this.codigoQrUrl = codigoQrUrl;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SocioDTO getSocio() {
        return socio;
    }

    public void setSocio(SocioDTO socio) {
        this.socio = socio;
    }   
    
    
}
