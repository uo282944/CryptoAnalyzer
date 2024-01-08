package org.ull.dap.modelo.apicrypto.user;




import java.util.List;

public interface IObserver {

    void update(String nameCrypto, double newPrice);

    void addCrypto(String name);
    void deleteCrypto(String name);

    List<String> getNameCryptos();
}
