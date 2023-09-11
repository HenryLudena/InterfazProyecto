import javax.swing.JButton;
import javax.swing.JFrame;

import Framework.NetworkException;
import Interfaz.AdministradorUsuario.FrameNivelJerarquia;
import Interfaz.LoginRegistroAdmin.FrameLoginAdmin;
import Interfaz.LoginRegistroAdmin.FramePrincipalAdmin;
import Interfaz.LoginRegistroAdmin.FrameRegistroAdmin;
import Interfaz.LoginRegistroAdmin.MasterAdmin;
import Interfaz.LoginRegistroUser.FrameDatosUser;
import Interfaz.LoginRegistroUser.VerificacionLoginUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import ModuloExterno.CodigoQR;
public class App {
    
    public static void main(String[] args) throws Exception {
        // FramePrincipalAdmin Frame = new FramePrincipalAdmin();
        // Frame.MainFrame();
        FrameNivelJerarquia frameNivelJerarquia = new FrameNivelJerarquia();
        frameNivelJerarquia.FrameInicio();
        
        // System.out.println("algo");
        // FrameDatosUser frameDatosUser = new FrameDatosUser();
        // frameDatosUser.FrameDatos("Elenakdksk");
        // VerificacionLogin verificacionLogin = new VerificacionLogin();
        // boolean bool = verificacionLogin.VerificacionLoginUser("Manueldsisj");
        // System.out.println(bool);
        //Nombre de cada mascota en la base de datos, cada uno su qr
        //CodigoQR QRCode = new CodigoQR();
        //QRCode.CodigoQR("Manueldsisj", "Boby", "Manuel", "Plaza 456", "0000000000");

        // CodigoQR QRCode = new CodigoQR();        
        // QRCode.CodigoQR("AnaCh1245", "Mimi   ", "Ana      ", "Calle 234  ", "1111111111");
        // QRCode.CodigoQR("Luishhs232", "Bella  ", "Luis     ", "Avenida 567", "2222222222");
        // QRCode.CodigoQR("Elenakdksk", "Lucky  ", "Elena    ", "Plaza 890  ", "3333333333");
        // QRCode.CodigoQR("AlejandroLud29", "Max    ", "Alejandro", "Callejón 12", "4444444444");
        // QRCode.CodigoQR("Sofiadhdj", "Cotton ", "Sofía    ", "Calle 567  ", "5555555555");
        // QRCode.CodigoQR("Javierkdd9", "Lola   ", "Javier   ", "Avenida 890", "6666666666");
        // QRCode.CodigoQR("LaurahdhSj", "Lucy   ", "Laura    ", "Plaza 123  ", "7777777777");
        // QRCode.CodigoQR("Diego3jdkw", "Simba  ", "Diego    ", "Calle 456  ", "8888888888");
        // QRCode.CodigoQR("Isabel2dkdj", "Coco   ", "Isabel   ", "Avenida 123", "9999999999");
        // QRCode.CodigoQR("Manueldsisj", "Boby   ", "Manuel   ", "Plaza 456  ", "0000000000");

        //MasterAdmin masterAdmin = new MasterAdmin("Network Information", "src\\Interfaz\\Imagenes\\ImagenNetworkAdmin.png");
        //Ctrl + K + U para descomentar
    }
}
    

