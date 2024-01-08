package org.ull.dap.modelo.persistence.user;

import org.ull.dap.modelo.persistence.Gateway;

import java.util.Optional;

public interface UserGateway extends Gateway<UserGateway.UserDALDto> {
    Optional<UserDALDto> findByNick(String nick);
    Optional<UserDALDto> findByEmail(String email);


    public class UserDALDto{
        public String id;
        public String nick;
        public String email;
        public String password;
    }
}
