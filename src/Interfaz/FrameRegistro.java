package Interfaz;

import java.awt.*;

import javax.swing.*;

public class FrameRegistro extends JFrame{
     final private Font mainFont = new Font("Arial", Font.BOLD, 18);
     JTextField tfDuenoMascota, tfNumeroCedula, tfNuevaContraseña;
     JLabel JLPedirNombre, JLPedirCedula, JLPedirContraseña;
     public void InicioRegistro(){
        /*************** Panel Inicial ***************/
         //Texto "Ingrese su cédula"
        JLabel IndicacionIngresoNombre = new JLabel("Cree un usuario");
        IndicacionIngresoNombre.setFont(mainFont);
        //Ingreso Nombre de Usuario
        tfDuenoMascota = new JTextField();
        tfDuenoMascota.setFont(mainFont);
        //Texto "Ingrese su número de cédula"
        JLabel IndicacionIngresoCedula = new JLabel("Ingrese su número cédula");
        IndicacionIngresoCedula.setFont(mainFont);
        //Ingreso de Cédula 
        tfNumeroCedula = new JTextField();
        tfNumeroCedula.setFont(mainFont);
        //Texto "Cree una contraseña"
        JLabel IndicacionIngresoContraseña = new JLabel("Cree una contraseña");
        IndicacionIngresoContraseña.setFont(mainFont);
        //Creación de contraseña
        tfNuevaContraseña = new JTextField();
        tfNuevaContraseña.setFont(mainFont);

        //Creación de panel para interfaz de usuario que incluye los JTextField y JLabel anteriores
        JPanel panelPideDatos = new JPanel();
        panelPideDatos.setLayout(new GridLayout(6, 1, 5, 5));
        panelPideDatos.setOpaque(false);
        panelPideDatos.add(IndicacionIngresoNombre);
        panelPideDatos.add(tfDuenoMascota);
        panelPideDatos.add(IndicacionIngresoCedula);
        panelPideDatos.add(tfNumeroCedula);
        panelPideDatos.add(IndicacionIngresoContraseña);
        panelPideDatos.add(tfNuevaContraseña);
        


        //Nombre de la "App"
        setTitle("Registro Red Social de Mascotas");
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
