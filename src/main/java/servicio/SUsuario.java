/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOUsuario;
import dto.UsuarioDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.UsuarioMapper;

/**
 *
 * @author Ana
 */
@Stateless
public class SUsuario {

    @Inject
    private DAOUsuario dao;

    public void guardar(UsuarioDTO dto) {
        dao.guardar(UsuarioMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public UsuarioDTO buscarPorId(int id) {
        return UsuarioMapper.toDTO(dao.buscarPorId(id));
    }

    public List<UsuarioDTO> listarTodos() {
        return dao.listarTodos().stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }
}
