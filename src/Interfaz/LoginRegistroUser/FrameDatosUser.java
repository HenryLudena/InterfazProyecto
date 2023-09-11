package Interfaz.LoginRegistroUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FrameDatosUser extends JFrame{
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);

    public ArrayList<ArrayList<String>> obtenerDatos() {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();

        try (
            //Obtener datos con el id
            Connection conn = conectar();
            Statement stmt = conn.createStatement()) {
            String SQL =         " SELECT M.MAS_NOMBRE, T.TIPNOMBRE, P.PRONOMBRES , P.PROAPELLIDOS , P.PROTELEFONO , M.MAS_OBSERVACION, M.MAS_SINTOMA_ALERGIAS, M.CODIGO_QR" 
                               + " FROM MASCOTA M"
                               + " JOIN TIPO T ON M.TIPID = T.TIPID"
                               + " JOIN PROPIETARIO P ON M.PROID = P.PROID"
                               + " JOIN PERFIL PE ON M.PERFIL_ID = PE.PERFIL_ID";
            // -- SELECT M.MAS_NOMBRE "NombreMascota", T.TIPNOMBRE "TipoMascota", P.PRONOMBRES "Pronombre", 
            // -- P.PROAPELLIDOS "NombrePropietario", P.PROTELEFONO "TelefonoPropietario", M.MAS_OBSERVACION "Observacion", M.MAS_SINTOMA_ALERGIAS 
            // -- FROM MASCOTA M
            // -- JOIN TIPO T ON M.TIPID = T.TIPID
            // -- JOIN PROPIETARIO P ON M.PROID = P.PROID
            // -- JOIN PERFIL PE ON M.PERFIL_ID = PE.PERFIL_ID
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                ArrayList<String> fila = new ArrayList<>();
                // Obtén los datos de cada columna y agrégalos a la fila
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    fila.add(rs.getString(i));
                }
                datos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return datos;
    }

    public Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:database\\PetNetwork.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }

    public String[] obtencionIndice(String usuario){
        // Establecer la conexión con la base de datos SQLite
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database\\PetNetwork.db");

            // Crear la consulta SQL para encontrar el ID
            String sql =  " SELECT M.MASID "
                        + " FROM MASCOTA M"
                        + " JOIN PERFIL PE ON M.PERFIL_ID = PE.PERFIL_ID" 
                        + " WHERE PE.USUARIO_PERFIL_NOMBRE = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Verificar si se encontró una fila
            if (resultSet.next()) {
                int id = resultSet.getInt("MASID");
                System.out.println("El ID de la fila con dato '" + usuario + "' es: " + id);
                // Cerrar recursos
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return ObtencionArregloCadena(id-1);
            
            } else {
                System.out.println("No se encontró ninguna fila con dato '" + usuario + "'.");
                // Cerrar recursos
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] ObtencionArregloCadena(int indiceFilaDeseada){
        //ArrayList que contiene toda la info
        ArrayList<ArrayList<String>> datos = obtenerDatos();

    if (indiceFilaDeseada >= 0 && indiceFilaDeseada < datos.size()) {
        ArrayList<String> filaDeseada = datos.get(indiceFilaDeseada);
        
        // Convierte la fila en un arreglo de cadenas (String[])
        String[] filaComoArreglo = filaDeseada.toArray(new String[0]);
        return filaComoArreglo;
    } else {
        System.out.println("El índice de fila especificado está fuera de rango.");
        return null;
    }
    }

    public void FrameDatos(String Usuario) {
        String[] CadenaLabel = obtencionIndice(Usuario);

        // Crear etiquetas para los datos
        JLabel[] labels = new JLabel[7];
        labels[0] = new JLabel("        MASCOTA:            " + CadenaLabel[0]);
        labels[1] = new JLabel("        TIPO:               " + CadenaLabel[1]);
        labels[2] = new JLabel("        NOMBRE FAMILIA:     " + CadenaLabel[2]);
        labels[3] = new JLabel("        APELLIDO FAMILIA:   " + CadenaLabel[3]);
        labels[4] = new JLabel("        TELEFONO:           " + CadenaLabel[4]);
        labels[5] = new JLabel("        OBSERVACION:        " + CadenaLabel[5]);
        labels[6] = new JLabel("        DATOS RELEVANTES:   " + CadenaLabel[6]);

        // Establecer el color de texto en azul para las etiquetas
        for (JLabel label : labels) {
            label.setFont(mainFont);
            label.setForeground(Color.BLUE);
        }

        // Crear un JPanel para los datos
        JPanel dataPanel = new JPanel(new GridLayout(7, 1, 5, 5));
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS)); // Borde en relieve
        dataPanel.setOpaque(false);

        // Añadir las etiquetas al panel de datos
        for (JLabel label : labels) {
            JPanel labelPanel = new JPanel(new BorderLayout());
            labelPanel.add(label, BorderLayout.LINE_START); // Alinea a la izquierda
            labelPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
            dataPanel.add(labelPanel);
        }

        // Ruta de la imagen que deseas mostrar (ajusta la ruta según tu archivo de imagen)
        String imagePath = CadenaLabel[7];

        // Carga la imagen desde el archivo y ajusta el tamaño
        BufferedImage image = loadImage(imagePath);
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);

        // Crea un borde vacío para agregar espacio a la derecha de la imagen
        imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100)); // 10 píxeles de espacio a la derecha

        // Crear un JPanel para contener los datos y la imagen
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.add(dataPanel, BorderLayout.WEST);
        contentPanel.add(imageLabel, BorderLayout.EAST);

        // Título del JFrame
        setTitle("DATOS USUARIO");

        // Tamaño del JFrame
        setSize(1000, 600);

        // Cierre de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana
        setLocationRelativeTo(null);

        // Añadir el panel de contenido al JFrame
        add(contentPanel);

        // Hacer visible el JFrame
        setVisible(true);
    }

    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
