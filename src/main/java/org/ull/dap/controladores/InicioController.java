package org.ull.dap.controladores;

import org.ull.dap.vistas.MainWindow;

public class InicioController {
    public void pasarLogin(MainWindow m){
        m.pasarPanel("LOGIN");
    }
    public void pasarRegister(MainWindow m){
        m.pasarPanel("REGISTER");
    }
}
