package Interfaz.AdministradorUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Interfaz.LoginRegistroAdmin.FramePrincipalAdmin;




public class FrameAdministrador extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    FramePrincipalAdmin framePrincipal = new FramePrincipalAdmin();
    public void FrameInicio(){
        JLabel mensaje; 
        /*************** Mensaje***************/
        mensaje = new JLabel("Ingrese como Administrador o Usuario");
        mensaje.setFont(mainFont);


        /*************** Botón Administrador***************/
        JButton btnAdmin = new JButton("Login");
        btnAdmin.setFont(mainFont);
        btnAdmin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                framePrincipal.MainFrame();
                
            }
        });


        /*************** Botón Usuario***************/
        JButton btnUser = new JButton("Register");
        btnUser.setFont(mainFont);
        btnUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                framePrincipal.MainFrame();
                
            }
        });


        /*************** Panel Botones***************/
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 5, 5));
        panelBotones.setOpaque(false);
        panelBotones.add(btnUser);
        panelBotones.add(btnAdmin);


        /*************** Panel Mensaje***************/
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(128, 0, 0));
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

    }
}

