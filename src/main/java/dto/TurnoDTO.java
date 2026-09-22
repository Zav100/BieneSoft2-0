/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import repositorio.HistorialReserva;
import repositorio.Instalacion;

/**
 *
 * @author Ana
 */
public class TurnoDTO implements Serializable{
    private Integer idTurno;
    private Date horaInicio;
    private Date horaFin;
    
    private InstalacionDTO instalacion;                          //(M:1)
    //private List<HistorialReservaDTO> historial;     //(1:M)
    //private List<ReservaDTO> reserva;     //(1:M)

    public TurnoDTO() {
    }

    public TurnoDTO(Integer idTurno, Date horaInicio, Date horaFin, InstalacionDTO instalacion) {
        this.idTurno = idTurno;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.instalacion = instalacion;
       // this.historial = historial;
        //this.reserva = reserva;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public InstalacionDTO getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(InstalacionDTO instalacion) {
        this.instalacion = instalacion;
    }

//    public List<HistorialReservaDTO> getHistorial() {
//        return historial;
//    }
//
//    public void setHistorial(List<HistorialReservaDTO> historial) {
//        this.historial = historial;
//    }
//
//    public List<ReservaDTO> getReserva() {
//        return reserva;
//    }
//
//    public void setReserva(List<ReservaDTO> reserva) {
//        this.reserva = reserva;
//    }
//    
    
}
