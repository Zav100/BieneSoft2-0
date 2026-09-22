/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.TurnoDTO;
import repositorio.Turno;

/**
 *
 * @author Ana
 */
public class TurnoMapper {
    
     //convertir Turno (entidad) → dto
    public static TurnoDTO toDTO(Turno turno) {
        if (turno == null) return null;
        
        return new TurnoDTO(              
                turno.getIdTurno(),
                turno.getHoraInicio(),
                turno.getHoraFin(),
                
                InstalacionMapper.toDTO(turno.getIdInstalacion())                                  
        );
    }
    
    
     // convertir dto → Turno (entidad)
    public static Turno toEntity(TurnoDTO dto) {
        if (dto == null) return null;

        Turno turno = new Turno();
        
        turno.setIdTurno(dto.getIdTurno());
        turno.setHoraInicio(dto.getHoraInicio());
        turno.setHoraFin(dto.getHoraFin());
 
        // reservaCollection NO se setea: es el lado mappedBy (inverso), se maneja desde Reserva
        return turno;
    }
}
