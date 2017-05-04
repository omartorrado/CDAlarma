/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta el la clase principal. Aqui se definen las variables de 
 * tiempo (horaActual y alarma) y se hace el menu;
 * @author otorradomiguez
 */
public class Reloj {
    
    public static LocalTime horaActual,alarma;
    
    public void Interfaz(){
        JFrame marco = new JFrame();
        JPanel panelDisplay = new JPanel();
        JPanel panelBotones = new JPanel();
        JLabel displayHora = new JLabel();
        JLabel displayAlarma = new JLabel();
        JLabel iconoShowHora = new JLabel();
        JLabel iconoShowAlarma = new JLabel();
        JLabel iconoSet = new JLabel();
        JButton alarmaOnOff = new JButton();
        JButton setHora = new JButton();
        JButton setAlarma = new JButton();
        JButton plusHora = new JButton();
        JButton plusMinutos = new JButton();
    }
    /**
     * Metodo Main
     * @param args 
     */
    public static void main(String[] args) {
        
    }
   
}
