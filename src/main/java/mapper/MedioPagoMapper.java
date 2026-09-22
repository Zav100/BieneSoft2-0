/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.MedioPagoDTO;
import repositorio.MedioPago;

/**
 *
 * @author Ana
 */
public class MedioPagoMapper {
    
    
   //convertir MedioPago (entidad) → dto
    public static MedioPagoDTO toDTO(MedioPago medioPago) {
        if (medioPago == null) return null;
        
        return new MedioPagoDTO(
                medioPago.getIdMedioPago(),
                medioPago.getNombre()
                
        );
    }
    
    // convertir dto → MedioPago (entidad)
     public static MedioPago toEntity(MedioPagoDTO dto) {
        if (dto == null) return null;
        
        MedioPago medioPago = new MedioPago();
             
        medioPago.setIdMedioPago(dto.getIdMedioPago());
        medioPago.setNombre(dto.getNombre());
        
        return medioPago;
    }
    
     
}
