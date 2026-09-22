package dto;

import java.io.Serializable;
import java.util.Date;

public class SocioDTO implements Serializable {

    private Integer idSocio;
    private String dni;
    private Date fechaNacimiento;
    private String telefono;
    private String fotoPerfilUrl;
    private String legajo;
    private boolean bajaLogica;
    private CategoriaSocioDTO idCategoriaSocio;   // ← ahora es DTO, no entidad
    private UsuarioDTO idUsuario;                  // ← ahora es DTO, no entidad
    // carnetDigital NO va: es mappedBy (inverso), y ya existe recursión con CarnetDigitalDTO.socio

    public SocioDTO() {
    }

    public SocioDTO(Integer idSocio, String dni, Date fechaNacimiento, String telefono,
            String fotoPerfilUrl, String legajo, boolean bajaLogica,
            CategoriaSocioDTO idCategoriaSocio, UsuarioDTO idUsuario) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.legajo = legajo;
        this.bajaLogica = bajaLogica;
        this.idCategoriaSocio = idCategoriaSocio;
        this.idUsuario = idUsuario;
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

    public boolean isBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }

    public CategoriaSocioDTO getIdCategoriaSocio() {
        return idCategoriaSocio;
    }

    public void setIdCategoriaSocio(CategoriaSocioDTO idCategoriaSocio) {
        this.idCategoriaSocio = idCategoriaSocio;
    }

    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
    }
}
