package org.ull.dap.modelo.buisness.seguimiento;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService.CryptoBLDto;

import java.util.List;
import java.util.Optional;

public interface SeguimientosService {
    SeguimientoBLDto addSeguimiento(SeguimientoBLDto seg) throws BusinessException;
    void deleteSeguimiento(String idUsuario, String idCrypto) throws BusinessException;
    List<CryptoBLDto> findCryptosById(String idUsuario) throws BusinessException;

    Optional<SeguimientoBLDto> findSeguimientoByIds(String idUsuario, String idCrypto) throws BusinessException;

    public class SeguimientoBLDto {

        public String id;
        public String id_usuario;
        public String id_crypto;
    }
}
