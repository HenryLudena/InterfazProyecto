package ModuloExterno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import DataAccess.DAO.TablaDAOAdmin;
import DataAccess.DAO.TablaDAOCodigoQR;
import DataAccess.Entities.Mascota;
import DataAccess.Entities.PerfilAdministrador;
import Framework.NetworkException;


    public class LecturaInfoQR extends JPanel implements ActionListener{

    public List<Mascota> getAllCodigoQR() throws NetworkException{
        try {
            List<Mascota> lstQR = new ArrayList<Mascota>();
            ResultSet rs = new TablaDAOCodigoQR().getAllQRCode();
            while (rs.next()) {
                Mascota qr = new Mascota(rs.getString("MAS_NOMBRE"),
                                          rs.getString("PRONOMBRES"),
                                          rs.getString("PRODICRECCION"),
                                          rs.getString("PROTELEFONO"));
                lstQR.add(qr);
            }
            return lstQR;
        } catch (Exception e) {
            throw new NetworkException(e, getClass(),"getAllAdmin");
        }
    }

    public LecturaInfoQR() throws NetworkException{

        Object[][] data = new Object[getAllCodigoQR().size()][5];
        int index = 0;
        for (Mascota qr : getAllCodigoQR()) {
            data[index][0] = qr.getMAS_NOMBRE();
            data[index][1] = qr.getPRONOMBRES();
            data[index][2] = qr.getPRODICRECCION();
            data[index][3] = qr.getPROTELEFONO();
            index ++;

        }
}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    }