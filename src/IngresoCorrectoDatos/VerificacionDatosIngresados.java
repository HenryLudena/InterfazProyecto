package IngresoCorrectoDatos;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class VerificacionDatosIngresados {
    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    public JLabel IngresoCedula(JTextField tfCedula, JLabel JLCedulaVerificada) {
        String Cedula = " ";
        int SoloNumeros = 0;
        String longitudCedula = " ";
        
            try {
                //Cedula ingresada a String para verificación
                Cedula = tfCedula.getText();
                //Intentar convertir datos ingresados por el usuario a números
                SoloNumeros=Integer.parseInt(Cedula);
                longitudCedula = String.valueOf(SoloNumeros);
                //Verificar si cumple con la longitud
                if (longitudCedula.length()==10) 
                    JLCedulaVerificada.setText(longitudCedula);
                else
                    JLCedulaVerificada.setText("Longitud no válida");
            } catch (Exception e) {
                //En caso de no ingresar solo números
                JLCedulaVerificada.setText("Carácteres no válidos");
            }
        return JLCedulaVerificada;
    }
}
