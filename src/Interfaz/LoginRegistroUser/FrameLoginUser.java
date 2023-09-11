package Interfaz.LoginRegistroUser;
 
//Dimension, Font
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrame
import javax.swing.*;

import Framework.NetworkException;
import IngresoCorrectoDatos.VerificacionDatosIngresados;

public class FrameLoginUser extends JFrame {
    //Font define el tipo de letra en la interfaz " Arial" es el nombre, BOLD es negrita (tambien hay plain e italic, despues esta el tamaño de letra)
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    private boolean verificacionLoginUser;
    JTextField tfCedula, tfContrasena, tfUsuario;
    //JLabel: muestra texto en la interfaz (Ej: "Ingrese su cédula") (no cambiable)
    //JTextField: permite el ingreso de datos por parte del ususario
    //JFrame: Es la ventana a mostrar
    //ActionListener: es el escuchador si el usuario presiona un botón llama al ActionPerformed y este último ejecuta una acción
    //setText: sobrescribe a un JLabel con un nuevo texto 
    //setOpaque: Imprime en la interfaz un fondo transparente si es falso, caso contrario no se distingue el color del background
    //JPanel: Los paneles contienen los datos de botones, JLabel y JTextField. En este caso se imprimirá únicamente el panel principal que es una agrupación de todos los paneles
    //Para ActionListener se debe añadir unimplemented methods mediante el foco cuando se coloca "new ActionListener"
    JLabel ImpresionCedula, ImpresionContrasena, JLCedulaVerificada, JLUsuarioVerificado;
    VerificacionLoginUser verificacionLogin = new VerificacionLoginUser();
    FrameDatosUser frameDatosUser = new FrameDatosUser();

