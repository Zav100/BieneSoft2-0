/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOMedioPago;
import dto.MedioPagoDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.MedioPagoMapper;

@Stateless
public class SMedioPago {
    @Inject
    private DAOMedioPago dao;

    public void guardar(MedioPagoDTO dto) {
        dao.guardar(MedioPagoMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public MedioPagoDTO buscarPorId(int id) {
        return MedioPagoMapper.toDTO(dao.buscarPorId(id));
    }

    public List<MedioPagoDTO> listarTodos() {
        return dao.listarTodos().stream().map(MedioPagoMapper::toDTO).collect(Collectors.toList());
    }
}
