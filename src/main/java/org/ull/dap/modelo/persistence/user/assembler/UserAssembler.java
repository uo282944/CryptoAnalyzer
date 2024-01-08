package org.ull.dap.modelo.persistence.user.assembler;

import org.ull.dap.modelo.persistence.user.UserGateway.UserDALDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserAssembler {
    public static Optional<UserDALDto> toUserDALDto(ResultSet m) throws SQLException {

        if (m.next()) {
            return Optional.of(resultSetToUserDALDto(m));
        }
        else
            return Optional.ofNullable(null);
    }

    private static UserDALDto resultSetToUserDALDto(ResultSet rs) throws SQLException {

        UserDALDto value = new UserDALDto();
        value.id = rs.getString("id").substring(0, rs.getString("id").length() - 6);

        value.nick = rs.getString("nick");
        value.password = rs.getString("password");
        value.email = rs.getString("email");
        return value;
    }
}
