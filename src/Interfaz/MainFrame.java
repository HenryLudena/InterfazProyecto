package Interfaz;
 
//Dimension
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JFrame
import javax.swing.*;

public class MainFrame extends JFrame {
    //Font define el tipo de letra en la interfaz "Segoe print" es el nombre, BOLD es negrita (tambien hay plain e italic, despues esta el tamaño de letra)
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    //JLabel muestra texto en la interfaz (no cambiable)
    //JTextField permite el ingreso de datos por parte del ususario
    //JFrame imprime la interfaz
    //ActionListener es el escuchador si el usuario presiona un botón llama al ActionPerformed y este último ejecuta una acción
    //setText sobrescribe a un JLabel con un nuevo texto
    JLabel lbWelcome;
    public void initialize(){
        /*************** Form Panel ***************/
        //Ingreso del texto ("Ingrese su nombre") en la interfaz
        JLabel NombreUsuario = new JLabel("Ingrese su nombre");
        NombreUsuario.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbFirstName = new JLabel("Ingrese su cédula");
        lbFirstName.setFont(mainFont);
        
        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formaDePanel = new JPanel();
        formaDePanel.setLayout(new GridLayout(4, 1, 5, 5));
        formaDePanel.setOpaque(false);
        formaDePanel.add(lbFirstName);
        formaDePanel.add(tfFirstName);
        formaDePanel.add(NombreUsuario);
        formaDePanel.add(tfLastName);

        /*************** Welcome Label ***************/
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        /*************** Buttons Label ***************/
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {
            //Los eventos que suceden al presionar el boton OK
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String firstName = tfFirstName.getText();
                String LastName = tfLastName.getText();
                lbWelcome.setText("Hello "+firstName+" "+LastName);
            }
            
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
            
        });

        JPanel buttonsPanel = new JPanel();
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
        panelPrincipal.add(lbWelcome, BorderLayout.CENTER);
        panelPrincipal.add(buttonsPanel, BorderLayout.SOUTH);  

        //Añade panel principal al JFrame
        add(panelPrincipal);

        //Nombre de la "App"
        setTitle("Welcome");
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
