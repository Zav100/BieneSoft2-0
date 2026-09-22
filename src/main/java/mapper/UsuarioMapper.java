/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.UsuarioDTO;
import repositorio.Usuario;

/**
 *
 * @author Ana
 */
public class UsuarioMapper {
    
    
     //convertir Usuario (entidad) → dto
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        
        return new UsuarioDTO(  
                
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getPasswordHash(),
                usuario.getFechaAlta(),
                usuario.getActivo(),
                
                SocioMapper.toDTO(usuario.getSocio()),
                RolMapper.toDTO(usuario.getIdRol())                                
        );
    }
    
         // convertir dto → Turno (entidad)
    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());
        usuario.setPasswordHash(dto.getPasswordHash());
        usuario.setFechaAlta(dto.getFechaAlta());
        usuario.setActivo(dto.isActivo());
             

 
        // reservaCollection NO se setea: es el lado mappedBy (inverso), se maneja desde Reserva
        return usuario;
    }
}
