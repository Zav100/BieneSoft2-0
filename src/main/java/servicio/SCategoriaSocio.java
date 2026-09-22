/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOCategoriaSocio;
import dto.CategoriaSocioDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.CategoriaSocioMapper;
import repositorio.CategoriaSocio;

@Stateless
public class SCategoriaSocio {
    
    // inyeccion del DAO
    @Inject
    private DAOCategoriaSocio dao;

    // ---------------- CRUD (hacia afuera solo maneja DTO) ----------------

    // alta / modificación
    public void guardar(CategoriaSocioDTO dto) {
        CategoriaSocio categoriaSocio = CategoriaSocioMapper.toEntity(dto);
        dao.guardar(categoriaSocio);
    }

    // baja
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    // busqueda por id
    public CategoriaSocioDTO buscarPorId(int id) {
        return CategoriaSocioMapper.toDTO(dao.buscarPorId(id));
    }

    // listar todas
    public List<CategoriaSocioDTO> listarTodos() {
        return dao.listarTodos().stream()
                .map(CategoriaSocioMapper::toDTO)
                .collect(Collectors.toList());
    }

    // REGLAS DE NEGOCIO / CONSULTAS PERSONALIZADAS - ABAJO
}
