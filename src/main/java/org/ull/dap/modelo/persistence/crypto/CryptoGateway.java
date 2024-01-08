package org.ull.dap.modelo.persistence.crypto;

import org.ull.dap.modelo.persistence.Gateway;

import java.util.Optional;

public interface CryptoGateway extends Gateway<CryptoGateway.CryptoDALDto> {
    Optional<CryptoDALDto> findByNombre(String nombre);


    public class CryptoDALDto{
        public String id;
        public String nombre;
    }
}
