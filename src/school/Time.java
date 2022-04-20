/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package school;

/**
 *
 * @author 
 */
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) { //2 0 0
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    public Time(int secondsInput){ //7200
        hours = secondsInput / 3600;
        minutes = secondsInput / 60 % 60;
        seconds = secondsInput % 60; 
    }
    
    public Time(String time){ //02:00:00
        String[] arr = time.split(":");
        hours = Integer.parseInt(arr[0]);
        minutes = Integer.parseInt(arr[1]);
        seconds = Integer.parseInt(arr[2]);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
    
    public int timeToSeconds(){ //7200
       return hours*3600 + minutes*60 + seconds; 
    }
    
    public String timeToString(){ //02:00:00
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    public Time difference(Time t2){
       return new Time(t2.timeToSeconds() - this.timeToSeconds());
    }
}
