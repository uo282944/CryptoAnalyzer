package org.ull.dap.modelo.buisness.crypto.crud;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService;
import org.ull.dap.modelo.buisness.crypto.crud.commands.AddCryptoTS;
import org.ull.dap.modelo.buisness.crypto.crud.commands.FindByNombreTS;
import org.ull.dap.modelo.buisness.util.CommandExecutor;

import java.util.Optional;

public class CryptosServiceImpl implements CryptosService {

    @Override
    public CryptoBLDto addCrypto(CryptoBLDto crypto) throws BusinessException {
        return new CommandExecutor().execute(new AddCryptoTS(crypto));
    }

    @Override
    public Optional<CryptoBLDto> findCryptoByName(String nombreCrypto) throws BusinessException {
        return new CommandExecutor().execute(new FindByNombreTS(nombreCrypto));
    }
}