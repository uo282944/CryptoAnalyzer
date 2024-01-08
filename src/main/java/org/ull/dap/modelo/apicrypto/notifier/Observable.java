package org.ull.dap.modelo.apicrypto.notifier;


import org.ull.dap.Main;
import org.ull.dap.modelo.apicrypto.user.IObserver;

public interface Observable {

    void subscribe(IObserver observer);

    void unsubscribe(IObserver observer);

    void notifyObservers();
}
