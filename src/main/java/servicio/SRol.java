/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAORol;
import dto.RolDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.RolMapper;

@Stateless
public class SRol {

    @Inject
    private DAORol dao;

    public void guardar(RolDTO dto) {
        dao.guardar(RolMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public RolDTO buscarPorId(int id) {
        return RolMapper.toDTO(dao.buscarPorId(id));
    }

    public List<RolDTO> listarTodos() {
        return dao.listarTodos().stream().map(RolMapper::toDTO).collect(Collectors.toList());
    }
}
