/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOTurno;
import dto.TurnoDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.TurnoMapper;

/**
 *
 * @author Ana
 */
@Stateless
public class STurno {

    @Inject
    private DAOTurno dao;

    public void guardar(TurnoDTO dto) {
        dao.guardar(TurnoMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public TurnoDTO buscarPorId(int id) {
        return TurnoMapper.toDTO(dao.buscarPorId(id));
    }

    public List<TurnoDTO> listarTodos() {
        return dao.listarTodos().stream().map(TurnoMapper::toDTO).collect(Collectors.toList());
    }
}
