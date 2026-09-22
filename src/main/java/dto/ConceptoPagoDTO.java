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
public class ConceptoPagoDTO implements Serializable{
    
    private Integer idConcepto;
    private String nombre;

    public ConceptoPagoDTO() {
    }

    public ConceptoPagoDTO(Integer idConcepto, String nombre) {
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
    
    
    
}
