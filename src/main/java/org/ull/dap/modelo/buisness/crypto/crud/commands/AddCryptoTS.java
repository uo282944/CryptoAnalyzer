package org.ull.dap.modelo.buisness.crypto.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService.CryptoBLDto;
import org.ull.dap.modelo.buisness.crypto.assembler.CryptoAssembler;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

import java.util.UUID;

public class AddCryptoTS implements Command<CryptoBLDto> {

    private CryptoBLDto crypto;
    public AddCryptoTS(CryptoBLDto crypto){
        this.crypto = crypto;
    }

    @Override
    public CryptoBLDto execute() throws BusinessException {
        if (PersistenceFactory.forUser().findByNick(crypto.nombre).isPresent()) {
            throw new BusinessException("La crypto que se intenta añadir ya existe");
        }

        crypto.id = UUID.randomUUID().toString();
        PersistenceFactory.forCrypto().add(CryptoAssembler.toDALDto(crypto));
        return crypto;
    }
}
