/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Esta el la clase principal. Aqui se definen las variables de 
 * tiempo (horaActual y alarma) y se hace el menu;
 * @author otorradomiguez
 */
public class Reloj {
    
    public static LocalTime horaActual=LocalTime.of(0, 0);
    public static LocalTime alarma=LocalTime.MIDNIGHT;
    

    /**
     * Metodo Main
     * @param args 
     */
    public static void main(String[] args) {   
        Display.InterfazInit();        
        /*
        Lo que esta abajo hecho con un thread usando un timer 
        */
        Timer nrt= new Timer();
        nrt.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                horaActual=horaActual.plusSeconds(1);
                Display.showClock(); 
                if(horaActual.getHour()==alarma.getHour()&&horaActual.getMinute()==alarma.getMinute()&&Display.showAlarma.isVisible()==false&&Botonera.alarmaActiva){
                    Altavoz.ringOn=true;
                    Display.showAlarma.setVisible(true);
                }else if(Display.showAlarma.isVisible()){
                    Display.showAlarma.setVisible(false);
                }
            }
        }, 0, 1000);
        //UpdateClock uc=new UpdateClock();
        //uc.start();
    }
       
    /*
    public static class UpdateClock extends Thread{

        @Override
        public void run() {
            while(this.isAlive()){                  
            try {
                Thread.sleep(1000);
                horaActual=horaActual.plusSeconds(1);
                Display.showClock(); 
                if(horaActual.getHour()==alarma.getHour()&&horaActual.getMinute()==alarma.getMinute()&&Display.showAlarma.isVisible()==false&&Botonera.alarmaActiva){
                    Altavoz.ringOn=true;
                    Display.showAlarma.setVisible(true);
                }else if(Display.showAlarma.isVisible()){
                    Display.showAlarma.setVisible(false);
                }
            } catch (InterruptedException ex) {                
            }
            }
        }
        
    }
*/
   
}
