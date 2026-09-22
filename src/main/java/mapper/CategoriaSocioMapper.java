/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.CategoriaSocioDTO;
import repositorio.CategoriaSocio;

/**
 *
 * @author Ana
 */
public class CategoriaSocioMapper {
    
    //convertir CategoriaSocio (entidad) → dto
    public static CategoriaSocioDTO toDTO(CategoriaSocio categoriaSocio) {
        if (categoriaSocio == null) return null;
        
        return new CategoriaSocioDTO(
                categoriaSocio.getIdCategoriaSocio(),
                categoriaSocio.getNombreCategoria(),
                categoriaSocio.getRequiereLegajo()
        );
    }
    
    
    // convertir dto → CategoriaSocio (entidad)
     public static CategoriaSocio toEntity(CategoriaSocioDTO dto) {
        if (dto == null) return null;
        
        CategoriaSocio categoriaSocio = new CategoriaSocio();
        
        categoriaSocio.setIdCategoriaSocio(dto.getIdCategoriaSocio());
        categoriaSocio.setNombreCategoria(dto.getNombreCategoria());
        categoriaSocio.setRequiereLegajo(dto.isRequiereLegajo());    
        
        return categoriaSocio;
    }

}
