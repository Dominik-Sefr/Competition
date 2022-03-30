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
    public long runTime(){
        this.time = endTime - startTime;
        return this.time;
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

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
