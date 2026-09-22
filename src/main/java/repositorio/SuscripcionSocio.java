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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ana
 */
@Entity
@Table(name = "suscripcion_socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuscripcionSocio.findAll", query = "SELECT s FROM SuscripcionSocio s"),
    @NamedQuery(name = "SuscripcionSocio.findByIdSuscripcion", query = "SELECT s FROM SuscripcionSocio s WHERE s.idSuscripcion = :idSuscripcion"),
    @NamedQuery(name = "SuscripcionSocio.findByFechaInicio", query = "SELECT s FROM SuscripcionSocio s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "SuscripcionSocio.findByFechaVencimiento", query = "SELECT s FROM SuscripcionSocio s WHERE s.fechaVencimiento = :fechaVencimiento")})
public class SuscripcionSocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_suscripcion")
    private Integer idSuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @OneToOne(optional = false)
    private Pago idPago;
    
    @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    @ManyToOne(optional = false)
    private Socio idSocio;

    public SuscripcionSocio() {
    }

    public SuscripcionSocio(Integer idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public SuscripcionSocio(Integer idSuscripcion, Date fechaInicio, Date fechaVencimiento) {
        this.idSuscripcion = idSuscripcion;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(Integer idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuscripcion != null ? idSuscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuscripcionSocio)) {
            return false;
        }
        SuscripcionSocio other = (SuscripcionSocio) object;
        if ((this.idSuscripcion == null && other.idSuscripcion != null) || (this.idSuscripcion != null && !this.idSuscripcion.equals(other.idSuscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.SuscripcionSocio[ idSuscripcion=" + idSuscripcion + " ]";
    }
    
}
