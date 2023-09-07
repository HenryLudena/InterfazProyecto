package DataAccess.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccess.SQLiteDataHelper;
import Framework.NetworkException;

public class TablaDAOMascota extends SQLiteDataHelper {
    public ResultSet getMaxIdMascota() throws NetworkException{
        String query = " SELECT  COUNT(*) maxId"
                     + " FROM    MASCOTA"
                     + " WHERE   MAS_ESTADO ='A' ";
        try {
            Connection conn = openConnection();         // jdbc:sqlite:data\\TinderPet.db     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            return stmt.executeQuery(query);            // resultado
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getMaxIdMascota()");
        }
    }

    public ResultSet getAllMascota() throws NetworkException{
        String query = " SELECT M.MAS_NOMBRE, T.TIPNOMBRE, P.PRONOMBRES, P.PROAPELLIDOS, P.PROTELEFONO, M.MAS_OBSERVACION, M.MAS_SINTOMA_ALERGIAS"
                     + " FROM   MASCOTA M"
                     + " JOIN   TIPO T ON M.TIPID = T.TIPID"
                     + " JOIN   PROPIETARIO P ON M.PROID = P.PROID"
                     + " WHERE  M.MAS_ESTADO = 'A'";
        try {
            Connection conn = openConnection();             
            Statement  stmt = conn.createStatement();      
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getAllMascota()");
        }
    }

     public ResultSet getMascotaById(int MASID) throws NetworkException  {
        String query = " SELECT M.MAS_NOMBRE, T.TIPNOMBRE, P.PRONOMBRES, P.PROAPELLIDOS, P.PROTELEFONO, M.MAS_OBSERVACION, M.MAS_SINTOMA_ALERGIAS"
                     + " FROM   MASCOTA M"
                     + " JOIN   TIPO T ON M.TIPID = T.TIPID"
                     + " JOIN   PROPIETARIO P ON M.PROID = P.PROID"
                     + " WHERE  M.MAS_ESTADO = 'A'"
                     + " AND    M.MASID = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, MASID);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            
            throw new NetworkException(e, getClass(), "getMascotaById()");
        }
    }
    //Búsqueda por la cédula
    public ResultSet getMascotaByNombre(String CEDULA_PERFIL_NOMBRE) throws NetworkException  {
            String query = " SELECT M.MAS_NOMBRE, T.TIPNOMBRE, P.PRONOMBRES, P.PROAPELLIDOS, P.PROTELEFONO, M.MAS_OBSERVACION, M.MAS_SINTOMA_ALERGIAS"
                         + " FROM   MASCOTA M"
                         + " JOIN   TIPO T ON M.TIPID = T.TIPID"
                         + " JOIN   PROPIETARIO P ON M.PROID = P.PROID"
                         + " JOIN   PERFIL PE ON M.PERFIL_ID = PE.PERFIL_ID"
                         + " WHERE  M.MAS_ESTADO = 'A'"
                         + " AND    PE.CEDULA_PERFIL_NOMBRE = ?";
       
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, CEDULA_PERFIL_NOMBRE);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            
            throw new NetworkException(e, getClass(), "getMascotaByNombre()");
        }
    }
    //Insertar datos
    public boolean insertMascota(int PROID, int TIPID, String MAS_NOMBRE, String MAS_OBSERVACION, String MAS_SINTOMA_ALERGIAS, int PERFIL_ID) throws NetworkException  {
        String query = " INSERT INTO MASCOTA (PROID, TIPID, MAS_NOMBRE, MAS_OBSERVACION, MAS_SINTOMA_ALERGIAS, PERFIL_ID) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, PROID);
            pstmt.setInt(2, TIPID);
            pstmt.setString(3, MAS_NOMBRE);
            pstmt.setString(4, MAS_OBSERVACION);
            pstmt.setString(5, MAS_SINTOMA_ALERGIAS);
            pstmt.setInt(6, PERFIL_ID);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "insertMascota()");
        }
    }
    //Actualizar Datos (Debe colocar viejo nombre y nuevo nombre)
    public boolean updateMascota(String MAS_NOMBRE, String NOMBRE_NUEVO) throws NetworkException  {
        String query = " UPDATE MASCOTA SET NOMBRE_NUEVO = ? WHERE  MAS_NOMBRE = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, NOMBRE_NUEVO);
            pstmt.setString(2, MAS_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "updateMascota()");
        }
    }
    //Cambia Estado a X, se debe colocar el nombre
    public boolean deleteMascota(String MAS_NOMBRE ) throws NetworkException  {
        String query = " UPDATE MASCOTA SET MAS_ESTADO = ? WHERE IdSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setString(2, MAS_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "deleteMascota()");
        }
    }
}
