package Interfaz.LoginRegistroAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import Funciones.Waiter;
import Interfaz.AdministradorUsuario.FrameNivelJerarquia;

import javax.swing.*;

import Framework.NetworkException;


public class FramePrincipalAdmin extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    Waiter waiter = new Waiter();
    private boolean frameClosed = true;


    public void MainFrame() throws NetworkException, SQLException{
        //FrameRegistro FrameRegistro = new FrameRegistro();
        FrameLoginAdmin FrameLoginAdmin = new FrameLoginAdmin();
        FrameNivelJerarquia frameNivelJerarquia = new FrameNivelJerarquia();
        JLabel mensaje; 
        
        
        /*************** Imagen de bienvenida ***************/
        ImageIcon logoIcon = new ImageIcon("src/Interfaz/Imagenes/perro_admin.jpg");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        
        /*************** Mensaje y Gif***************/
        mensaje = new JLabel("¡ESTAMOS FELICES DE VERTE DE NUEVO ADMINISTRADOR!");
        mensaje.setFont(mainFont);

        // Centrar horizontalmente el mensaje
        mensaje.setHorizontalAlignment(JLabel.CENTER);


        // Crear un contenedor vertical para centrar el mensaje verticalmente
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(Box.createVerticalStrut(100)); // Espacio en la parte superior
        verticalBox.add(mensaje);
        verticalBox.add(Box.createVerticalStrut(100)); // Espacio en la parte inferior


        /*************** Botón Volver***************/
        JButton btnRegister = new JButton("Volver");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    frameNivelJerarquia.FrameInicio();
                } catch (NetworkException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        });


        /*************** Botón Login***************/
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    FrameLoginAdmin.InicioLogin();
                } catch (NetworkException | SQLException e1) {
                    e1.printStackTrace();
                }
                
            }
        });


        /*************** Panel Botones***************/
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 5, 5));
        panelBotones.setOpaque(false);
        panelBotones.add(btnLogin);
        panelBotones.add(btnRegister);


        /*************** Panel Mensaje***************/
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(128, 255, 128));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        panelPrincipal.add(logoLabel, BorderLayout.CENTER);

        logoLabel.setVisible(true);

        /*************** Panel en Interfaz ***************/
        add(panelPrincipal);


        /*************** Datos de Ventana ***************/
        //Nombre de la "App"
        setTitle("LOGIN O REGISTRO PET NETWORK");
        //Tamaño de la Ventana (Normal)
        setSize(500, 400);
        //Tamaño de la Ventana (Mínimo)
        setMinimumSize(new Dimension(250, 300));
        //Botón de Cierre (X)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Centrar la ventana
        setLocationRelativeTo(null);
        //Ventana visible 
        setVisible(true);


        //Colocación del waiter
    //     addWindowListener(new WindowAdapter() {
    //         public void windowClosing(WindowEvent e) {
    //           frameClosed = true;
    //         }
    //    });
    //    while (frameClosed) {
    //       try {
    //           Thread.sleep(100); // Espera un tiempo antes de verificar la bandera nuevamente
    //       } catch (InterruptedException ex) {
    //           ex.printStackTrace();
    //       }
    //   }
    }
}
