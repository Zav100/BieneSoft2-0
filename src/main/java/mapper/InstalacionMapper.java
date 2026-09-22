/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.InstalacionDTO;
import repositorio.Instalacion;

/**
 *
 * @author Ana
 */
public class InstalacionMapper {
    
    //convertir instalacion (entidad) → dto
    public static InstalacionDTO toDTO(Instalacion instalacion) {
        if (instalacion == null) return null;
        int turnos = instalacion.getTurnoCollection() != null ? instalacion.getTurnoCollection().size() : 0;
        return new InstalacionDTO(
                instalacion.getIdInstalacion(),
                instalacion.getNombre(),
                instalacion.getDescripcion(),
                instalacion.getDisponible(),
                turnos
        );
    }
    
    
    // convertir dto → instalacion (entidad)
     public static Instalacion toEntity(InstalacionDTO dto) {
        if (dto == null) return null;
        
        Instalacion instalacion = new Instalacion();
        
        instalacion.setIdInstalacion(dto.getIdInstalacion());
        instalacion.setNombre(dto.getNombre());
        instalacion.setDescripcion(dto.getDescripcion());
        instalacion.setDisponible(dto.isDisponible());
        return instalacion;
    }
    
}
