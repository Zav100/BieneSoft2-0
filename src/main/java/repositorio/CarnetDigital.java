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
@Table(name = "carnet_digital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarnetDigital.findAll", query = "SELECT c FROM CarnetDigital c"),
    @NamedQuery(name = "CarnetDigital.findByIdCarnet", query = "SELECT c FROM CarnetDigital c WHERE c.idCarnet = :idCarnet"),
    @NamedQuery(name = "CarnetDigital.findByCodigoQrUrl", query = "SELECT c FROM CarnetDigital c WHERE c.codigoQrUrl = :codigoQrUrl"),
    @NamedQuery(name = "CarnetDigital.findByFechaEmision", query = "SELECT c FROM CarnetDigital c WHERE c.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "CarnetDigital.findByEstado", query = "SELECT c FROM CarnetDigital c WHERE c.estado = :estado")})
public class CarnetDigital implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carnet")
    private Integer idCarnet;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "codigo_qr_url")
    private String codigoQrUrl;
    @Basic(optional = false)
    
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    
    @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    @OneToOne(optional = false)
    private Socio idSocio;

    public CarnetDigital() {
    }

    public CarnetDigital(Integer idCarnet) {
        this.idCarnet = idCarnet;
    }

    public CarnetDigital(Integer idCarnet, String codigoQrUrl, Date fechaEmision, String estado) {
        this.idCarnet = idCarnet;
        this.codigoQrUrl = codigoQrUrl;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
    }

    public Integer getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(Integer idCarnet) {
        this.idCarnet = idCarnet;
    }

    public String getCodigoQrUrl() {
        return codigoQrUrl;
    }

    public void setCodigoQrUrl(String codigoQrUrl) {
        this.codigoQrUrl = codigoQrUrl;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idCarnet != null ? idCarnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarnetDigital)) {
            return false;
        }
        CarnetDigital other = (CarnetDigital) object;
        if ((this.idCarnet == null && other.idCarnet != null) || (this.idCarnet != null && !this.idCarnet.equals(other.idCarnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.CarnetDigital[ idCarnet=" + idCarnet + " ]";
    }
    
}
