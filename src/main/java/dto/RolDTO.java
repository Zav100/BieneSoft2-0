/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.List;
import repositorio.Usuario;

/**
 *
 * @author Ana
 */
public class RolDTO implements Serializable{
    
    private Integer idRol;
    private String nombreRol;
    //private List<Usuario> usuariosRol;

    public RolDTO() {
    }

    public RolDTO(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        //this.usuariosRol = usuariosRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

//    public List<Usuario> getUsuariosRol() {
//        return usuariosRol;
//    }
//
//    public void setUsuariosRol(List<Usuario> usuariosRol) {
//        this.usuariosRol = usuariosRol;
//    }
    
    
    
}
