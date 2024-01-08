package org.ull.dap.modelo.buisness;

import org.ull.dap.modelo.buisness.crypto.CryptosService;
import org.ull.dap.modelo.buisness.crypto.crud.CryptosServiceImpl;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService;
import org.ull.dap.modelo.buisness.seguimiento.crud.SeguimientosServiceImpl;
import org.ull.dap.modelo.buisness.user.UsersService;
import org.ull.dap.modelo.buisness.user.crud.UsersServiceImpl;

public class BuisnessFactory {
    public static UsersService forUserService() {
        return new UsersServiceImpl();
    }
    public static CryptosService forCryptoService() {
        return new CryptosServiceImpl();
    }
    public static SeguimientosService forSeguimientoService() {
        return new SeguimientosServiceImpl();
    }
}
