/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ana
 */
public class ReservaDTO implements Serializable{
    private Integer idReserva;
    private Date fechaReserva;
    private Date fechaCreacion;
    private boolean activa;
    private Date fechaLimiteReprogramacion;
    
    private PagoDTO pago;                          // idPago (1:1) → DTO anidado
    private SocioDTO socio;                         // idSocio (M:1) → DTO anidado
    private TarifaAlquilerDTO tarifa;                // idTarifa (M:1) → DTO anidado
    private TurnoDTO turno;                          // idTurno (M:1) → DTO anidado
    private ValoracionReservaDTO valoracion;         // valoracionReserva (1:1, puede ser null)
    private List<HistorialReservaDTO> historial;     // historialReservaCollection (1:M) → lista

    public ReservaDTO() {
    }

    public ReservaDTO(Integer idReserva, Date fechaReserva, Date fechaCreacion, boolean activa, Date fechaLimiteReprogramacion, PagoDTO pago, SocioDTO socio, TarifaAlquilerDTO tarifa, TurnoDTO turno, ValoracionReservaDTO valoracion, List<HistorialReservaDTO> historial) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaCreacion = fechaCreacion;
        this.activa = activa;
        this.fechaLimiteReprogramacion = fechaLimiteReprogramacion;
        this.pago = pago;
        this.socio = socio;
        this.tarifa = tarifa;
        this.turno = turno;
        this.valoracion = valoracion;
        this.historial = historial;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Date getFechaLimiteReprogramacion() {
        return fechaLimiteReprogramacion;
    }

    public void setFechaLimiteReprogramacion(Date fechaLimiteReprogramacion) {
        this.fechaLimiteReprogramacion = fechaLimiteReprogramacion;
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

    public TarifaAlquilerDTO getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifaAlquilerDTO tarifa) {
        this.tarifa = tarifa;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public ValoracionReservaDTO getValoracion() {
        return valoracion;
    }

    public void setValoracion(ValoracionReservaDTO valoracion) {
        this.valoracion = valoracion;
    }

    public List<HistorialReservaDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialReservaDTO> historial) {
        this.historial = historial;
    }
   
    
    
    
}
