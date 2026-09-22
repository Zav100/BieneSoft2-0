/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import repositorio.Reserva;

/**
 *
 * @author Ana
 */
public class ValoracionReservaDTO implements Serializable{
    private Integer idValoracion;
    private short puntaje;
    private String comentario;
    private Date fechaValoracion;
    
    //private ReservaDTO reserva;                          //(1:1)

    public ValoracionReservaDTO() {
    }

    public ValoracionReservaDTO(Integer idValoracion, short puntaje, String comentario, Date fechaValoracion) {
        this.idValoracion = idValoracion;
        this.puntaje = puntaje;
        this.comentario = comentario;
        this.fechaValoracion = fechaValoracion;
        //this.reserva = reserva;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public short getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(short puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

//    public ReservaDTO getReserva() {
//        return reserva;
//    }
//
//    public void setReserva(ReservaDTO reserva) {
//        this.reserva = reserva;
//    }
    
    
}
