/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.ConceptoPagoDTO;
import repositorio.ConceptoPago;

/**
 *
 * @author Ana
 */
public class ConceptoPagoMapper {
    
    //convertir ConceptoPago (entidad) → dto
    public static ConceptoPagoDTO toDTO(ConceptoPago conceptoPago) {
        if (conceptoPago == null) return null;
        
        return new ConceptoPagoDTO(
                conceptoPago.getIdConcepto(),
                conceptoPago.getNombre()
                
        );
    }
    
    // convertir dto → ConceptoPago (entidad)
     public static ConceptoPago toEntity(ConceptoPagoDTO dto) {
        if (dto == null) return null;
        
        ConceptoPago conceptoPago = new ConceptoPago();
             
        conceptoPago.setIdConcepto(dto.getIdConcepto());
        conceptoPago.setNombre(dto.getNombre());
        
        return conceptoPago;
    }
    
}
