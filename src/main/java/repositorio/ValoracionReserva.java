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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
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
@Table(name = "valoracion_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValoracionReserva.findAll", query = "SELECT v FROM ValoracionReserva v"),
    @NamedQuery(name = "ValoracionReserva.findByIdValoracion", query = "SELECT v FROM ValoracionReserva v WHERE v.idValoracion = :idValoracion"),
    @NamedQuery(name = "ValoracionReserva.findByPuntaje", query = "SELECT v FROM ValoracionReserva v WHERE v.puntaje = :puntaje"),
    @NamedQuery(name = "ValoracionReserva.findByFechaValoracion", query = "SELECT v FROM ValoracionReserva v WHERE v.fechaValoracion = :fechaValoracion")})
public class ValoracionReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valoracion")
    private Integer idValoracion;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje")
    private short puntaje;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "comentario")
    private String comentario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_valoracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValoracion;
   
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @OneToOne(optional = false)
    private Reserva idReserva;

    public ValoracionReserva() {
    }

    public ValoracionReserva(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public ValoracionReserva(Integer idValoracion, short puntaje, Date fechaValoracion) {
        this.idValoracion = idValoracion;
        this.puntaje = puntaje;
        this.fechaValoracion = fechaValoracion;
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

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionReserva)) {
            return false;
        }
        ValoracionReserva other = (ValoracionReserva) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.ValoracionReserva[ idValoracion=" + idValoracion + " ]";
    }
    
}