    public void InicioLogin(){
        //Inicialización de variable verificación para llamar a la clase VerificacionDatosIngresados
        VerificacionDatosIngresados verificacion = new VerificacionDatosIngresados();
        /*************** Panel Inicial ***************/
            //Texto "Ingrese su cédula"
        JLabel IndicacionIngresoCédula = new JLabel("Ingrese su cédula");
        IndicacionIngresoCédula.setFont(mainFont);
            //Ingreso de cédula
            tfCedula = new JTextField();
            tfCedula.setFont(mainFont);
            //Texto "Ingrese su contraseña"
        JLabel IndicacionIngresoContrasena = new JLabel("Ingrese su contraseña");
        IndicacionIngresoContrasena.setFont(mainFont);
            //Ingreso Contraseña
        tfContrasena = new JTextField();
        tfContrasena.setFont(mainFont);
            //Texto "Ingrese su usuario"
        JLabel IndicacionIngresoUsuario = new JLabel("Ingrese su nombre de Usuario");
        IndicacionIngresoUsuario.setFont(mainFont);
            //Ingreso usuario
        tfUsuario = new JTextField();
        tfUsuario.setFont(mainFont);

         // Crear un JLabel para mostrar la imagen
        ImageIcon loroIcon = new ImageIcon("src/Interfaz/Imagenes/loro.jpg");
        JLabel imagenLabel = new JLabel(loroIcon);
        
       

        //Panel con indicaciones de que datos debe ingresar el usuario, y las entradas para ingreso de datos (panel que imprime en interfaz)
        JPanel formaDePanel = new JPanel();
        formaDePanel.setLayout(new GridLayout(6, 1, 5, 5));
        formaDePanel.setOpaque(false);
        formaDePanel.add(IndicacionIngresoCédula);
        formaDePanel.add(tfCedula);
        formaDePanel.add(IndicacionIngresoContrasena);
        formaDePanel.add(tfContrasena);
        formaDePanel.add(IndicacionIngresoUsuario);
        formaDePanel.add(tfUsuario);
        


        /*************** Impresión de Datos ***************/
        //Texto que indica un texto al usuario según el boton que escoja, no impresión
        ImpresionCedula = new JLabel();
        ImpresionCedula.setFont(mainFont);
        ImpresionContrasena = new JLabel();
        ImpresionContrasena.setFont(mainFont);
        JLCedulaVerificada = new JLabel();
        JLCedulaVerificada.setFont(mainFont);
        JLUsuarioVerificado = new JLabel();
        JLUsuarioVerificado.setFont(mainFont);


        /*************** Botón que enseña Datos ***************/
        //Creación del Botón "Enseñar Datos"
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
            //Escuchador (llama al actionPerformed para realizar una acción)
        btnLogin.addActionListener(new ActionListener() {
            //Los eventos que suceden al presionar el boton OK
            @Override
            public void actionPerformed(ActionEvent e) {
                //Designar variables JTextField (Datos que ingresó el usuario) como String para poder imprimirse
                JLCedulaVerificada = verificacion.IngresoCedula(tfCedula, JLCedulaVerificada);
                //Verificación si cédula es la correcta
                String cedulaVerificada = JLCedulaVerificada.getText();
                
                //Según si la cédula es correcta o no enseñar mensaje
                if (cedulaVerificada.equals("Longitud no válida")||cedulaVerificada.equals("Carácteres no válidos")) {
                    ImpresionCedula.setText("Cédula: " + cedulaVerificada);
                    
                    //Vaciar la casilla donde el usuario ingresa la cédula porque es errónea
                    tfCedula.setText("");
                }else{
                    //Definición de variable string para colocar setText en "ImpresiónCédula"
                String cedula = JLCedulaVerificada.getText();
                //Impresión de los datos del Usuario
                // ImpresionCedula.setText("Cédula: "+cedula);
                String UsuarioVerificar = tfUsuario.getText();
                String ContrasenaVerificar = tfContrasena.getText();
                    try {
                    verificacionLoginUser = verificacionLogin.VerificacionLoginUser(UsuarioVerificar, ContrasenaVerificar );
                } catch (NetworkException e1) {
                    e1.printStackTrace();
                }
                if (verificacionLoginUser == true){
                        dispose();
                        frameDatosUser.FrameDatos(UsuarioVerificar);
                }else
                        JLUsuarioVerificado.setText("Usuario no válido");
            }
            }
        });

        
        /*************** Botón que limpia la Interfaz ***************/
        JButton btnClear = new JButton("Limpiar");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Limpieza de la interfaz de los JLabel y JTextField
                tfCedula.setText("");
                tfContrasena.setText("");
                ImpresionCedula.setText("");
                ImpresionContrasena.setText("");
                tfUsuario.setText("");
                JLUsuarioVerificado.setText("");
            }
            
        });


        /*************** Panel de Impresión de Datos ***************/
        JPanel datosUsuarioPanel = new JPanel();
        datosUsuarioPanel.setLayout(new GridLayout(2, 1, 5, 1));
        datosUsuarioPanel.setOpaque(false);
        datosUsuarioPanel.add(ImpresionCedula);
        datosUsuarioPanel.add(ImpresionContrasena);
        datosUsuarioPanel.add(JLUsuarioVerificado);


        /*************** Panel de Botones ***************/
        JPanel buttonsPanel = new JPanel();
        //En GridLayout hgap indica el espacio horizontal(en pixeles) que separa los botones, vgap indica el espacio en vertical
        buttonsPanel.setLayout(new GridLayout(1,2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnClear);



        /*************** Imagen del Logo ***************/
        ImageIcon logoIcon = new ImageIcon("src/Interfaz/Imagenes/loro.jpg");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);


        /*************** Panel Principal mostrado en Interfaz ***************/
        //Variable para importar del package de JPanel
        JPanel panelPrincipal = new JPanel();
        //Se establece los puntos cardinales de los botones
        panelPrincipal.setLayout(new BorderLayout());
        //SetBackground coloca el color del fondo de pantalla de la ventana
        panelPrincipal.setBackground(new Color(128, 128, 255));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(formaDePanel, BorderLayout.NORTH);
        panelPrincipal.add(datosUsuarioPanel, BorderLayout.CENTER);
        panelPrincipal.add(buttonsPanel, BorderLayout.SOUTH);  
        panelPrincipal.add(logoLabel, BorderLayout.CENTER);

        /*************** Panel en Interfaz ***************/
        add(panelPrincipal);


        /*************** Datos de Ventana ***************/
        //Nombre de la "App"
        setTitle("LOGIN PET NETWORK");
        //Tamaño de la Ventana (Normal)
        setSize(500, 600);
        //Tamaño de la Ventana (Mínimo)
        setMinimumSize(new Dimension(300, 400));
        //Botón de Cierre (X)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Centrar la ventana
        setLocationRelativeTo(null);
        //Ventana visible 
        setVisible(true);
    }
    

}
