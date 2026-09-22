/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dto.InstalacionDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import servicio.SInstalacion;

/**
 *
 * @author Ana
 */

@Named(value = "instalacionBean")
@SessionScoped
public class BInstalacion implements Serializable {
    
    @Inject
    private SInstalacion servicio;

    private List<InstalacionDTO> listaInstalaciones;
    private InstalacionDTO instalacionSeleccionada;

    
    //inicializador para que no tire nullpointert exception
    @PostConstruct
    public void init() {
        listaInstalaciones = servicio.listarTodos();
    }
    
    
    
    
    //GETTERS Y SETTERS

    public SInstalacion getServicio() {
        return servicio;
    }

    public void setServicio(SInstalacion servicio) {
        this.servicio = servicio;
    }

    public List<InstalacionDTO> getListaInstalaciones() {
        return listaInstalaciones;
    }

    public void setListaInstalaciones(List<InstalacionDTO> listaInstalaciones) {
        this.listaInstalaciones = listaInstalaciones;
    }

    public InstalacionDTO getInstalacionSeleccionada() {
        return instalacionSeleccionada;
    }

    public void setInstalacionSeleccionada(InstalacionDTO instalacionSeleccionada) {
        this.instalacionSeleccionada = instalacionSeleccionada;
    }
    
    
}
