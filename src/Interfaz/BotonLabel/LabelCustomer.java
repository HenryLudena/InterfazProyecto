package Interfaz.BotonLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelCustomer extends JLabel{
    private String label = "";
    //Color del texto
    private Color color  = Color.green;
    //Posición del texto respecto a su celda
    private int alignment= SwingConstants.LEFT;
    private Font font    = new Font("MesloLGL Nerd Font", Font.BOLD | Font.LAYOUT_LEFT_TO_RIGHT | Font.PLAIN, 12);
    public LabelCustomer(){
        CustomizerControl();
    }
    public LabelCustomer(String label){
        this.label = label;
        CustomizerControl();
    }
    public LabelCustomer(String label, Color color){
        this.label = label;
        this.color = color;
        CustomizerControl();
    }

    public LabelCustomer(String label, Color color, Font font){
        this.label = label;
        this.color = color;
        this.font  = font;
        CustomizerControl();
    }
    /**
     * @param <br>alignment</br>  SwingConstants: LEFT, CENTER, RIGHT, LEADING or TRAILING 
     */
    public LabelCustomer(String label, int alignment){
        this.label = label;
        this.alignment = alignment;
        CustomizerControl();
    }
    private void CustomizerControl(){
        setFont(font);
        //Texto que se le pasa para colocar en la interfaz
        setText(label);
        //Color del texto label (estático)
        setForeground(color);
        setHorizontalAlignment(alignment);
        //Colocar si es transparente o no
        setOpaque(false);
        //Ubicación
        setBackground(null);
        
    }
}