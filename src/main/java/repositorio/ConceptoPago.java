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
@Table(name = "concepto_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptoPago.findAll", query = "SELECT c FROM ConceptoPago c"),
    @NamedQuery(name = "ConceptoPago.findByIdConcepto", query = "SELECT c FROM ConceptoPago c WHERE c.idConcepto = :idConcepto"),
    @NamedQuery(name = "ConceptoPago.findByNombre", query = "SELECT c FROM ConceptoPago c WHERE c.nombre = :nombre")})
public class ConceptoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_concepto")
    private Integer idConcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcepto")
    private Collection<Pago> pagoCollection;

    public ConceptoPago() {
    }

    public ConceptoPago(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public ConceptoPago(Integer idConcepto, String nombre) {
        this.idConcepto = idConcepto;
        this.nombre = nombre;
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
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
        hash += (idConcepto != null ? idConcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptoPago)) {
            return false;
        }
        ConceptoPago other = (ConceptoPago) object;
        if ((this.idConcepto == null && other.idConcepto != null) || (this.idConcepto != null && !this.idConcepto.equals(other.idConcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.ConceptoPago[ idConcepto=" + idConcepto + " ]";
    }
    
}
