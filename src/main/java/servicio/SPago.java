/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOPago;
import dto.PagoDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.PagoMapper;

@Stateless
public class SPago {

    @Inject
    private DAOPago dao;

    public void guardar(PagoDTO dto) {
        dao.guardar(PagoMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public PagoDTO buscarPorId(int id) {
        return PagoMapper.toDTO(dao.buscarPorId(id));
    }

    public List<PagoDTO> listarTodos() {
        return dao.listarTodos().stream().map(PagoMapper::toDTO).collect(Collectors.toList());
    }
}
