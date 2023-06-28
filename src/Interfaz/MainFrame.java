package Interfaz;
 
//Dimension
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrame
import javax.swing.*;

public class MainFrame extends JFrame {
    //Font define el tipo de letra en la interfaz "Segoe print" es el nombre, BOLD es negrita (tambien hay plain e italic, despues esta el tamaño de letra)
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    JTextField tfNombreUsuario, tfCedula, tfContraseña;
    //JLabel: muestra texto en la interfaz (no cambiable)
    //JTextField: permite el ingreso de datos por parte del ususario
    //¿JFrame: imprime la interfaz?
    //ActionListener: es el escuchador si el usuario presiona un botón llama al ActionPerformed y este último ejecuta una acción
    //setText: sobrescribe a un JLabel con un nuevo texto 
    JLabel ImpresionBotonEscogido, ImpresiónNombre, ImpresiónCédula, ImpresiónContraseña;
    public void initialize(){
        /*************** Panel Inicial ***************/
            //Texto "Ingrese su nombre"
        JLabel IndicacionIngresoNombre = new JLabel("Ingrese su nombre");
        IndicacionIngresoNombre.setFont(mainFont);
            //Ingreso de nombre de Usuario
        tfNombreUsuario = new JTextField();
        tfNombreUsuario.setFont(mainFont);
            //Texto "Ingrese su cédula"
        JLabel IndicacionIngresoCédula = new JLabel("Ingrese su cédula");
        IndicacionIngresoCédula.setFont(mainFont);
            //Ingreso de cédula
        tfCedula = new JTextField();
        tfCedula.setFont(mainFont);
            //Texto "Ingrese su contraseña"
        JLabel IndicacionIngresoContraseña = new JLabel("Ingrese su contraseña");
        IndicacionIngresoContraseña.setFont(mainFont);
            //Ingreso Contraseña
        tfContraseña = new JTextField();
        tfContraseña.setFont(mainFont);

        //Panel con indicaciones de que datos debe ingresar el usuario, y las entradas para ingreso de datos (panel que imprime en interfaz)
        JPanel formaDePanel = new JPanel();
        formaDePanel.setLayout(new GridLayout(6, 1, 5, 5));
        formaDePanel.setOpaque(false);
        formaDePanel.add(IndicacionIngresoNombre);
        formaDePanel.add(tfNombreUsuario);
        formaDePanel.add(IndicacionIngresoCédula);
        formaDePanel.add(tfCedula);
        formaDePanel.add(IndicacionIngresoContraseña);
        formaDePanel.add(tfContraseña);


        /*************** Impresión de Datos ***************/
        //Texto que indica un texto al usuario según el boton que escoja
        ImpresionBotonEscogido = new JLabel();
        ImpresionBotonEscogido.setFont(mainFont);
        ImpresiónNombre = new JLabel();
        ImpresiónNombre.setFont(mainFont);
        ImpresiónCédula = new JLabel();
        ImpresiónCédula.setFont(mainFont);
        ImpresiónContraseña = new JLabel();
        ImpresiónContraseña.setFont(mainFont);


        /*************** Botón que enseña Datos ***************/
        //Creación del Botón "Enseñar Datos"
        JButton btnOK = new JButton("Enseñar Datos");
        btnOK.setFont(mainFont);
            //Escuchador (llama al actionPerformed para realizar una acción)
        btnOK.addActionListener(new ActionListener() {
            //Los eventos que suceden al presionar el boton OK
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //Designar variables JTextField (Datos que ingresó el usuario) como String para poder imprimirse
                String Nombre = tfNombreUsuario.getText();
                String cedula = tfCedula.getText();
                String contraseña = tfContraseña.getText();
                //Impresión de la Etiqueta BotonEscogido
                ImpresiónNombre.setText("Nombre: "+Nombre);
                ImpresiónCédula.setText("Cédula: "+cedula);
                ImpresiónContraseña.setText("Contraseña: "+contraseña);
                ImpresionBotonEscogido.setText("Hola " + Nombre);
            }
        });


        JButton btnClear = new JButton("Limpiar");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tfNombreUsuario.setText("");
                tfCedula.setText("");
                tfContraseña.setText("");
                ImpresionBotonEscogido.setText("");
            }
            
        });


        /*************** Impresión de Datos ***************/
        JPanel datosUsuarioPanel = new JPanel();
        datosUsuarioPanel.setLayout(new GridLayout(3, 1, 5, 1));
        datosUsuarioPanel.setOpaque(false);
        datosUsuarioPanel.add(ImpresiónNombre);
        datosUsuarioPanel.add(ImpresiónCédula);
        datosUsuarioPanel.add(ImpresiónContraseña);


        JPanel buttonsPanel = new JPanel();
        //En GridLayout hgap indica el espacio (en pixeles) que separa los botones, vgap indica el espacio en vertical
        buttonsPanel.setLayout(new GridLayout(1,2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);

        
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
        

        /*************** Panel en Interfaz ***************/
        add(panelPrincipal);


        /*************** Datos de Ventana ***************/
        //Nombre de la "App"
        setTitle("Red Social de Mascotas");
        //Tamaño de la Ventana (Normal)
        setSize(500, 600);
        //Tamaño de la Ventana (Mínimo)
        setMinimumSize(new Dimension(300, 400));
        //Botón de Cierre (X)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Ventana visible 
        setVisible(true);
    }

}
