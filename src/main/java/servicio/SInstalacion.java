/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOInstalacion;
import dto.InstalacionDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.InstalacionMapper;
import repositorio.Instalacion;

@Stateless
public class SInstalacion {
    
    //inyeccion del DAO para usar sus metodos (los del crud)
    @Inject
    private DAOInstalacion dao;
    
    
    //TRAER TODA LA LISTA DE INSTALACIONES
    public List<InstalacionDTO> listarTodos() {
        return dao.listarTodos().stream()
                .map(InstalacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    
    //BUSCAR POR ID
    public InstalacionDTO buscarPorId(int id) {
        return InstalacionMapper.toDTO(dao.buscarPorId(id));
    }

    //ALTA
    public void guardar(InstalacionDTO dto) {
        Instalacion entidad = InstalacionMapper.toEntity(dto);
        dao.guardar(entidad);
    }
    
    

    //BAJA
    public void eliminar(int id) {
        dao.eliminar(id);
    }
    
    
}
