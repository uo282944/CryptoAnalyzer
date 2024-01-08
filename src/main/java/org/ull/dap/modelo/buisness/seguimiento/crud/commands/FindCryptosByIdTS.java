package org.ull.dap.modelo.buisness.seguimiento.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService.CryptoBLDto;
import org.ull.dap.modelo.buisness.crypto.assembler.CryptoAssembler;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

import java.util.List;

public class FindCryptosByIdTS implements Command<List<CryptoBLDto>> {
    private String id;
    public FindCryptosByIdTS(String id){
        this.id = id;
    }

    @Override
    public List<CryptoBLDto> execute() throws BusinessException {
        return CryptoAssembler.toCryptoBLDtoList(PersistenceFactory.forSeguimiento()
                .findCryptosById(id));
    }
}
