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
@Table(name = "socio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s"),
    @NamedQuery(name = "Socio.findByIdSocio", query = "SELECT s FROM Socio s WHERE s.idSocio = :idSocio"),
    @NamedQuery(name = "Socio.findByDni", query = "SELECT s FROM Socio s WHERE s.dni = :dni"),
    @NamedQuery(name = "Socio.findByFechaNacimiento", query = "SELECT s FROM Socio s WHERE s.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Socio.findByTelefono", query = "SELECT s FROM Socio s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Socio.findByFotoPerfilUrl", query = "SELECT s FROM Socio s WHERE s.fotoPerfilUrl = :fotoPerfilUrl"),
    @NamedQuery(name = "Socio.findByLegajo", query = "SELECT s FROM Socio s WHERE s.legajo = :legajo"),
    @NamedQuery(name = "Socio.findByBajaLogica", query = "SELECT s FROM Socio s WHERE s.bajaLogica = :bajaLogica")})
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_socio")
    private Integer idSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 255)
    @Column(name = "foto_perfil_url")
    private String fotoPerfilUrl;
    @Size(max = 20)
    @Column(name = "legajo")
    private String legajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baja_logica")
    private boolean bajaLogica;
   
    @JoinColumn(name = "id_categoria_socio", referencedColumnName = "id_categoria_socio")
    @ManyToOne(optional = false)
    private CategoriaSocio idCategoriaSocio;
   
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false)
    private Usuario idUsuario;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSocio")
    private Collection<SuscripcionSocio> suscripcionSocioCollection;
   
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idSocio")
    private CarnetDigital carnetDigital;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSocio")
    private Collection<Reserva> reservaCollection;

    public Socio() {
    }

    public Socio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public Socio(Integer idSocio, String dni, Date fechaNacimiento, boolean bajaLogica) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.bajaLogica = bajaLogica;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }

    public CategoriaSocio getIdCategoriaSocio() {
        return idCategoriaSocio;
    }

    public void setIdCategoriaSocio(CategoriaSocio idCategoriaSocio) {
        this.idCategoriaSocio = idCategoriaSocio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<SuscripcionSocio> getSuscripcionSocioCollection() {
        return suscripcionSocioCollection;
    }

    public void setSuscripcionSocioCollection(Collection<SuscripcionSocio> suscripcionSocioCollection) {
        this.suscripcionSocioCollection = suscripcionSocioCollection;
    }

    public CarnetDigital getCarnetDigital() {
        return carnetDigital;
    }

    public void setCarnetDigital(CarnetDigital carnetDigital) {
        this.carnetDigital = carnetDigital;
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
        hash += (idSocio != null ? idSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repositorio.Socio[ idSocio=" + idSocio + " ]";
    }
    
}
