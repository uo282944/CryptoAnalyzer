package org.ull.dap.modelo.buisness.seguimiento.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService.SeguimientoBLDto;
import org.ull.dap.modelo.buisness.seguimiento.assembler.SeguimientoAssembler;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

import java.util.Optional;

public class FindSeguimientoByIdsTS implements Command<Optional<SeguimientoBLDto>> {
    private String idusuario;
    private String idcrypto;
    public FindSeguimientoByIdsTS(String idusuario, String idcrypto){
        this.idusuario = idusuario;
        this.idcrypto = idcrypto;
    }

    @Override
    public Optional<SeguimientoBLDto> execute() throws BusinessException {
        return SeguimientoAssembler.toBLDto(PersistenceFactory.forSeguimiento()
                .findSeguimientoByIds(idusuario,idcrypto));
    }
}
