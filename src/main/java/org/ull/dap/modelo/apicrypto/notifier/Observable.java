package org.ull.dap.modelo.apicrypto.notifier;


import org.ull.dap.modelo.apicrypto.user.IObserver;
import org.ull.dap.vistas.MainWindow;

public interface Observable {

    void subscribe(IObserver observer);

    void unsubscribe(IObserver observer);

    void notifyObservers(MainWindow m);
}
