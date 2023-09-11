package Interfaz.LoginRegistroAdmin.PanelData;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataAccess.DAO.TablaDAOAdmin;
import DataAccess.Entities.PerfilAdministrador;
import Framework.NetworkException;
import Interfaz.BotonLabel.LabelCustomer;

public class PanelDataAdmin extends JPanel implements ActionListener{

    public List<PerfilAdministrador> getAllAdmin() throws NetworkException{
        try {
            List<PerfilAdministrador> lstAdmin = new ArrayList<PerfilAdministrador>();
            ResultSet rs = new TablaDAOAdmin().getAllAdmin();
            while (rs.next()) {
                PerfilAdministrador pa = new PerfilAdministrador(rs.getInt("PERFIL_ADMINISTRADOR_ID"),
                                          rs.getString("CONTRASENA_ADMINISTRADOR_NOMBRE"),
                                          rs.getString("CEDULA_ADMINISTRADOR_NOMBRE"),
                                          rs.getString("USUARIO_ADMINISTRADOR_NOMBRE"),
                                          rs.getString("PERFIL_ADMINISTRADOR_ESTADO"));
                lstAdmin.add(pa);
            }
            return lstAdmin;
        } catch (Exception e) {
            throw new NetworkException(e, getClass(),"getAllAdmin");
        }
    }

    public PanelDataAdmin() throws NetworkException{

        setGridBagLayout();
        String[] encabezado = { "Id Admin",
                                "Password",
                                "Cédula",
                                "Usuario Admin",
                                "Estado Admin"};
        Object[][] data = new Object[getAllAdmin().size()][5];
        int index = 0;
        for (PerfilAdministrador pa : getAllAdmin()) {
            data[index][0] = pa.getPERFIL_ADMINISTRADOR_ID();
            data[index][1] = pa.getCONTRASENA_ADMINISTRADOR_NOMBRE();
            data[index][2] = pa.getCEDULA_ADMINISTRADOR_NOMBRE();
            data[index][3] = pa.getUSUARIO_ADMINISTRADOR_NOMBRE();
            data[index][4] = pa.getPERFIL_ADMINISTRADOR_ESTADO();
            index ++;

        }
        //Creación de la tabla
        JTable table = new JTable(data, encabezado);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.ORANGE);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(table);
        //Scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        pnlTabla.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
    }

    //Diseño
    private LabelCustomer
            lblTitulo = new LabelCustomer("PERFIL_ADMINISTRADORES", Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD ,  20));
    private JPanel 
            pnlTabla   = new JPanel();
    
    public void setGridBagLayout(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();

        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=3;                   //| celdas a unir
        add(lblTitulo, gbc);               //| agrega el control
        //Agregar texto Sección Datos
        gbc.gridy = 1;       gbc.gridx=0;   
        gbc.gridwidth=1;                     
        add(new JLabel("■ Sección de datos: "), gbc);  
        //Agregar tabla
        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 150;                   //| tamaño alto
        gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        //pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        // gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        // gbc.ipadx = 1;

        // gbc.gridy = 4;       gbc.gridx=0; 
        // gbc.gridwidth=1;    
    }
    
}
