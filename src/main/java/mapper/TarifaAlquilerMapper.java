/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.TarifaAlquilerDTO;
import repositorio.TarifaAlquiler;

/**
 *
 * @author Ana
 */
public class TarifaAlquilerMapper {
    
     //convertir TarifaAlquiler (entidad) → dto
    public static TarifaAlquilerDTO toDTO(TarifaAlquiler tarifa) {
        if (tarifa == null) return null;
        
        return new TarifaAlquilerDTO(
                
                tarifa.getIdTarifa(),
                tarifa.getPrecio(),
                tarifa.getVigenteDesde(),
                tarifa.getVigenteHasta(),
                CategoriaSocioMapper.toDTO(tarifa.getIdCategoriaSocio()),
                InstalacionMapper.toDTO(tarifa.getIdInstalacion())                                   
        );
    }
    
    // convertir dto → TarifaAlquiler (entidad)
    public static TarifaAlquiler toEntity(TarifaAlquilerDTO dto) {
        if (dto == null) return null;

        TarifaAlquiler tarifa = new TarifaAlquiler();
        tarifa.setIdTarifa(dto.getIdTarifa());
        tarifa.setPrecio(dto.getPrecio());
        tarifa.setVigenteDesde(dto.getVigenteDesde());
        tarifa.setVigenteHasta(dto.getVigenteHasta());
        tarifa.setIdCategoriaSocio(CategoriaSocioMapper.toEntity(dto.getCatSocio()));
        tarifa.setIdInstalacion(InstalacionMapper.toEntity(dto.getInstalacion()));
        // reservaCollection NO se setea: es el lado mappedBy (inverso), se maneja desde Reserva
        return tarifa;
    }
}
