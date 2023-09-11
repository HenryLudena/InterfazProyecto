package Interfaz.LoginRegistroAdmin.PanelData;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;




import DataAccess.DAO.TablaDAOPerfil;
import DataAccess.Entities.Perfil;
import Framework.NetworkException;
import Interfaz.BotonLabel.LabelCustomer;

public class PanelDataUser extends JPanel implements ActionListener{

    public List<Perfil> getAllPerfil() throws NetworkException{
        try {
            List<Perfil> lstPerfil = new ArrayList<Perfil>();
            ResultSet rs = new TablaDAOPerfil().getAllUser();
            while (rs.next()) {
                Perfil p = new Perfil(rs.getInt(   "PERFIL_ID"),
                                      rs.getString("CONTRASENA_PERFIL_NOMBRE"),
                                      rs.getString("CEDULA_PERFIL_NOMBRE"),
                                      rs.getString("USUARIO_PERFIL_NOMBRE"),
                                      rs.getString("PERFIL_ESTADO"));
                lstPerfil.add(p);
            }
            return lstPerfil;
        } catch (Exception e) {
            throw new NetworkException(e, getClass(),"getAllUser");
        }
    }

    public PanelDataUser() throws NetworkException{

        setGridBagLayout();
        String[] encabezado = { "Id User",
                                "Password",
                                "Cédula",
                                "Usuario User",
                                "Estado User"};
        Object[][] data = new Object[getAllPerfil().size()][5];
        int index = 0;
        for (Perfil p : getAllPerfil()) {
            data[index][0] = p.getPERFIL_ID();
            data[index][1] = p.getCONTRASENA_PERFIL_NOMBRE();
            data[index][2] = p.getCEDULA_PERFIL_NOMBRE();
            data[index][3] = p.getUSUARIO_PERFIL_NOMBRE();
            data[index][4] = p.getPERFIL_ESTADO();
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
            lblTitulo = new LabelCustomer("PERFIL_USUARIOS", Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD ,  20));
    private JPanel 
            pnlTabla   = new JPanel();
    
    public void setGridBagLayout(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();

        // PonerComponentes
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