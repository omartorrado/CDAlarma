/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdalarma;

/**
 *Esta clase controla el funcionamiento de los botones
 * @author otorradomiguez
 */
public class Botonera {
    public static boolean alarmaActiva=false;
    public static boolean setHora;
    public static boolean setAlarma;
    
    /**
     * Activa o desactiva la alarma segun su estado anterior
     */
    public static void AlarmaOnOff(){
        /*
        if(alarmaActiva){
            alarmaActiva=false;            
        }else{
            alarmaActiva=true;
        }
        */
        //Esto es lo mismo de arriba de forma mas compacta
        alarmaActiva = !alarmaActiva;
        Display.showAlarma();
    }
    
    /**
     * Detiene el altavoz cuando esta sonando la alarma
     */
    public static void StopAlarma(){
        
    }
    
    /**
     * Configura la hora del reloj
     */
    public static void configHora(){
        if(setHora==false){
        setHora=true;
        setAlarma=false;
        Display.showLeds(true, false, true);
        Display.showClock();
        }else{
            setHora=false;
            Display.showLeds(false, false, false);
        }
    }
    
    /**
     * Configura la hora de la alarma
     */
    public static void configAlarma(){
        if(setAlarma==false){
        setAlarma=true;
        setHora=false;
        Display.showLeds(false, true, true);
        Display.showAlarma();
        }else{
            setAlarma=false;
            Display.showLeds(false, false, false);
        }
    }
    
    /**
     * Aumenta los minutos de la hora actual o de la alarma dependiendo 
     * de cual de configHora/configAlarma este activo
     */
    public static void plusMinutos(){
        if(setHora){
            Reloj.horaActual=Reloj.horaActual.plusMinutes(1);
            Display.showClock();
        }else if(setAlarma){
            Reloj.alarma=Reloj.alarma.plusMinutes(1);
            Display.showAlarma();
        }        
    }
    
    /**
     * Aumenta las horas de la hora actual o de la alarma dependiendo 
     * de cual de configHora/configAlarma este activo
     */
    public static void plusHoras(){
        if(setHora){
            Reloj.horaActual=Reloj.horaActual.plusHours(1);
            Display.showClock();
        }else if(setAlarma){
            Reloj.alarma=Reloj.alarma.plusHours(1);
            Display.showAlarma();
        }
        
    }
}
