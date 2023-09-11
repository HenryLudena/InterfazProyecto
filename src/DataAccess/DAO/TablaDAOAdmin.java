package DataAccess.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccess.SQLiteDataHelper;
import Framework.NetworkException;

public class TablaDAOAdmin extends SQLiteDataHelper{

    public ResultSet getMaxIdAdmin() throws NetworkException{
        String query = " SELECT  COUNT(*) maxId"
                     + " FROM    PERFIL_ADMINISTRADOR"
                     + " WHERE   PERFIL_ADMINISTRADOR_ESTADO ='A' ";
        try {
            Connection conn = openConnection();         // jdbc:sqlite:data\\TinderPet.db     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            return stmt.executeQuery(query);            // resultado
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getMaxIdAdmin()");
        }
    }

    public ResultSet getAllAdmin() throws NetworkException{
        String query = " SELECT pa.PERFIL_ADMINISTRADOR_ID, pa.CEDULA_ADMINISTRADOR_NOMBRE, pa.CONTRASENA_ADMINISTRADOR_NOMBRE, pa.USUARIO_ADMINISTRADOR_NOMBRE, pa.PERFIL_ADMINISTRADOR_ESTADO" 
                     + " FROM PERFIL_ADMINISTRADOR pa"
                     + " WHERE PERFIL_ADMINISTRADOR_ESTADO = 'A'";

                    //  SELECT pa.CEDULA_ADMINISTRADOR_NOMBRE, pa.CONTRASENA_ADMINISTRADOR_NOMBRE, pa.USUARIO_ADMINISTRADOR_NOMBRE 
                    //  FROM PERFIL_ADMINISTRADOR pa
                    //  WHERE PERFIL_ADMINISTRADOR_ESTADO = 'A';
        try {
            Connection conn = openConnection();             
            Statement  stmt = conn.createStatement();      
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "getAllAdmin()");
        }
    }

     public ResultSet getAdminById(int PERFIL_ADMINISTRADOR_ID) throws NetworkException  {
        String query = " SELECT pa.CEDULA_ADMINISTRADOR_NOMBRE, pa.CONTRASENA_ADMINISTRADOR_NOMBRE, pa.USUARIO_ADMINISTRADOR_NOMBRE" 
                     + " FROM PERFIL_ADMINISTRADOR pa"
                     + " WHERE PERFIL_ADMINISTRADOR_ESTADO = 'A'"
                     + "AND pa.PERFIL_ADMINISTRADOR_ID = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, PERFIL_ADMINISTRADOR_ID);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            
            throw new NetworkException(e, getClass(), "getAdminById()");
        }
    }
    //Búsqueda por el Usuario
    public ResultSet getAdminByNombre(String USUARIO_ADMINISTRADOR_NOMBRE) throws NetworkException  {
         String query = " SELECT pa.CEDULA_ADMINISTRADOR_NOMBRE, pa.CONTRASENA_ADMINISTRADOR_NOMBRE, pa.USUARIO_ADMINISTRADOR_NOMBRE" 
                     + " FROM PERFIL_ADMINISTRADOR pa"
                     + " WHERE PERFIL_ADMINISTRADOR_ESTADO = 'A'"
                     + "AND pa.USUARIO_ADMINISTRADOR_NOMBRE = ?";    
       
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, USUARIO_ADMINISTRADOR_NOMBRE);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            
            throw new NetworkException(e, getClass(), "getAdminByNombre()");
        }
    }
    //Insertar datos
    public boolean insertAdmin(String CEDULA_ADMINISTRADOR_NOMBRE, String CONTRASENA_ADMINISTRADOR_NOMBRE, String USUARIO_ADMINISTRADOR_NOMBRE) throws NetworkException  {
        String query = " INSERT INTO PERFIL_ADMINISTRADOR (CEDULA_PERFIL_NOMBRE, CONTRASENA_PERFIL_NOMBRE, USUARIO_PERFIL_NOMBRE) VALUES(?, ?, ?),";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, CEDULA_ADMINISTRADOR_NOMBRE);
            pstmt.setString(2, CONTRASENA_ADMINISTRADOR_NOMBRE);
            pstmt.setString(3, USUARIO_ADMINISTRADOR_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "insertAdmin()");
        }
    }
    //Actualizar Datos (Debe colocar cedula y nuevo usuario)
    public boolean updateAdmin(String USUARIO_ADMINISTRADOR_NOMBRE, String NOMBRE_NUEVO) throws NetworkException  {
        String query = " UPDATE PERFIL_ADMINISTRADOR SET NOMBRE_NUEVO = ? WHERE  USUARIO_ADMINISTRADOR_NOMBRE = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, NOMBRE_NUEVO);
            pstmt.setString(2, USUARIO_ADMINISTRADOR_NOMBRE);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new NetworkException(e, getClass(), "updateAdmin()");
        }
    }
        public boolean deleteAdmin(int PERFIL_ADMINISTRADOR_ID) throws NetworkException{
            String query = "UPDATE PERFIL_ADMINISTRADOR SET PERFIL_ADMINISTRADOR_ESTADO = 'X' WHERE PERFIL_ADMINISTRADOR_ID = ?";
            try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, PERFIL_ADMINISTRADOR_ID);
            pstmt.executeUpdate();
            return true;
            } catch (Exception e) {
                 throw new NetworkException(e, getClass(), "deleteAdmin()");
            }
        }

        
    
}
