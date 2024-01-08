package org.ull.dap.modelo.buisness.seguimiento.crud;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService;
import org.ull.dap.modelo.buisness.seguimiento.crud.commands.AddSeguimientoTS;
import org.ull.dap.modelo.buisness.seguimiento.crud.commands.DeleteSeguimientoTS;
import org.ull.dap.modelo.buisness.seguimiento.crud.commands.FindCryptosByIdTS;
import org.ull.dap.modelo.buisness.seguimiento.crud.commands.FindSeguimientoByIdsTS;
import org.ull.dap.modelo.buisness.util.CommandExecutor;

import java.util.List;
import java.util.Optional;

public class SeguimientosServiceImpl implements SeguimientosService {


    @Override
    public SeguimientoBLDto addSeguimiento(SeguimientoBLDto seg) throws BusinessException {
        return new CommandExecutor().execute(new AddSeguimientoTS(seg));
    }

    @Override
    public void deleteSeguimiento(String idUsuario, String idCrypto) throws BusinessException {
        new CommandExecutor().execute(new DeleteSeguimientoTS(idUsuario, idCrypto));
    }

    @Override
    public List<CryptosService.CryptoBLDto> findCryptosById(String idUsuario) throws BusinessException {
        return new CommandExecutor().execute(new FindCryptosByIdTS(idUsuario));
    }

    @Override
    public Optional<SeguimientoBLDto> findSeguimientoByIds(String idUsuario, String idCrypto) throws BusinessException {
        return new CommandExecutor().execute(new FindSeguimientoByIdsTS(idUsuario, idCrypto));
    }
}