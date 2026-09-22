/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOTarifaAlquiler;
import dto.TarifaAlquilerDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.TarifaAlquilerMapper;

/**
 *
 * @author Ana
 */
@Stateless
public class STarifaAlquiler {

    @Inject
    private DAOTarifaAlquiler dao;

    public void guardar(TarifaAlquilerDTO dto) {
        dao.guardar(TarifaAlquilerMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public TarifaAlquilerDTO buscarPorId(int id) {
        return TarifaAlquilerMapper.toDTO(dao.buscarPorId(id));
    }

    public List<TarifaAlquilerDTO> listarTodos() {
        return dao.listarTodos().stream().map(TarifaAlquilerMapper::toDTO).collect(Collectors.toList());
    }
}
