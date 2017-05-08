/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author otorradomiguez
 */
public class Display {

    public static boolean ledClock, ledAlarma, ledSet;

    //Interfaz
    public static JFrame marco = new JFrame();
    public static JPanel panelDisplay = new JPanel();
    public static JPanel panelBotones = new JPanel();
    public static JPanel panelIconos = new JPanel();
    public static JLabel displayHora = new JLabel();
    public static JLabel displayAlarma = new JLabel();
    public static JLabel iconoShowHora = new JLabel();
    public static JLabel iconoShowAlarma = new JLabel();
    public static JLabel iconoSet = new JLabel();
    public static JButton alarmaOnOff = new JButton("Alarma ON/OFF");
    public static JButton setHora = new JButton("set Hora");
    public static JButton setAlarma = new JButton("Set Alarma");
    public static JButton plusHora = new JButton("h +");
    public static JButton plusMinutos = new JButton("m +");
    
    public static void InterfazInit(){
        panelBotones.add(alarmaOnOff);
        panelBotones.add(setHora);
        panelBotones.add(setAlarma);
        panelBotones.add(plusHora);
        panelBotones.add(plusMinutos);
        
        displayHora.setText(Reloj.horaActual.getHour()+":"+Reloj.horaActual.getMinute()+":"+Reloj.horaActual.getSecond());
        displayAlarma.setText(Reloj.alarma.getHour()+":"+Reloj.alarma.getMinute());
        panelDisplay.setLayout(new BoxLayout(panelDisplay,BoxLayout.Y_AXIS));
        panelDisplay.add(displayHora);
        panelDisplay.add(displayAlarma);
        
        panelIconos.add(iconoShowHora);
        panelIconos.add(iconoShowAlarma);
        panelIconos.add(iconoSet);
        
        setHora.addActionListener((ActionEvent e)-> {
            Botonera.configHora();
        });
        
        setAlarma.addActionListener((ActionEvent e)->{
            Botonera.configAlarma();
        });
        
        plusHora.addActionListener((ActionEvent e)->{
            Botonera.plusHoras();
        });
        
        plusMinutos.addActionListener((ActionEvent e)->{
            Botonera.plusMinutos();
        });
        
        marco.setLayout(new BoxLayout(marco.getContentPane(),BoxLayout.Y_AXIS));
        marco.setSize(800,400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(panelDisplay);
        marco.add(panelIconos);
        marco.add(panelBotones);
        marco.setVisible(true);
    }

    /**
     * Activa los leds en funcion de que variables de los leds esten activos
     *
     * @param showHora
     * @param showAlarma
     * @param showSet
     */
    public static void showLeds(boolean showHora, boolean showAlarma, boolean showSet) {
        ledClock=showHora;
        ledAlarma=showAlarma;
        ledSet=showSet;
        if(ledClock){
            iconoShowHora.setText("R");
        }else{
            iconoShowHora.setText("");
        }
        if(ledAlarma){
            iconoShowAlarma.setText("A");            
        }else{
            iconoShowAlarma.setText("");
        }
        if(ledSet){
            iconoSet.setText("S");
        }else{
            iconoSet.setText("");
        }
    }

    public static void showClock() {
        displayHora.setText(Reloj.horaActual.getHour()+":"+Reloj.horaActual.getMinute()+":"+Reloj.horaActual.getSecond());
    }
    
    public static void showAlarma(){
        displayAlarma.setText(Reloj.alarma.getHour()+":"+Reloj.alarma.getMinute());
    }

}
