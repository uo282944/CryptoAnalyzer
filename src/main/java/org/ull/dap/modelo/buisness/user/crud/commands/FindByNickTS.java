package org.ull.dap.modelo.buisness.user.crud.commands;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.user.UsersService.UserBLDto;
import org.ull.dap.modelo.buisness.user.assembler.UserAssembler;
import org.ull.dap.modelo.buisness.util.Command;
import org.ull.dap.modelo.persistence.PersistenceFactory;

import java.util.Optional;

public class FindByNickTS implements Command<Optional<UserBLDto>> {
    private String nick;
    public FindByNickTS(String nick){
        this.nick = nick;
    }

    @Override
    public Optional<UserBLDto> execute() throws BusinessException {
        return UserAssembler.toBLDto(PersistenceFactory.forUser()
                .findByNick(nick));
    }
}
