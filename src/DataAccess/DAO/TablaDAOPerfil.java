package DataAccess.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccess.SQLiteDataHelper;
import Framework.NetworkException;

public class TablaDAOPerfil extends SQLiteDataHelper{

    public ResultSet getMaxIdUser() throws NetworkException{
        String query = " SELECT  COUNT(*) maxId"
                     + " FROM    PERIL"
                     + " WHERE   PERFIL_ESTADO ='A' ";
        try {
            Connection conn = openConnection();         // jdbc:sqlite:data\\TinderPet.db     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            return stmt.executeQuery(query);            // resultado
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getMaxIduSER()");
        }
    }

    public ResultSet getAllUser() throws NetworkException{
        String query = " SELECT p.PERFIL_ID, p.CONTRASENA_PERFIL_NOMBRE, p.CEDULA_PERFIL_NOMBRE, p.USUARIO_PERFIL_NOMBRE, p.PERFIL_ESTADO "
                     + " FROM PERFIL p"
                     + " WHERE PERFIL_ESTADO = 'A'";

                    //  SELECT p.CEDULA_PERFIL_NOMBRE, P.CONTRASENA_PERFIL_NOMBRE, p.USUARIO_PERFIL_NOMBRE 
                    //  FROM PERFIL p
                    //  WHERE PERFIL_ESTADO = 'A';
        try {
            Connection conn = openConnection();             
            Statement  stmt = conn.createStatement();      
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getAllUser()");
        }
    }

     public ResultSet getUserById(int PERFIL_ID) throws NetworkException  {
        String query = " SELECT p.CEDULA_PERFIL_NOMBRE, P.CONTRASENA_PERFIL_NOMBRE, p.USUARIO_PERFIL_NOMBRE "
                     + " FROM PERFIL p"
                     + " WHERE PERFIL_ESTADO = 'A'"
                     + " AND P.PERFIL_ID = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, PERFIL_ID);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            
            throw new NetworkException(e, getClass(), "getUserById()");
        }
    }
    //Búsqueda por el Usuario
    public ResultSet getUserByNombre(String USUARIO_PERFIL_NOMBRE) throws NetworkException  {
        String query = " SELECT p.CEDULA_PERFIL_NOMBRE, P.CONTRASENA_PERFIL_NOMBRE, p.USUARIO_PERFIL_NOMBRE "
                     + " FROM   PERFIL p"
                     + " WHERE PERFIL_ESTADO = 'A'"
                     + " AND    p.USUARIO_PERFIL_NOMBRE = ?";    
       
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, USUARIO_PERFIL_NOMBRE);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            
            throw new NetworkException(e, getClass(), "getUserByNombre()");
        }
    }
    //Insertar datos
    public boolean insertUser(String CEDULA_PERFIL_NOMBRE, String CONTRASENA_PERFIL_NOMBRE, String USUARIO_PERFIL_NOMBRE) throws NetworkException  {
        String query = " INSERT INTO PERFIL (CEDULA_PERFIL_NOMBRE, CONTRASENA_PERFIL_NOMBRE, USUARIO_PERFIL_NOMBRE) VALUES(?, ?, ?)";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, CEDULA_PERFIL_NOMBRE);
            pstmt.setString(2, CONTRASENA_PERFIL_NOMBRE);
            pstmt.setString(3, USUARIO_PERFIL_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "insertUser()");
        }
    }
    //Actualizar Datos (Debe colocar cedula y nuevo usuario)
    public boolean updateUser(String USUARIO_PERFIL_NOMBRE, String NOMBRE_NUEVO) throws NetworkException  {
        String query = " UPDATE PERFIL SET NOMBRE_NUEVO = ? WHERE  USUARIO_PERFIL_NOMBRE = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, NOMBRE_NUEVO);
            pstmt.setString(2, USUARIO_PERFIL_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "updateUser()");
        }
    }
        public boolean deleteUser(int PERFIL_ID) throws NetworkException{
            String query = "UPDATE PERFIL SET PERFIL_ESTADO = 'X' WHERE PERFIL_ID = ?";
            try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, PERFIL_ID);
            pstmt.executeUpdate();
            return true;
            } catch (Exception e) {
                 throw new NetworkException(e, getClass(), "deleteUser()");
            }
        }

        
    
}
