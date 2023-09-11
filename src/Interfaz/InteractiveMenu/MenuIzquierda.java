package Interfaz.InteractiveMenu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Interfaz.BotonLabel.ButtonCustomer;

public class MenuIzquierda extends JPanel implements ActionListener{
    
    public  ButtonCustomer 
            btnAdmin        = new ButtonCustomer("Tabla Admin"       ,  "src\\Interfaz\\Imagenes\\net.png"),
            btnUser         = new ButtonCustomer("Tabla User"      ,    ""),
            btnAnimal       = new ButtonCustomer("Tabla Animal"       , "");
    
    public MenuIzquierda(){
        
        super(new GridLayout(3, 1, 10, 10));//filas, columnas, espacioFilas, espacioColumnas
        //setBackground(new Color(82, 90, 101));
        removeAll();
        add(btnAdmin);    
        add(btnUser);   
        add(btnAnimal);    
        
        //Panel con botones visibles
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this){
            if(this.isVisible()){
                this.setVisible(false);
            }else
                this.setVisible(true);
        }
        else{
            //Impresión en caso de presionar algún botón
            System.out.println(e.getActionCommand());
        }
        
    }
}
