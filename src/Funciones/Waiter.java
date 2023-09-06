package Funciones;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.CountDownLatch;



public class Waiter  implements WindowListener{
    private CountDownLatch cerrojo;
    //Cuando se llama al metodo windowClosing, este decrementa el valor de cerrojo en 1, 
    //al decremnetar el valor del cerrojo en 0 llama a waitForFrameToClose() y continua el programa
    public Waiter() {
        // Inicializa el CountDownLatch con un valor inicial de 1
        cerrojo = new CountDownLatch(1);
    }

    public void waitForFrameToClose() throws InterruptedException {
        // Espera hasta que el CountDownLatch alcance 0
        cerrojo.await();
    }
    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Llama al método countdown cuando la ventana se cierre
        cerrojo.countDown();
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        cerrojo.countDown();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    
        
    }
    
}
