/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

public class InstalacionDTO implements Serializable {
    
    private Integer idInstalacion;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private int cantidadTurnosActivos; //  calculado, no viene directo de la entidad


    // constructor vacio
    public InstalacionDTO() {} 

    // constructor generico con parametros
    public InstalacionDTO(Integer idInstalacion, String nombre, String descripcion, boolean disponible, int cantidadTurnosActivos) {
        this.idInstalacion = idInstalacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.cantidadTurnosActivos = cantidadTurnosActivos;
    }

    
    // getters y setters
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCantidadTurnosActivos() {
        return cantidadTurnosActivos;
    }

    public void setCantidadTurnosActivos(int cantidadTurnosActivos) {
        this.cantidadTurnosActivos = cantidadTurnosActivos;
    }
    
    
    
    

}
