package org.ull.dap.modelo.persistence.crypto.assembler;

import org.ull.dap.modelo.persistence.crypto.CryptoGateway.CryptoDALDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CryptoAssembler {
    public static Optional<CryptoDALDto> toCryptoDALDto(ResultSet m) throws SQLException {

        if (m.next()) {
            return Optional.of(resultSetToCryptoDALDto(m));
        }
        else
            return Optional.ofNullable(null);
    }

    private static CryptoDALDto resultSetToCryptoDALDto(ResultSet rs) throws SQLException {

        CryptoDALDto value = new CryptoDALDto();
        value.id = rs.getString("id");

        value.nombre = rs.getString("nombre");
        return value;
    }

    public static List<CryptoDALDto> toCryptoList(ResultSet rs) throws SQLException {
        List<CryptoDALDto> result = new ArrayList<CryptoDALDto>();
        while (rs.next()) {
            result.add(resultSetToCryptoDALDto(rs));
        }
        return result;
    }
}
