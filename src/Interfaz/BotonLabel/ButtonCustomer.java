package Interfaz.BotonLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ButtonCustomer  extends JButton implements MouseListener {
    Font font = new Font ("MesloLGL Nerd Font", Font.BOLD | Font.LAYOUT_LEFT_TO_RIGHT, 12);
    //Constructor: solo botón
    public ButtonCustomer(String label){
        super(label);
        EstiloEtiqueta();
    }
    //Constructor: Botón con imagen
    public ButtonCustomer(String label, String iconPath){
        goStyleMenu(label, iconPath);
    }
    //En caso de querer el botón con un ícono al lado
    public void goStyleMenu(String label, String iconPath){ 
        addMouseListener(this);
        setText(label);
        setSize(20, 70);
        setBounds(80, 30, 90, 20); 
        
        setOpaque(false);
        setForeground(Color.GRAY);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setIcon(new ImageIcon(iconPath));
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(font);
    }
    //En caso de querer solo el botón
    public void EstiloEtiqueta() {
        //Para que el botón sea transparente 
        setOpaque(false);
        //Color al borde de los botones cuando se pasa cursor sobre él (solo si setContentAreaFilled es true)
        setFocusPainted(false);
        //Color a los bordes de los ventanas (solo si setContentAreaFilled es true)
        setBorderPainted(false);
        //Color en forma de rectangulo (botón transparaente)
        setContentAreaFilled(false);
        //Color del Texto
        setForeground(Color.orange);
        //Posición del texto dentro del botón
        setHorizontalAlignment(SwingConstants.CENTER);
        //Forma del cursor cuando se coloca encima del botón
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Formato del texto
        setFont(font);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Cuando se da clic sobre el botón, color del texto
        setForeground(Color.BLUE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Color cuando se sale del botón (debe ser negro para regresar al color original)
        setForeground(Color.BLACK);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
