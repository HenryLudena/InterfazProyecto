package Interfaz.LoginRegistroUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccess.SQLiteDataHelper;
import Framework.NetworkException;

public class VerificacionLoginUser extends SQLiteDataHelper {
    public boolean VerificacionLoginUser(String usuario, String contrasena) throws NetworkException{
        Connection conn = openConnection();
        try {
            // Establece la conexión a la base de datos como se mostró anteriormente.

            // Define el dato que deseas verificar.
            

            // Define la consulta SQL para verificar la existencia del dato en la tabla.
            String sql = "SELECT COUNT(*) FROM PERFIL WHERE USUARIO_PERFIL_NOMBRE = ? AND CONTRASENA_PERFIL_NOMBRE = ?";

            // Prepara la consulta SQL.
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            
            // Ejecuta la consulta y obtén el resultado.
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Si el resultado es mayor que 0, significa que el dato existe en la tabla.
            if (resultSet.getInt(1) > 0) {
                return true;
            } else {
                return false;
            }
            

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
