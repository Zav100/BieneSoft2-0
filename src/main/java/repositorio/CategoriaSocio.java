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
@Table(name = "categoria_socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaSocio.findAll", query = "SELECT c FROM CategoriaSocio c"),
    @NamedQuery(name = "CategoriaSocio.findByIdCategoriaSocio", query = "SELECT c FROM CategoriaSocio c WHERE c.idCategoriaSocio = :idCategoriaSocio"),
    @NamedQuery(name = "CategoriaSocio.findByNombreCategoria", query = "SELECT c FROM CategoriaSocio c WHERE c.nombreCategoria = :nombreCategoria"),
    @NamedQuery(name = "CategoriaSocio.findByRequiereLegajo", query = "SELECT c FROM CategoriaSocio c WHERE c.requiereLegajo = :requiereLegajo")})
public class CategoriaSocio implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_socio")
    private Integer idCategoriaSocio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_categoria")    
    private String nombreCategoria;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "requiere_legajo")
    private boolean requiereLegajo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaSocio")
    private Collection<Socio> socioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaSocio")
    private Collection<TarifaAlquiler> tarifaAlquilerCollection;

    public CategoriaSocio() {
    }

    public CategoriaSocio(Integer idCategoriaSocio) {
        this.idCategoriaSocio = idCategoriaSocio;
    }

    public CategoriaSocio(Integer idCategoriaSocio, String nombreCategoria, boolean requiereLegajo) {
        this.idCategoriaSocio = idCategoriaSocio;
        this.nombreCategoria = nombreCategoria;
        this.requiereLegajo = requiereLegajo;
    }

    public Integer getIdCategoriaSocio() {
        return idCategoriaSocio;
    }

    public void setIdCategoriaSocio(Integer idCategoriaSocio) {
        this.idCategoriaSocio = idCategoriaSocio;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean getRequiereLegajo() {
        return requiereLegajo;
    }

    public void setRequiereLegajo(boolean requiereLegajo) {
        this.requiereLegajo = requiereLegajo;
    }

    @XmlTransient
    public Collection<Socio> getSocioCollection() {
        return socioCollection;
    }

    public void setSocioCollection(Collection<Socio> socioCollection) {
        this.socioCollection = socioCollection;
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
        hash += (idCategoriaSocio != null ? idCategoriaSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaSocio)) {
            return false;
        }
        CategoriaSocio other = (CategoriaSocio) object;
        if ((this.idCategoriaSocio == null && other.idCategoriaSocio != null) || (this.idCategoriaSocio != null && !this.idCategoriaSocio.equals(other.idCategoriaSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.CategoriaSocio[ idCategoriaSocio=" + idCategoriaSocio + " ]";
    }
    
}
