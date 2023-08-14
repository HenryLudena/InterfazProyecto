import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import Interfaz.FrameLogin;
import Interfaz.FramePrincipal;
import Interfaz.FrameRegistro;
import ModuloExterno.CodigoQR;
public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FramePrincipal Frame = new FramePrincipal();
        //Frame.MainFrame();
        CodigoQR QRCode = new CodigoQR();
        QRCode.CodigoQR();

    }
}
    

