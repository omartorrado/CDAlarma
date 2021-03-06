/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase se encarga de mostrar la hora, la alarma y los botones
 * @author otorradomiguez
 */
public class Display {

    public static boolean ledClock, ledAlarma, ledSet;

    //Interfaz
    public static JFrame marco = new JFrame();
    public static JPanel panelDisplay = new JPanel();
    public static JPanel panelBotones = new JPanel();
    public static JPanel panelIconos = new JPanel();
    public static JPanel panelSonando = new JPanel();
    public static JLabel displayHora = new JLabel();
    public static JLabel displayAlarma = new JLabel();
    public static JLabel iconoShowHora = new JLabel();
    public static JLabel iconoShowAlarma = new JLabel();
    public static JLabel iconoSet = new JLabel();
    public static JButton alarmaOnOff = new JButton("Alarma ON/OFF");
    public static JButton setHora = new JButton("set Hora");
    public static JButton setAlarma = new JButton("Set Alarma");
    public static JButton plusHora = new JButton("H +");
    public static JButton plusMinutos = new JButton("M +");
    public static JLabel showAlarma = new JLabel("ALARMA SONANDO");
    
    /**
     * Inicia la interfaz grafica
     */
    public static void InterfazInit(){
        panelBotones.add(alarmaOnOff);
        panelBotones.add(setHora);
        panelBotones.add(setAlarma);
        panelBotones.add(plusHora);
        panelBotones.add(plusMinutos);
        
        displayHora.setText(Reloj.horaActual.format(DateTimeFormatter.ISO_LOCAL_TIME));
        displayHora.setFont(new Font("TimesRoman",Font.PLAIN,24));
        displayAlarma.setFont(new Font(displayHora.getFont().getFamily(),Font.PLAIN,24));
        displayHora.setAlignmentX(0.5f);
        displayAlarma.setAlignmentX(0.5f);
        
        //displayAlarma.setText(Reloj.alarma.getHour()+":"+Reloj.alarma.getMinute());
        displayAlarma.setText("Alarma -> "+Reloj.alarma.format(DateTimeFormatter.ISO_LOCAL_TIME));
        
        panelDisplay.setLayout(new BoxLayout(panelDisplay,BoxLayout.Y_AXIS));
        panelDisplay.add(displayHora);
        panelDisplay.add(displayAlarma);
        
        showAlarma.setFont(new Font("TimesRoman",Font.PLAIN,24));
        showAlarma.setVisible(false);
        iconoShowHora.setFont(new Font("TimesRoman",Font.PLAIN,24));
        iconoShowAlarma.setFont(new Font("TimesRoman",Font.PLAIN,24));
        iconoSet.setFont(new Font("TimesRoman",Font.PLAIN,24));
        
        panelIconos.add(iconoShowHora);
        panelIconos.add(iconoShowAlarma);
        panelIconos.add(iconoSet);
        panelIconos.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        
        panelSonando.add(showAlarma);
        
        alarmaOnOff.addActionListener((ActionEvent e)->{
            Botonera.AlarmaOnOff();
        });
        
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
        marco.add(Box.createVerticalStrut(30));
        marco.add(panelBotones);
        marco.add(panelIconos);
        marco.add(panelSonando);
        marco.setVisible(true);
    }

    /**
     * Activa los leds en funcion de que variables de los leds esten activas
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

    /**
     * Actualiza el reloj y lo muestra en el formato deseado
     */
    public static void showClock() {
        
        displayHora.setText(Reloj.horaActual.format(DateTimeFormatter.ISO_LOCAL_TIME));
        /*
        la linea de arriba hace todo esto por mi
        String hora,minuto,segundo;
        if(Reloj.horaActual.getHour()<10){
            hora="0"+Reloj.horaActual.getHour();
        }else{
            hora=""+Reloj.horaActual.getHour();
        }
        if(Reloj.horaActual.getMinute()<10){
            minuto="0"+Reloj.horaActual.getMinute();
        }else{
            minuto=""+Reloj.horaActual.getMinute();
        }
        if(Reloj.horaActual.getSecond()<10){
            segundo="0"+Reloj.horaActual.getSecond();
        }else{
            segundo=""+Reloj.horaActual.getSecond();
        }
        displayHora.setText(hora+":"+minuto+":"+segundo);
        */
        }
    
    /**
     * Actualiza la alarma e indica la hora para la que esta configurada y si esta
     * activa o no
     */
    public static void showAlarma(){
        if(Botonera.alarmaActiva){
            displayAlarma.setText("Alarma -> "+Reloj.alarma.format(DateTimeFormatter.ISO_LOCAL_TIME)+"  ON");
        }else{
            displayAlarma.setText("Alarma -> "+Reloj.alarma.format(DateTimeFormatter.ISO_LOCAL_TIME)+"  OFF");
        }
    }

}
