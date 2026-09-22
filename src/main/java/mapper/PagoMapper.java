/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.PagoDTO;
import repositorio.Pago;

/**
 *
 * @author Ana
 */
public class PagoMapper {
    
    public static PagoDTO toDTO(Pago pago) {
        if (pago == null) return null;
        return new PagoDTO(
                pago.getIdPago(),
                pago.getMonto(),
                pago.getFechaPago(),
                ConceptoPagoMapper.toDTO(pago.getIdConcepto()),
                MedioPagoMapper.toDTO(pago.getIdMedioPago()),
                UsuarioMapper.toDTO(pago.getIdUsuario())
        );
    }

    public static Pago toEntity(PagoDTO dto) {
        if (dto == null) return null;
        Pago pago = new Pago();
        pago.setIdPago(dto.getIdPago());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setIdConcepto(ConceptoPagoMapper.toEntity(dto.getConcepto()));
        pago.setIdMedioPago(MedioPagoMapper.toEntity(dto.getMedioPago()));
        pago.setIdUsuario(UsuarioMapper.toEntity(dto.getUsuario()));
        return pago;
    }
    
}
