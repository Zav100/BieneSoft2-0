/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOSocio;
import dto.SocioDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.SocioMapper;

@Stateless
public class SSocio {

    @Inject
    private DAOSocio dao;

    public void guardar(SocioDTO dto) {
        dao.guardar(SocioMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public SocioDTO buscarPorId(int id) {
        return SocioMapper.toDTO(dao.buscarPorId(id));
    }

    public List<SocioDTO> listarTodos() {
        return dao.listarTodos().stream().map(SocioMapper::toDTO).collect(Collectors.toList());
    }
}
