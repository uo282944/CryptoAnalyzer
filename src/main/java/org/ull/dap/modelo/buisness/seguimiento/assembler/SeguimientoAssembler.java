package org.ull.dap.modelo.buisness.seguimiento.assembler;

import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService.SeguimientoBLDto;
import org.ull.dap.modelo.persistence.seguimiento.SeguimientoGateway.SeguimientoDALDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SeguimientoAssembler {
    public static SeguimientoBLDto toSeguimientoDto(ResultSet m) throws SQLException {
        SeguimientoBLDto dto = new SeguimientoBLDto();
        dto.id = m.getString("id");

        dto.id_usuario = m.getString("id_usuario");
        dto.id_crypto = m.getString("id_crypto");
        return dto;
    }

    public static SeguimientoDALDto toDALDto(SeguimientoBLDto arg) {

        SeguimientoDALDto result = new SeguimientoDALDto();
        result.id = arg.id;
        result.id_usuario = arg.id_usuario;
        result.id_crypto = arg.id_crypto;
        return result;
    }

    private static SeguimientoBLDto toSeguimientoDto(SeguimientoDALDto arg) {

        SeguimientoBLDto result = new SeguimientoBLDto();
        result.id = arg.id;
        result.id_usuario = arg.id_usuario;
        result.id_crypto = arg.id_crypto;
        return result;
    }

    public static Optional<SeguimientoBLDto> toBLDto(Optional<SeguimientoDALDto> arg){
        Optional<SeguimientoBLDto> result = arg.isEmpty() ? Optional.ofNullable(null)
                : Optional.ofNullable(toSeguimientoDto(arg.get()));
        return result;
    }


}
