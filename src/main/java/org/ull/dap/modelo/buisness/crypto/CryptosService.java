package org.ull.dap.modelo.buisness.crypto;

import org.ull.dap.modelo.BusinessException;

import java.util.Optional;

public interface CryptosService {
    CryptoBLDto addCrypto(CryptoBLDto crypto) throws BusinessException;
    Optional<CryptoBLDto> findCryptoByName(String nombreCrypto) throws BusinessException;

    public class CryptoBLDto {

        public String id;
        public String nombre;
    }
}
