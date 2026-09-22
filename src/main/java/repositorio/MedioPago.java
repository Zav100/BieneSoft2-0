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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Ana
 */
@Entity
@Table(name = "medio_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioPago.findAll", query = "SELECT m FROM MedioPago m"),
    @NamedQuery(name = "MedioPago.findByIdMedioPago", query = "SELECT m FROM MedioPago m WHERE m.idMedioPago = :idMedioPago"),
    @NamedQuery(name = "MedioPago.findByNombre", query = "SELECT m FROM MedioPago m WHERE m.nombre = :nombre")})
public class MedioPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_pago")
    private Integer idMedioPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedioPago")
    private Collection<Pago> pagoCollection;

    public MedioPago() {
    }

    public MedioPago(Integer idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public MedioPago(Integer idMedioPago, String nombre) {
        this.idMedioPago = idMedioPago;
        this.nombre = nombre;
    }

    public Integer getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(Integer idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioPago != null ? idMedioPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioPago)) {
            return false;
        }
        MedioPago other = (MedioPago) object;
        if ((this.idMedioPago == null && other.idMedioPago != null) || (this.idMedioPago != null && !this.idMedioPago.equals(other.idMedioPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.MedioPago[ idMedioPago=" + idMedioPago + " ]";
    }
    
}
