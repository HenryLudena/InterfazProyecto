package BusinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DAO.TablaDAOCodigoQR;
import DataAccess.DAO.TablaDAOMascota;
import DataAccess.Entities.Mascota;
import Framework.NetworkException;

public class CodigoQRBL {
    public List<Mascota> getAllMascotas() throws NetworkException{
        try {
            TablaDAOMascota tablaDAOMascota = new TablaDAOMascota();
            List<Mascota> listaMascotas = new ArrayList<Mascota>();

            ResultSet resultSet =  tablaDAOMascota.getAllMascota();
            while(resultSet.next())    {
                Mascota mascota = new Mascota(  resultSet.getInt(   "MASID"),
                                                resultSet.getString("MAS_NOMBRE")); 
                listaMascotas.add(mascota);
            }
            return listaMascotas; 
        } 
        catch (Exception e) {
            throw new NetworkException(e, getClass(),"GetAllMascotas");
        }
    } 
    

}
