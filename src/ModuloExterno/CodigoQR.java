package ModuloExterno;
//Clase que sirve para trabajar con imágenes en forma de matriz de píxeles
import java.awt.image.BufferedImage;
//Se puede sobrescribir datos en un archivo existente o crear uno nuevo si no existe
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import DataAccess.DAO.TablaDAOCodigoQR;
import DataAccess.Entities.Mascota;
import Framework.NetworkException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CodigoQR {
    private static final int qrTanAncho = 400;
    private static final int qrTanAlto = 400;
    private static final String formato = "png";

    public void CodigoQR (String Usuario, String nombreMascota, String nombreDueno, String direccion, String telefono) throws FileNotFoundException, IOException, NetworkException{
        //Usuario es el string que va a imprimir el mensaje en el codigo QR
        String ruta = "src\\ModuloExterno\\QRCodeStorage\\" + Usuario + ".png";
        
        String dato = "¡Hola! Mi nombre es " + nombreMascota + ". " + "\n" + nombreDueno + " es mi dueño." +"\n"+"Vivo en " + direccion + "."+"\nPuedes llamar al " +telefono + "\n¡MUCHAS GRACIAS POR ENCONTRARME!";
        System.out.println("Conectando...");
        BitMatrix matriz = null;
        //Ayuda a la escritura de la información
        Writer writer = new QRCodeWriter();
        try {
            matriz = writer.encode(dato, BarcodeFormat.QR_CODE, qrTanAlto, qrTanAncho);
        } catch (WriterException e) {
            // Se imprimen los errores en caso de existir alguno
            e.printStackTrace();
        }
        BufferedImage imagen = new BufferedImage(qrTanAlto, qrTanAncho, BufferedImage.TYPE_INT_RGB);
        //Impresión de la imagen con for porque es como una matriz
        for(int i = 0; i <qrTanAlto ; i++){
            for (int j = 0; j < qrTanAncho; j++) {
                //0xff permite trabajar con los últimos ocho bits significativos
                int valor = (matriz.get(i, j) ? 0 : 1) & 0xff;
                //Permite pintar en negro la imagen
                imagen.setRGB(i, j, (valor== 0 ? 0 : 0xFFFFFF));
            }
        }
        //Lugar donde se coloca la imagén (la carpeta)
        FileOutputStream codigo = new FileOutputStream(ruta);
        ImageIO .write(imagen, formato, codigo);
        System.out.println("Listo!");
        codigo.close();

        boolean bandera = updateMascota(ruta, nombreMascota);
        if(bandera == true)
        System.out.println("Ruta ingresada en la base de datos");
        else
        System.out.println("Error en la conexión");
    }

     public boolean updateMascota(String Ruta, String MAS_NOMBRE) throws NetworkException{
        return new TablaDAOCodigoQR().updateCodigoQR(Ruta, MAS_NOMBRE);
    } 
    
}
