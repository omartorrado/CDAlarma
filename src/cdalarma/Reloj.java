/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

import java.time.LocalTime;
import javax.swing.JLabel;

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
        UpdateClock uc=new UpdateClock();
        uc.start();
    }
    
    public static class UpdateClock extends Thread{

        @Override
        public void run() {
            while(this.isAlive()){                  
            try {
                Thread.sleep(1000);
                horaActual=horaActual.plusSeconds(1);
                Display.showClock(); 
                System.out.println(Display.panelIconos.getComponentCount());
                if(horaActual.getHour()==alarma.getHour()&&horaActual.getMinute()==alarma.getMinute()&&Display.panelIconos.getComponentCount()<4){
                    Altavoz.ringOn=true;
                    Display.panelIconos.add(new JLabel("ALARMA SONANDO"));
                }else if(Display.panelIconos.getComponentCount()>3){
                    Display.panelIconos.remove(3);
                }
            } catch (InterruptedException ex) {                
            }
            }
        }
        
    }
   
}
