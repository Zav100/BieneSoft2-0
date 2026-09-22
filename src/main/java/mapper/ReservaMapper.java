package mapper;

import dto.ReservaDTO;
import dto.HistorialReservaDTO;
import repositorio.Reserva;
import repositorio.HistorialReserva;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {

    // convertir Reserva (entidad) → dto
    public static ReservaDTO toDTO(Reserva reserva) {
        if (reserva == null) return null;

        List<HistorialReservaDTO> historial =
                reserva.getHistorialReservaCollection() == null
                        ? new ArrayList<>()
                        : reserva.getHistorialReservaCollection().stream()
                                .map(ReservaMapper::toHistorialDTO)
                                .collect(Collectors.toList());

        return new ReservaDTO(
                reserva.getIdReserva(),
                reserva.getFechaReserva(),
                reserva.getFechaCreacion(),
                reserva.getActiva(),
                reserva.getFechaLimiteReprogramacion(),
                PagoMapper.toDTO(reserva.getIdPago()),
                SocioMapper.toDTO(reserva.getIdSocio()),
                TarifaAlquilerMapper.toDTO(reserva.getIdTarifa()),
                TurnoMapper.toDTO(reserva.getIdTurno()),
                toValoracionDTO(reserva.getValoracionReserva()),
                historial
        );
    }

    // método embebido para HistorialReserva (sin Mapper propio)
    private static HistorialReservaDTO toHistorialDTO(HistorialReserva h) {
        if (h == null) return null;
        return new HistorialReservaDTO(
                h.getIdHistorial(),
                h.getFechaAnterior(),
                h.getMotivo(),
                h.getFechaCambio(),
                TurnoMapper.toDTO(h.getIdTurnoAnterior())
        );
    }

    // método embebido para ValoracionReserva (sin Mapper propio)
    private static dto.ValoracionReservaDTO toValoracionDTO(repositorio.ValoracionReserva v) {
        if (v == null) return null;
        return new dto.ValoracionReservaDTO(
                v.getIdValoracion(),
                v.getPuntaje(),
                v.getComentario(),
                v.getFechaValoracion()
        );
    }

    // convertir dto → Reserva (entidad)
    public static Reserva toEntity(ReservaDTO dto) {
        if (dto == null) return null;

        Reserva reserva = new Reserva();
        reserva.setIdReserva(dto.getIdReserva());
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setFechaCreacion(dto.getFechaCreacion());
        reserva.setActiva(dto.isActiva());
        reserva.setFechaLimiteReprogramacion(dto.getFechaLimiteReprogramacion());
        reserva.setIdPago(PagoMapper.toEntity(dto.getPago()));
        reserva.setIdSocio(SocioMapper.toEntity(dto.getSocio()));
        reserva.setIdTarifa(TarifaAlquilerMapper.toEntity(dto.getTarifa()));
        reserva.setIdTurno(TurnoMapper.toEntity(dto.getTurno()));
        // valoracionReserva e historialReservaCollection NO se setean acá:
        // son el lado mappedBy (inverso) de la relación, se manejan aparte
        return reserva;
    }
}
