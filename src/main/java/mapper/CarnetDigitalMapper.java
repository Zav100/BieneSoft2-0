package mapper;

import dto.CarnetDigitalDTO;
import repositorio.CarnetDigital;

public class CarnetDigitalMapper {

    // convertir CarnetDigital (entidad) → dto
    public static CarnetDigitalDTO toDTO(CarnetDigital carnetDigital) {
        if (carnetDigital == null) {
            return null;
        }

        return new CarnetDigitalDTO(
                carnetDigital.getIdCarnet(),
                carnetDigital.getCodigoQrUrl(),
                carnetDigital.getFechaEmision(),
                carnetDigital.getEstado(),
                SocioMapper.toDTO(carnetDigital.getIdSocio()) // reutiliza el mapper de Socio
        );
    }

    // convertir dto → CarnetDigital (entidad)
    public static CarnetDigital toEntity(CarnetDigitalDTO dto) {
        if (dto == null) {
            return null;
        }
        CarnetDigital carnetDigital = new CarnetDigital();

        carnetDigital.setIdCarnet(dto.getIdCarnetDigital());
        carnetDigital.setCodigoQrUrl(dto.getCodigoQrUrl());
        carnetDigital.setFechaEmision(dto.getFechaEmision());
        carnetDigital.setEstado(dto.getEstado());
        carnetDigital.setIdSocio(SocioMapper.toEntity(dto.getSocio()));

        return carnetDigital;
    }
}
