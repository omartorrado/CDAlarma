/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta el la clase principal. Aqui se definen las variables de 
 * tiempo (horaActual y alarma) y se hace el menu;
 * @author otorradomiguez
 */
public class Reloj {
    
    public static LocalTime horaActual=LocalTime.now();
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
            while(true){            
            try {
                Thread.sleep(1000);
                Display.showClock();
                System.out.println("Actualizado");
            } catch (InterruptedException ex) {
                
            }
            }
        }
        
    }
   
}
