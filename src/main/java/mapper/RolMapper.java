package mapper;

import dto.RolDTO;
import repositorio.Rol;

public class RolMapper {

    public static RolDTO toDTO(Rol rol) {
        if (rol == null) return null;
        return new RolDTO(
                rol.getIdRol(),
                rol.getNombreRol()
        );
    }

    public static Rol toEntity(RolDTO dto) {
        if (dto == null) return null;
        Rol rol = new Rol();
        rol.setIdRol(dto.getIdRol());
        rol.setNombreRol(dto.getNombreRol());
        // no hay nada que setear de usuarioCollection: es mappedBy, se maneja desde Usuario
        return rol;
    }
}

