package org.ull.dap.modelo.persistence.seguimiento.assembler;

import org.ull.dap.modelo.persistence.seguimiento.SeguimientoGateway.SeguimientoDALDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SeguimientoAssembler {
    public static Optional<SeguimientoDALDto> toSeguimientoDALDto(ResultSet m) throws SQLException {

        if (m.next()) {
            return Optional.of(resultSetToSeguimientoDALDto(m));
        }
        else
            return Optional.ofNullable(null);
    }

    private static SeguimientoDALDto resultSetToSeguimientoDALDto(ResultSet rs) throws SQLException {

        SeguimientoDALDto value = new SeguimientoDALDto();
        value.id = rs.getString("id");

        value.id_usuario = rs.getString("id_usuario");
        value.id_crypto = rs.getString("id_crypto");
        return value;
    }
}
