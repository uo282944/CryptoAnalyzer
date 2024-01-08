package org.ull.dap.modelo.buisness.crypto.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService.CryptoBLDto;
import org.ull.dap.modelo.buisness.crypto.assembler.CryptoAssembler;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

import java.util.Optional;

public class FindByNombreTS implements Command<Optional<CryptoBLDto>> {
    private String nombre;
    public FindByNombreTS(String nombre){
        this.nombre = nombre;
    }

    @Override
    public Optional<CryptoBLDto> execute() throws BusinessException {
        return CryptoAssembler.toBLDto(PersistenceFactory.forCrypto()
                .findByNombre(nombre));
    }
}
