/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Ana
 */
public class TarifaAlquilerDTO implements Serializable{
    
    private Integer idTarifa;
    private BigDecimal precio;
    private Date vigenteDesde;
    private Date vigenteHasta;
    
    private CategoriaSocioDTO catSocio;   //(M:1) 
    private InstalacionDTO instalacion;   //(M:1) 
    

    public TarifaAlquilerDTO() {
    }

    public TarifaAlquilerDTO(Integer idTarifa, BigDecimal precio, Date vigenteDesde, Date vigenteHasta, CategoriaSocioDTO catSocio, InstalacionDTO instalacion) {
        this.idTarifa = idTarifa;
        this.precio = precio;
        this.vigenteDesde = vigenteDesde;
        this.vigenteHasta = vigenteHasta;
        this.catSocio = catSocio;
        this.instalacion = instalacion;
        
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getVigenteDesde() {
        return vigenteDesde;
    }

    public void setVigenteDesde(Date vigenteDesde) {
        this.vigenteDesde = vigenteDesde;
    }

    public Date getVigenteHasta() {
        return vigenteHasta;
    }

    public void setVigenteHasta(Date vigenteHasta) {
        this.vigenteHasta = vigenteHasta;
    }

    public CategoriaSocioDTO getCatSocio() {
        return catSocio;
    }

    public void setCatSocio(CategoriaSocioDTO catSocio) {
        this.catSocio = catSocio;
    }

    public InstalacionDTO getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(InstalacionDTO instalacion) {
        this.instalacion = instalacion;
    }

    
    
}
