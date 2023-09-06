import javax.swing.JButton;
import javax.swing.JFrame;

import Interfaz.AdministradorUsuario.FrameNivelJerarquia;
import Interfaz.LoginRegistroAdmin.FrameLoginAdmin;
import Interfaz.LoginRegistroAdmin.FramePrincipalAdmin;
import Interfaz.LoginRegistroAdmin.FrameRegistroAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import ModuloExterno.CodigoQR;
public class App {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // FramePrincipalAdmin Frame = new FramePrincipalAdmin();
        // Frame.MainFrame();
        FrameNivelJerarquia frameNivelJerarquia = new FrameNivelJerarquia();
        frameNivelJerarquia.FrameInicio();

        System.out.println("algo");
        
        // CodigoQR QRCode = new CodigoQR();
        // QRCode.CodigoQR();

        //Ctrl + K + U para descomentar
    }
}
    

