package org.ull.dap.modelo.buisness.crypto.assembler;

import org.ull.dap.modelo.buisness.crypto.CryptosService.CryptoBLDto;
import org.ull.dap.modelo.persistence.crypto.CryptoGateway.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CryptoAssembler {
    public static CryptoBLDto toCryptoDto(ResultSet m) throws SQLException {
        CryptoBLDto dto = new CryptoBLDto();
        dto.id = m.getString("id");

        dto.nombre = m.getString("nombre");
        return dto;
    }

    public static CryptoDALDto toDALDto(CryptoBLDto arg) {

        CryptoDALDto result = new CryptoDALDto();
        result.id = arg.id;
        result.nombre = arg.nombre;
        return result;
    }

    private static CryptoBLDto toCryptoDto(CryptoDALDto arg) {

        CryptoBLDto result = new CryptoBLDto();
        result.id = arg.id;
        result.nombre = arg.nombre;
        return result;
    }

    public static Optional<CryptoBLDto> toBLDto(Optional<CryptoDALDto> arg){
        Optional<CryptoBLDto> result = arg.isEmpty() ? Optional.ofNullable(null)
                : Optional.ofNullable(toCryptoDto(arg.get()));
        return result;
    }

    public static List<CryptoBLDto> toCryptoBLDtoList(List<CryptoDALDto> arg) {
        List<CryptoBLDto> result = new ArrayList<CryptoBLDto>();
        for (CryptoDALDto record : arg)
            result.add(toCryptoDto(record));
        return result;
    }
}
