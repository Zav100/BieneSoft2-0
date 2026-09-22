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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Ana
 */
@Entity
@Table(name = "tarifa_alquiler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaAlquiler.findAll", query = "SELECT t FROM TarifaAlquiler t"),
    @NamedQuery(name = "TarifaAlquiler.findByIdTarifa", query = "SELECT t FROM TarifaAlquiler t WHERE t.idTarifa = :idTarifa"),
    @NamedQuery(name = "TarifaAlquiler.findByPrecio", query = "SELECT t FROM TarifaAlquiler t WHERE t.precio = :precio"),
    @NamedQuery(name = "TarifaAlquiler.findByVigenteDesde", query = "SELECT t FROM TarifaAlquiler t WHERE t.vigenteDesde = :vigenteDesde"),
    @NamedQuery(name = "TarifaAlquiler.findByVigenteHasta", query = "SELECT t FROM TarifaAlquiler t WHERE t.vigenteHasta = :vigenteHasta")})
public class TarifaAlquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarifa")
    private Integer idTarifa;
    
// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigente_desde")
    @Temporal(TemporalType.DATE)
    private Date vigenteDesde;
    
    @Column(name = "vigente_hasta")
    @Temporal(TemporalType.DATE)
    private Date vigenteHasta;
    
    @JoinColumn(name = "id_categoria_socio", referencedColumnName = "id_categoria_socio")
    @ManyToOne(optional = false)
    private CategoriaSocio idCategoriaSocio;
    
    @JoinColumn(name = "id_instalacion", referencedColumnName = "id_instalacion")
    @ManyToOne(optional = false)
    private Instalacion idInstalacion;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarifa")
    private Collection<Reserva> reservaCollection;

    public TarifaAlquiler() {
    }

    public TarifaAlquiler(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public TarifaAlquiler(Integer idTarifa, BigDecimal precio, Date vigenteDesde) {
        this.idTarifa = idTarifa;
        this.precio = precio;
        this.vigenteDesde = vigenteDesde;
    }

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getVigenteDesde() {
        return vigenteDesde;
    }

    public void setVigenteDesde(Date vigenteDesde) {
        this.vigenteDesde = vigenteDesde;
    }

    public Date getVigenteHasta() {
        return vigenteHasta;
    }

    public void setVigenteHasta(Date vigenteHasta) {
        this.vigenteHasta = vigenteHasta;
    }

    public CategoriaSocio getIdCategoriaSocio() {
        return idCategoriaSocio;
    }

    public void setIdCategoriaSocio(CategoriaSocio idCategoriaSocio) {
        this.idCategoriaSocio = idCategoriaSocio;
    }

    public Instalacion getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Instalacion idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifa != null ? idTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaAlquiler)) {
            return false;
        }
        TarifaAlquiler other = (TarifaAlquiler) object;
        if ((this.idTarifa == null && other.idTarifa != null) || (this.idTarifa != null && !this.idTarifa.equals(other.idTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.TarifaAlquiler[ idTarifa=" + idTarifa + " ]";
    }
    
}
