/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Ana
 */
public class CategoriaSocioDTO implements Serializable {
    
    private Integer idCategoriaSocio;
    private String nombreCategoria;
    private boolean requiereLegajo;
    
    
    
    
    // ... el resto de los campos que necesita la vista (no todos los de la entidad, solo los que se muestran/editan)
    
    
    //CONSTRUCTOR VACIO
    public CategoriaSocioDTO(){}

    //CONSTRUCTOR CON PARAM
    public CategoriaSocioDTO(Integer idCategoriaSocio, String nombreCategoria, boolean requiereLegajo) {
        this.idCategoriaSocio = idCategoriaSocio;
        this.nombreCategoria = nombreCategoria;
        this.requiereLegajo = requiereLegajo;
    }

    
    //GETTERS Y SETTERS
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

    public boolean isRequiereLegajo() {
        return requiereLegajo;
    }

    public void setRequiereLegajo(boolean requiereLegajo) {
        this.requiereLegajo = requiereLegajo;
    }

    
}
