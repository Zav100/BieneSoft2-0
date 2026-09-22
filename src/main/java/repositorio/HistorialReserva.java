/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ana
 */
@Entity
@Table(name = "historial_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialReserva.findAll", query = "SELECT h FROM HistorialReserva h"),
    @NamedQuery(name = "HistorialReserva.findByIdHistorial", query = "SELECT h FROM HistorialReserva h WHERE h.idHistorial = :idHistorial"),
    @NamedQuery(name = "HistorialReserva.findByFechaAnterior", query = "SELECT h FROM HistorialReserva h WHERE h.fechaAnterior = :fechaAnterior"),
    @NamedQuery(name = "HistorialReserva.findByMotivo", query = "SELECT h FROM HistorialReserva h WHERE h.motivo = :motivo"),
    @NamedQuery(name = "HistorialReserva.findByFechaCambio", query = "SELECT h FROM HistorialReserva h WHERE h.fechaCambio = :fechaCambio")})
public class HistorialReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial")
    private Integer idHistorial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_anterior")
    @Temporal(TemporalType.DATE)
    private Date fechaAnterior;
    @Size(max = 200)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @ManyToOne(optional = false)
    private Reserva idReserva;
    @JoinColumn(name = "id_turno_anterior", referencedColumnName = "id_turno")
    @ManyToOne(optional = false)
    private Turno idTurnoAnterior;

    public HistorialReserva() {
    }

    public HistorialReserva(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public HistorialReserva(Integer idHistorial, Date fechaAnterior, Date fechaCambio) {
        this.idHistorial = idHistorial;
        this.fechaAnterior = fechaAnterior;
        this.fechaCambio = fechaCambio;
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

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Turno getIdTurnoAnterior() {
        return idTurnoAnterior;
    }

    public void setIdTurnoAnterior(Turno idTurnoAnterior) {
        this.idTurnoAnterior = idTurnoAnterior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialReserva)) {
            return false;
        }
        HistorialReserva other = (HistorialReserva) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.HistorialReserva[ idHistorial=" + idHistorial + " ]";
    }
    
}
