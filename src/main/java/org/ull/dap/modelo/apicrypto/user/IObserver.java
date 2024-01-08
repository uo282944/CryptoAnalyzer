package org.ull.dap.modelo.apicrypto.user;


import org.ull.dap.vistas.MainWindow;

import java.util.List;

public interface IObserver {

    void update(String nameCrypto, double newPrice, MainWindow m);

    void addCrypto(String name);
    void deleteCrypto(String name);

    List<String> getNameCryptos();
}
