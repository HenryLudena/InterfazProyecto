package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataAccess.SQLiteDataHelper;
import Framework.NetworkException;

public class TablaDAOCodigoQR extends SQLiteDataHelper{
    public ResultSet getAllQRCode() throws NetworkException{
        String query = " SELECT M.MAS_NOMBRE, P.PRONOMBRES, P.PRODIRECCION, P.PROTELEFONO"
                     + " FROM   MASCOTA M"
                     + " JOIN   PROPIETARIO P ON M.PROID = P.PROID"
                     + " WHERE  M.MAS_ESTADO = 'A'";
        try {
            Connection conn = openConnection();             
            Statement  stmt = conn.createStatement();      
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getAllCodeQR()");
        }
    }

    //Actualizar Datos (Debe colocar viejo nombre y nuevo nombre)
    public boolean updateCodigoQR(String Ruta, String MAS_NOMBRE) throws NetworkException  {
        String query = " UPDATE MASCOTA SET CODIGO_QR = ? WHERE  MAS_NOMBRE = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, Ruta);
            pstmt.setString(2, MAS_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "updateCodigoQR()");
        }
    }
}
