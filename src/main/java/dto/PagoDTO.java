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
public class PagoDTO implements Serializable{
     private Integer idPago;
     private BigDecimal monto;
     private Date fechaPago;
     
     //extras
     private ConceptoPagoDTO concepto;
     private MedioPagoDTO medioPago;
     private UsuarioDTO usuario;

    public PagoDTO() {
    }

    public PagoDTO(Integer idPago, BigDecimal monto, Date fechaPago, ConceptoPagoDTO concepto, MedioPagoDTO medioPago, UsuarioDTO usuario) {
        this.idPago = idPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.concepto = concepto;
        this.medioPago = medioPago;
        this.usuario = usuario;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public ConceptoPagoDTO getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoPagoDTO concepto) {
        this.concepto = concepto;
    }

    public MedioPagoDTO getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPagoDTO medioPago) {
        this.medioPago = medioPago;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
     
     
     
}
