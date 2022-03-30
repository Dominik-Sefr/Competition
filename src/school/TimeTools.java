/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package school;

/**
 *
 * @author 
 */
public final class TimeTools {
    
    private TimeTools(){
        
    }
    public static String secondsToTime(long secondsInput){
        int seconds = (int) (secondsInput % 60);
        int minutes =  (int) Math.floor(secondsInput /60);
        int hours = (int) Math.floor(minutes/60);
        minutes = minutes % 60;
        return hours + ":" + minutes + ":" + seconds;
    }
    public static long timeToSeconds(int hours, int minutes, int seconds){
        return hours*3600 + minutes*60 + seconds;
        
    }
}
