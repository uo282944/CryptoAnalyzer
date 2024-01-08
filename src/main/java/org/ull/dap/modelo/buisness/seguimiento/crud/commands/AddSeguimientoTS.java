package org.ull.dap.modelo.buisness.seguimiento.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService.SeguimientoBLDto;
import org.ull.dap.modelo.buisness.seguimiento.assembler.SeguimientoAssembler;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

import java.util.UUID;

public class AddSeguimientoTS implements Command<SeguimientoBLDto> {

    private SeguimientoBLDto seg;
    public AddSeguimientoTS(SeguimientoBLDto seg){
        this.seg = seg;
    }

    @Override
    public SeguimientoBLDto execute() throws BusinessException {
        seg.id = UUID.randomUUID().toString();
        PersistenceFactory.forSeguimiento().add(SeguimientoAssembler.toDALDto(seg));
        return seg;
    }
}
