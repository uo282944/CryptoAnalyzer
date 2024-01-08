package org.ull.dap.modelo.buisness.user.assembler;

import org.ull.dap.modelo.buisness.user.UsersService.UserBLDto;
import org.ull.dap.modelo.persistence.user.UserGateway.UserDALDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserAssembler {
    public static UserBLDto toUserDto(ResultSet m) throws SQLException {
        UserBLDto dto = new UserBLDto();
        dto.id = m.getString("id");

        dto.nick = m.getString("nick");
        dto.email = m.getString("email");
        dto.password = m.getString("password");
        return dto;
    }

    public static UserDALDto toDALDto(UserBLDto arg) {

        UserDALDto result = new UserDALDto();
        result.id = arg.id;
        result.nick = arg.nick;
        result.password = arg.password;
        result.email = arg.email;
        return result;
    }

    private static UserBLDto toUserDto(UserDALDto arg) {

        UserBLDto result = new UserBLDto();
        result.id = arg.id;
        result.nick = arg.nick;
        result.password = arg.password;
        result.email = arg.email;
        return result;
    }

    public static Optional<UserBLDto> toBLDto(Optional<UserDALDto> arg){
        Optional<UserBLDto> result = arg.isEmpty() ? Optional.ofNullable(null)
                : Optional.ofNullable(toUserDto(arg.get()));
        return result;
    }
}
