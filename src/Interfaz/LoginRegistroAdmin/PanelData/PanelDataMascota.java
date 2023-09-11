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



import DataAccess.DAO.TablaDAOMascota;
import DataAccess.Entities.Mascota;
import Framework.NetworkException;
import Interfaz.BotonLabel.LabelCustomer;

public class PanelDataMascota extends JPanel implements ActionListener{

    public List<Mascota> getAllMascota() throws NetworkException{
        try {
            List<Mascota> lstMascota = new ArrayList<Mascota>();
            ResultSet rs = new TablaDAOMascota().getAllMascota();
            while (rs.next()) {
                Mascota p = new Mascota(rs.getInt(   "PROID"),
                                        rs.getInt(   "TIPID"),
                                        rs.getInt(   "MASID"),
                                        rs.getString("MAS_NOMBRE"),
                                        rs.getString("TIPNOMBRE"),
                                        rs.getString("PRONOMBRES"),
                                        rs.getString("PROAPELLIDOS"),
                                        rs.getString("PROTELEFONO"),
                                        rs.getString("MAS_OBSERVACION"),
                                        rs.getString("MAS_SINTOMA_ALERGIAS"));
                lstMascota.add(p);
            }
            return lstMascota;
        } catch (Exception e) {
            throw new NetworkException(e, getClass(),"getAllMascota");
        }
    }

    public PanelDataMascota() throws NetworkException{

        setGridBagLayout();
        String[] encabezado = { "Id Propietario",
                                "Id Tipo Mascota",
                                "Id Mascota",
                                "Nombre Mascota",
                                "Tipo",
                                "Nombre Propietario",
                                "Apellido Propietario",
                                "Telefono Propietario",
                                "Observación",
                                "Sintoma Alergias"};
        //11 es el tamaño de las columnas
        Object[][] data = new Object[getAllMascota().size()][11];
        int index = 0;
        for (Mascota m : getAllMascota()) {
            data[index][0] = m.getPROID();
            data[index][1] = m.getTIPID();
            data[index][2] = m.getMASID();
            data[index][3] = m.getMAS_NOMBRE();
            data[index][4] = m.getTIPNOMBRE();
            data[index][5] = m.getPRONOMBRES();
            data[index][6] = m.getPROAPELLIDOS();
            data[index][7] = m.getPROTELEFONO();
            data[index][8] = m.getMAS_OBSERVACION();
            data[index][9] = m.getMAS_SINTOMA_ALERGIAS();
            index ++;

        }
        //Creación de la tabla
        JTable table = new JTable(data, encabezado);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.ORANGE);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        //Dimensiones de la tabla
        table.setPreferredScrollableViewportSize(new Dimension(600, 150));
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
            lblTitulo = new LabelCustomer("PERFIL_Mascota", Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD ,  20));
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
        gbc.gridwidth=3;                     
        add(new JLabel("■ Sección de datos: "), gbc);  
        //Agregar tabla
        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 200;                   //| tamaño alto
        gbc.ipadx = 1000;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        //pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        // gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        // gbc.ipadx = 1;

        // gbc.gridy = 4;       gbc.gridx=0; 
        // gbc.gridwidth=1;    
    }
}
