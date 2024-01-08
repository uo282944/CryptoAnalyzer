package org.ull.dap.modelo.persistence;

import org.ull.dap.modelo.persistence.crypto.CryptoGateway;
import org.ull.dap.modelo.persistence.crypto.impl.CryptoGatewayImpl;
import org.ull.dap.modelo.persistence.seguimiento.SeguimientoGateway;
import org.ull.dap.modelo.persistence.seguimiento.impl.SeguimientoGatewayImpl;
import org.ull.dap.modelo.persistence.user.UserGateway;
import org.ull.dap.modelo.persistence.user.impl.UserGatewayImpl;

public class PersistenceFactory {


	public static UserGateway forUser() {
		return new UserGatewayImpl();
	}

	public static CryptoGateway forCrypto() {
		return new CryptoGatewayImpl();
	}

	public static SeguimientoGateway forSeguimiento() {
		return new SeguimientoGatewayImpl();
	}
}

