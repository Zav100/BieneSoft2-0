package dto;

import java.io.Serializable;
import java.util.Date;

public class HistorialReservaDTO implements Serializable {

    private Integer idHistorial;
    private Date fechaAnterior;
    private String motivo;
    private Date fechaCambio;
    private TurnoDTO turnoAnterior;

    public HistorialReservaDTO() {
    }

    public HistorialReservaDTO(Integer idHistorial, Date fechaAnterior, String motivo,
            Date fechaCambio, TurnoDTO turnoAnterior) {
        this.idHistorial = idHistorial;
        this.fechaAnterior = fechaAnterior;
        this.motivo = motivo;
        this.fechaCambio = fechaCambio;
        this.turnoAnterior = turnoAnterior;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Date getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(Date fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public TurnoDTO getTurnoAnterior() {
        return turnoAnterior;
    }

    public void setTurnoAnterior(TurnoDTO turnoAnterior) {
        this.turnoAnterior = turnoAnterior;
    }
}
