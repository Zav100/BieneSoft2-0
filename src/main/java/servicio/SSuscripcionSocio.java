/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.DAOSuscripcionSocio;
import dto.SuscripcionDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import mapper.SuscripcionSocioMapper;
import repositorio.SuscripcionSocio;

/**
 *
 * @author Ana
 */
@Stateless
public class SSuscripcionSocio {

    @Inject
    private DAOSuscripcionSocio dao;

    public void guardar(SuscripcionDTO dto) {
        dao.guardar(SuscripcionSocioMapper.toEntity(dto));
    }

    public void eliminar(int id) {
        dao.eliminar(id);
    }

    public SuscripcionDTO buscarPorId(int id) {
        return SuscripcionSocioMapper.toDTO(dao.buscarPorId(id));
    }

    public List<SuscripcionDTO> listarTodos() {
        return dao.listarTodos().stream().map(SuscripcionSocioMapper::toDTO).collect(Collectors.toList());
    }
    
    //METODOS AGREGADOS
    public boolean esSocioActivo(int idSocio) {
        SuscripcionSocio ultima = dao.buscarUltimaPorSocio(idSocio); // vas a necesitar esta consulta en DAOSuscripcionSocio
        if (ultima == null) {
            return false;
        }
        return !ultima.getFechaVencimiento().before(new Date()); // hoy <= vencimiento
    }
}
