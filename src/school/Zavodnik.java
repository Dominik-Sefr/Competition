/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package school;

/**
 *
 * @author 
 */
public class Zavodnik {
    private String name;
    private String surName;
    private int birthYear;
    private boolean gender;
    private String club;
    private int wave;
    private boolean paid;
    private long startTime;
    private long endTime;
    private long time;
    private static int pocitadloRegistCisl = 1;
    private int registracniCislo;
    
    public Zavodnik(String name, String surName){
        this.name = name;
        this.surName = surName;
        registracniCislo = pocitadloRegistCisl;
        pocitadloRegistCisl++;   
    }
    public String runTime(){
        long secondsTemp = endTime - startTime;
        
        return TimeTools.secondsToTime(secondsTemp);
    }
    /**
     * True = muž
     * False = žena
     * @param gender 
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public void setStartTime(int hours, int minutes, int seconds){
        
        this.startTime = TimeTools.timeToSeconds(hours, minutes, seconds);
    }
    
    public void setStartTime(String time){ //09:12:00
        //TODO
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
     public void setEndTime(int hours, int minutes, int seconds){
        this.endTime = TimeTools.timeToSeconds(hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return "Zavodnik{" + "name=" + name + ", surName=" + surName + ", registracniCislo=" + registracniCislo + '}';
    }
    
}
