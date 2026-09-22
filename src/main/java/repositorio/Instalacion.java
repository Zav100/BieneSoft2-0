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
import jakarta.persistence.Lob;
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
@Table(name = "instalacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalacion.findAll", query = "SELECT i FROM Instalacion i"),
    @NamedQuery(name = "Instalacion.findByIdInstalacion", query = "SELECT i FROM Instalacion i WHERE i.idInstalacion = :idInstalacion"),
    @NamedQuery(name = "Instalacion.findByNombre", query = "SELECT i FROM Instalacion i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instalacion.findByDisponible", query = "SELECT i FROM Instalacion i WHERE i.disponible = :disponible")})
public class Instalacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instalacion")
    private Integer idInstalacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible")
    private boolean disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstalacion")
    private Collection<Turno> turnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstalacion")
    private Collection<TarifaAlquiler> tarifaAlquilerCollection;

    public Instalacion() {
    }

    public Instalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public Instalacion(Integer idInstalacion, String nombre, boolean disponible) {
        this.idInstalacion = idInstalacion;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
    }

    @XmlTransient
    public Collection<TarifaAlquiler> getTarifaAlquilerCollection() {
        return tarifaAlquilerCollection;
    }

    public void setTarifaAlquilerCollection(Collection<TarifaAlquiler> tarifaAlquilerCollection) {
        this.tarifaAlquilerCollection = tarifaAlquilerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalacion != null ? idInstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalacion)) {
            return false;
        }
        Instalacion other = (Instalacion) object;
        if ((this.idInstalacion == null && other.idInstalacion != null) || (this.idInstalacion != null && !this.idInstalacion.equals(other.idInstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.Instalacion[ idInstalacion=" + idInstalacion + " ]";
    }
    
}
