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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class CodigoQR {
    private static final int qrTanAncho = 400;
    private static final int qrTanAlto = 400;
    private static final String formato = "png";
    private static final String ruta = "src\\ModuloExterno\\QRCodeStorage\\Codigo.png";

    public void CodigoQR () throws FileNotFoundException, IOException{
        System.out.println("Introduzca la cadena a modificar: ");
        Scanner sc = new Scanner(System.in);
        String dato = sc.nextLine();
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
    }
}
