package org.ull.dap.modelo.buisness.seguimiento.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

public class DeleteSeguimientoTS implements Command<Void> {

    private String idUsuario;
    private String idCrypto;

    public DeleteSeguimientoTS (String idUsuario, String idCrypto){
        this.idUsuario = idUsuario;
        this.idCrypto = idCrypto;
    }
    @Override
    public Void execute() throws BusinessException {
        PersistenceFactory.forSeguimiento().removeSeguimiento(idUsuario,idCrypto);
        return null;
    }
}
