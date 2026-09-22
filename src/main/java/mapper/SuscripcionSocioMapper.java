/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.SuscripcionDTO;
import repositorio.SuscripcionSocio;

/**
 *
 * @author Ana
 */
public class SuscripcionSocioMapper {
    
    //convertir SuscripcionSocio (entidad) → dto
    public static SuscripcionDTO toDTO(SuscripcionSocio suscripcionSocio) {
        if (suscripcionSocio == null) return null;
        
        return new SuscripcionDTO(
                suscripcionSocio.getIdSuscripcion(),
                suscripcionSocio.getFechaInicio(),
                suscripcionSocio.getFechaVencimiento(),
                
                PagoMapper.toDTO(suscripcionSocio.getIdPago()),
                SocioMapper.toDTO(suscripcionSocio.getIdSocio())                             
        );
    }
    
    
    public static SuscripcionSocio toEntity(SuscripcionDTO dto) {
        if (dto == null) {
            return null;
        }
        
        SuscripcionSocio suscripcionSocio = new SuscripcionSocio();

        suscripcionSocio.setIdSuscripcion(dto.getIdSuscripcion());
        suscripcionSocio.setFechaInicio(dto.getFechaInicio());
        suscripcionSocio.setFechaVencimiento(dto.getFechaVencimiento());
        suscripcionSocio.setIdPago(PagoMapper.toEntity(dto.getPago()));
        suscripcionSocio.setIdSocio(SocioMapper.toEntity(dto.getSocio()));

        return suscripcionSocio;
    }
}
