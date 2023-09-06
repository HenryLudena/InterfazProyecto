package Interfaz.LoginRegistroUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


import Funciones.Waiter;
import IngresoCorrectoDatos.VerificacionDatosIngresados;

public class FrameRegistroUser extends JFrame{
     final private Font mainFont = new Font("Arial", Font.BOLD, 18);
     JTextField tfDuenoMascota, tfNumeroCedula, tfNuevaContraseña;
     JLabel JLImpresiónNombre, JLImpresiónCedula, JLImpresiónContraseña, JLCedulaVerificada;
     private String cedula, cedulaVerificada, nuevaContrasena, nombreDueno;
     private boolean frameClosed = true;
     Waiter waiter = new Waiter();
    public void InicioRegistro(){
      VerificacionDatosIngresados verificacion = new VerificacionDatosIngresados();
        /*************** Panel Inicial ***************/
         //Texto "Ingrese un usuario"
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
        JPanel PanelPideDatos = new JPanel();
        PanelPideDatos.setLayout(new GridLayout(6, 1, 5, 5));
        PanelPideDatos.setOpaque(false);
        PanelPideDatos.add(IndicacionIngresoNombre);
        PanelPideDatos.add(tfDuenoMascota);
        PanelPideDatos.add(IndicacionIngresoCedula);
        PanelPideDatos.add(tfNumeroCedula);
        PanelPideDatos.add(IndicacionIngresoContraseña);
        PanelPideDatos.add(tfNuevaContraseña);
        
        /*************** Obtención de Datos ***************/
        nombreDueno = tfDuenoMascota.getText();
        cedula = tfNumeroCedula.getText();
        nuevaContrasena = tfNuevaContraseña.getText();
        JLCedulaVerificada = new JLabel();
        JLCedulaVerificada.setFont(mainFont);
        JLImpresiónCedula = new JLabel();
        JLImpresiónCedula.setFont(mainFont);
        JLImpresiónContraseña = new JLabel();
        JLImpresiónContraseña.setFont(mainFont);
        JLImpresiónNombre = new JLabel();
        JLImpresiónNombre.setFont(mainFont);

        /*************** Botón de Register ***************/
        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JLCedulaVerificada = verificacion.IngresoCedula(tfNumeroCedula, JLCedulaVerificada);
            cedulaVerificada = JLCedulaVerificada.getText();
            
            if(cedulaVerificada.equals("Longitud no válida")||cedulaVerificada.equals("Carácteres no válidos")){
              JLImpresiónCedula.setText("Cédula: " + cedulaVerificada); 
              tfNumeroCedula.setText("");
              cedula = "";
             }else{
            String usuario = tfDuenoMascota.getText();
             JLImpresiónCedula.setText("Su cédula se ha ingresado correctamente");
             JLImpresiónNombre.setText("Su Usuario " + usuario + " se ha ingresado correctamente");
             JLImpresiónContraseña.setText("Su contraseña se ha ingresado correctamente");
             //Aqui poner cedula y el resto
             } 
          }
        });

      /*************** Botón de limpieza ***************/
      JButton btnClear = new JButton("Limpiar");
      btnClear.setFont(mainFont);
      btnClear.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          tfNumeroCedula.setText("");
          tfNuevaContraseña.setText("");
          tfDuenoMascota.setText("");
          JLImpresiónCedula.setText("");
          JLImpresiónContraseña.setText("");
          JLImpresiónNombre.setText("");
        }
        
      });
      /*************** Panel de Botones ***************/
      JPanel PanelBotones = new JPanel();
      PanelBotones.setLayout(new GridLayout(1,2,5,5));
      PanelBotones.setOpaque(false);
      PanelBotones.add(btnRegister);
      PanelBotones.add(btnClear);


      /*************** Panel Impresión Datos ***************/
      JPanel PanelDatosIngresados = new JPanel();
      PanelDatosIngresados.setLayout(new GridLayout(3, 1, 5, 5));
      PanelDatosIngresados.setOpaque(false);
      PanelDatosIngresados.add(JLImpresiónCedula);
      PanelDatosIngresados.add(JLImpresiónNombre);
      PanelDatosIngresados.add(JLImpresiónContraseña);


      /*************** Panel Principal mostrado en la Interfaz ***************/
      JPanel PanelPrincipal = new JPanel();
      PanelPrincipal.setLayout(new BorderLayout());
      PanelPrincipal.setBackground(new Color(255, 128, 128));
      PanelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      PanelPrincipal.add(PanelPideDatos, BorderLayout.NORTH);
      PanelPrincipal.add(PanelDatosIngresados, BorderLayout.CENTER);
      PanelPrincipal.add(PanelBotones, BorderLayout.SOUTH);


      /*************** Panel en la Interfaz ***************/
      add(PanelPrincipal);
      
      setCedulaVerificada(cedulaVerificada);
      /*************** Datos de la Ventana ***************/
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
        
    //     addWindowListener(new WindowAdapter() {
    //       public void windowClosing(WindowEvent e) {
    //         frameClosed = true;
    //       }
    //  });
    //  while (!frameClosed) {
    //     try {
    //         Thread.sleep(100); // Espera un tiempo antes de verificar la bandera nuevamente
    //     } catch (InterruptedException ex) {
    //         ex.printStackTrace();
    //     }
    // }
    // addWindowListener(waiter);
    // try {
    //     waiter.waitForFrameToClose();
    // } catch (InterruptedException e) {
    //     e.printStackTrace();
    // }
     }

    

    public String getCedulaVerificada() {
        return cedulaVerificada;
    }
    public void setCedulaVerificada(String cedulaVerificada) {
        this.cedulaVerificada = cedulaVerificada;
    }
    public String getNuevaContrasena() {
        return nuevaContrasena;
    }
    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }
    public String getNombreDueno() {
        return nombreDueno;
    }
    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }
}

