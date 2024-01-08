package org.ull.dap.controladores;

import org.ull.dap.vistas.MainWindow;

public class MainController {
    protected MainWindow m;

    public MainController(){
        m = new MainWindow();
    }

    public void iniciar(){
        m.setVisible(true);
    }

}
