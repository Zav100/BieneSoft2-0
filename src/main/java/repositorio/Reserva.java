/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Ana
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaReserva", query = "SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reserva.findByFechaCreacion", query = "SELECT r FROM Reserva r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Reserva.findByActiva", query = "SELECT r FROM Reserva r WHERE r.activa = :activa"),
    @NamedQuery(name = "Reserva.findByFechaLimiteReprogramacion", query = "SELECT r FROM Reserva r WHERE r.fechaLimiteReprogramacion = :fechaLimiteReprogramacion"),
    @NamedQuery(name = "Reserva.findByTurnoActivoKey", query = "SELECT r FROM Reserva r WHERE r.turnoActivoKey = :turnoActivoKey")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_reserva")
    @Temporal(TemporalType.DATE)
    private Date fechaReserva;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa")
    private boolean activa;
    
    @Column(name = "fecha_limite_reprogramacion")
    @Temporal(TemporalType.DATE)
    private Date fechaLimiteReprogramacion;
    
    @Size(max = 30)
    @Column(name = "turno_activo_key")
    private String turnoActivoKey;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private Collection<HistorialReserva> historialReservaCollection;
   
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @OneToOne(optional = false)
    private Pago idPago;
   
    @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    @ManyToOne(optional = false)
    private Socio idSocio;
   
    @JoinColumn(name = "id_tarifa", referencedColumnName = "id_tarifa")
    @ManyToOne(optional = false)
    private TarifaAlquiler idTarifa;
   
    @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")
    @ManyToOne(optional = false)
    private Turno idTurno;
   
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idReserva")
    private ValoracionReserva valoracionReserva;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Integer idReserva, Date fechaReserva, Date fechaCreacion, boolean activa) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaCreacion = fechaCreacion;
        this.activa = activa;
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

    public boolean getActiva() {
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

    public String getTurnoActivoKey() {
        return turnoActivoKey;
    }

    public void setTurnoActivoKey(String turnoActivoKey) {
        this.turnoActivoKey = turnoActivoKey;
    }

    @XmlTransient
    public Collection<HistorialReserva> getHistorialReservaCollection() {
        return historialReservaCollection;
    }

    public void setHistorialReservaCollection(Collection<HistorialReserva> historialReservaCollection) {
        this.historialReservaCollection = historialReservaCollection;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    public Socio getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socio idSocio) {
        this.idSocio = idSocio;
    }

    public TarifaAlquiler getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(TarifaAlquiler idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Turno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Turno idTurno) {
        this.idTurno = idTurno;
    }

    public ValoracionReserva getValoracionReserva() {
        return valoracionReserva;
    }

    public void setValoracionReserva(ValoracionReserva valoracionReserva) {
        this.valoracionReserva = valoracionReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
