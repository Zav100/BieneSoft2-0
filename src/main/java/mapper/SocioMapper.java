/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.SocioDTO;
import repositorio.Socio;

/**
 *
 * @author Ana
 */
public class SocioMapper {
    
    
    // convertir CarnetDigital (entidad) → dto
    public static SocioDTO toDTO(Socio socio) {
        if (socio == null) {
            return null;
        }

        return new SocioDTO(
                socio.getIdSocio(),
                socio.getDni(),
                socio.getFechaNacimiento(),
                socio.getTelefono(),
                socio.getFotoPerfilUrl(),
                socio.getLegajo(),
                socio.getBajaLogica(),
                
                CategoriaSocioMapper.toDTO(socio.getIdCategoriaSocio()),
                UsuarioMapper.toDTO(socio.getIdUsuario())
                
        );
    }

    // convertir dto → CarnetDigital (entidad)
    public static Socio toEntity(SocioDTO dto) {
        if (dto == null) {
            return null;
        }
        Socio socio = new Socio();

        socio.setIdSocio(dto.getIdSocio());
        socio.setDni(dto.getDni());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setTelefono(dto.getTelefono());
        socio.setFotoPerfilUrl(dto.getFotoPerfilUrl());
        socio.setLegajo(dto.getLegajo());
        socio.setBajaLogica(dto.isBajaLogica());
        socio.setIdCategoriaSocio(CategoriaSocioMapper.toEntity(dto.getIdCategoriaSocio()));
        socio.setIdUsuario(UsuarioMapper.toEntity(dto.getIdUsuario()));

        return socio;
    }
}
