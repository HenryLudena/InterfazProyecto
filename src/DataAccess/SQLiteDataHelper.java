package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Framework.NetworkException;

public abstract class SQLiteDataHelper {
    
    private static String DBPathConnection = "jdbc:sqlite:database\\PetNetwork.db"; //null;
    private static Connection conn = null;
    public SQLiteDataHelper(){
        // if (!dbPathConnection.isEmpty())
        //  leer el archivo de conexcion
        //     SQLiteDataHelper.DBPathConnection = dbPathConnection;
    }
    
    protected static synchronized Connection openConnection() throws NetworkException{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            throw new NetworkException(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return conn;
    }
    protected static void closeConnection() throws NetworkException{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw new NetworkException(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
}
