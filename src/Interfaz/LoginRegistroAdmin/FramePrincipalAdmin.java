package Interfaz.LoginRegistroAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Funciones.Waiter;
import javax.swing.*;


public class FramePrincipalAdmin extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    Waiter waiter = new Waiter();
    private boolean frameClosed = true;
    public void MainFrame(){
        //FrameRegistro FrameRegistro = new FrameRegistro();
        FrameLoginAdmin FrameLoginAdmin = new FrameLoginAdmin();
        FrameRegistroAdmin FrameRegistroAdmin = new FrameRegistroAdmin();
        JLabel mensaje; 
        
        /*************** Mensaje***************/
        mensaje = new JLabel("Elija si desea registrarse o loguearse");
        mensaje.setFont(mainFont);


        /*************** Botón Register***************/
        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameRegistroAdmin.InicioRegistro();
                
            }
        });


        /*************** Botón Login***************/
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameLoginAdmin.InicioLogin();
                
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


        /*************** Panel en Interfaz ***************/
        add(panelPrincipal);


        /*************** Datos de Ventana ***************/
        //Nombre de la "App"
        setTitle("Login o Registro Red Social de Mascotas");
        //Tamaño de la Ventana (Normal)
        setSize(500, 400);
        //Tamaño de la Ventana (Mínimo)
        setMinimumSize(new Dimension(250, 300));
        //Botón de Cierre (X)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
