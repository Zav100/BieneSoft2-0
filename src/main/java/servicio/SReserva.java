/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOReserva;
import dto.ReservaDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.ReservaMapper;

@Stateless
public class SReserva {

    @Inject
    private DAOReserva dao;

    public void guardar(ReservaDTO dto) {
        dao.guardar(ReservaMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public ReservaDTO buscarPorId(int id) {
        return ReservaMapper.toDTO(dao.buscarPorId(id));
    }

    public List<ReservaDTO> listarTodos() {
        return dao.listarTodos().stream().map(ReservaMapper::toDTO).collect(Collectors.toList());
    }
    // aqui va a vivir por ejemplo calificarReserva(...) etcetc
}
