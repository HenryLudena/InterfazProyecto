package Interfaz.AdministradorUsuario;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Framework.NetworkException;
import Interfaz.LoginRegistroAdmin.FramePrincipalAdmin;
import Interfaz.LoginRegistroUser.FramePrincipalUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrameNivelJerarquia extends JFrame {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    FramePrincipalAdmin framePrincipalAdmin = new FramePrincipalAdmin();
    FramePrincipalUser framePrincipalUser = new FramePrincipalUser();

    public void FrameInicio() throws NetworkException, SQLException{
        JLabel mensaje; 
        

        /*************** Imagen del Logo ***************/
        ImageIcon logoIcon = new ImageIcon("src/Interfaz/Imagenes/logoApp.jpeg");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);

        /*************** Mensaje***************/
        mensaje = new JLabel("¡BIENVENIDO A PET NETWORK!");
        mensaje.setFont(mainFont);

       // Centrar horizontalmente el mensaje
        mensaje.setHorizontalAlignment(JLabel.CENTER);

        // Establecer el color del texto en blanco
        mensaje.setForeground(Color.WHITE);

        // Crear un contenedor vertical para centrar el mensaje verticalmente
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(Box.createVerticalStrut(100)); // Espacio en la parte superior
        verticalBox.add(mensaje);
        verticalBox.add(Box.createVerticalStrut(100)); // Espacio en la parte inferior

        

        /*************** Botón Administrador***************/
        JButton btnAdmin = new JButton("Administrador");
        btnAdmin.setFont(mainFont);
        btnAdmin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    framePrincipalAdmin.MainFrame();
                } catch (NetworkException | SQLException e1) {
                    e1.printStackTrace();
                }
                
            }
        });


        /*************** Botón Usuario***************/
        JButton btnUser = new JButton("Usuario");
        btnUser.setFont(mainFont);
        btnUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                framePrincipalUser.MainFrame();
                
            }
        });


        /*************** Panel Botones***************/
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 5, 5));
        panelBotones.setOpaque(false);
        panelBotones.add(btnUser);
        panelBotones.add(btnAdmin);


        /*************** Panel Mensaje e Imagen ***************/
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(128, 50, 0));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(mensaje, BorderLayout.NORTH);
        panelPrincipal.add(logoLabel, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);


        /*************** Panel en Interfaz ***************/
        add(panelPrincipal);


        /*************** Datos de Ventana ***************/
        //Nombre de la "App"
        setTitle("PET NETWORK");
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

    }
}
