/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOConceptoPago;
import dto.ConceptoPagoDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import mapper.ConceptoPagoMapper;

@Stateless
public class SConceptoPago {

    @Inject
    private DAOConceptoPago dao;

    public void guardar(ConceptoPagoDTO dto) {
        dao.guardar(ConceptoPagoMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public ConceptoPagoDTO buscarPorId(int id) {
        return ConceptoPagoMapper.toDTO(dao.buscarPorId(id));
    }

    public List<ConceptoPagoDTO> listarTodos() {
        return dao.listarTodos().stream().map(ConceptoPagoMapper::toDTO).collect(Collectors.toList());
    }
}
