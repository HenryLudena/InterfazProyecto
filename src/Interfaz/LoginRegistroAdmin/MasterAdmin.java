package Interfaz.LoginRegistroAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Framework.NetworkException;
import Interfaz.InteractiveMenu.MenuIzquierda;
import Interfaz.LoginRegistroAdmin.PanelData.PanelDataAdmin;
import Interfaz.LoginRegistroAdmin.PanelData.PanelDataMascota;
import Interfaz.LoginRegistroAdmin.PanelData.PanelDataUser;

public class MasterAdmin extends JFrame implements ActionListener {
    //La clase que imprime el panel de menú y el panel de la tabla
    ImageIcon icono;
    MenuIzquierda  panelMenu;
    PanelDataAdmin panelAdmin;
    PanelDataUser panelUser;
    JPanel ContenidoPanel;
    PanelDataMascota panelMascota;

    public MasterAdmin(String tituloInterfaz, String icono) throws NetworkException, SQLException{
        Connection conn = conectar();
        setCustomizerForm(tituloInterfaz, icono);
        //Menu de la izquierda
        panelMenu = new MenuIzquierda();
        panelMenu.setBounds(5, 5, 150, 350);
        panelMenu.btnAdmin.addActionListener(this);
        panelMenu.btnUser.addActionListener(this);
        panelMenu.btnAnimal.addActionListener(this);

        add(panelMenu);
        //Menu de las tablas
        ContenidoPanel = new JPanel();
        ContenidoPanel.setBounds(200, 10, getWidth()-200, getHeight() - 50);
        ContenidoPanel.setBackground(Color.GREEN);
        add(ContenidoPanel);
    }

    public void setCustomizerForm(String titulo, String pathIcon) throws NetworkException, SQLException{
        icono = new ImageIcon(pathIcon);                  
        setTitle(titulo);                               
        setVisible(true);
        setLayout(null);
        setLocation(100, 50);
        setResizable(true);
        setSize(1100, 600);
        setIconImage(icono.getImage()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void showPanelAdmin() throws NetworkException, SQLException{
        panelAdmin = new PanelDataAdmin();

        ContenidoPanel.removeAll();
        ContenidoPanel.setLayout(new GridBagLayout());
        ContenidoPanel.add(panelAdmin);
        ContenidoPanel.revalidate();
        ContenidoPanel.repaint();
    }

    public void showPanelUser() throws NetworkException, SQLException{
        panelUser = new PanelDataUser();

        ContenidoPanel.removeAll();
        ContenidoPanel.setLayout(new GridBagLayout());
        ContenidoPanel.add(panelUser);
        ContenidoPanel.revalidate();
        ContenidoPanel.repaint();
    }
    
    public void showPanelMascota() throws NetworkException, SQLException{
        panelMascota = new PanelDataMascota();

        ContenidoPanel.removeAll();
        ContenidoPanel.setLayout(new GridBagLayout());
        ContenidoPanel.add(panelMascota);
        ContenidoPanel.revalidate();
        ContenidoPanel.repaint();
    }


    @Override
    
    public void actionPerformed(ActionEvent e){
        //Enseña panel admin si presiono el botón "Admin"
        if (e.getSource() == panelMenu.btnAdmin) {
            try {
                showPanelAdmin();
            } catch (NetworkException | SQLException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("Botón Presionado ->>"+e.getActionCommand());
        }
        //Enseña panel user si presiono el botón "User"
        if (e.getSource() == panelMenu.btnUser) {
            try {
                showPanelUser();
            } catch (NetworkException | SQLException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("Botón Presionado ->>"+e.getActionCommand());
        }
        //Enseña panel mascota si presiono el botón "Mascota"
        if (e.getSource() == panelMenu.btnAnimal) {
            try {
                showPanelMascota();
            } catch (NetworkException | SQLException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("Botón Presionado ->>"+e.getActionCommand());
        }
    }
    public Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:database\\PetNetwork.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }
}
