package school;

import java.time.LocalDate;

public final class Runner implements Comparable<Runner>{

    private final String name;
    private final String surName;
    private int birthYear;
    private LocalDate dob;
    private Gender gender;
    private String club;
    private int wave;
    private boolean paid;
    private Time startTime;
    private int endTime;
    private int runTime;
    private static int registrationNumbersCount = 1;
    private final int registrationNumber;

    public Runner(String name, String surName) {
        this.name = name;
        this.surName = surName;
        registrationNumber = registrationNumbersCount;
        registrationNumbersCount++;
    }
    
    //defensive copy of Runner r
    public Runner(Runner r) {
        this.name = r.name;
        this.surName = r.surName;
        this.registrationNumber = r.registrationNumber;
        this.club = r.club;
        this.gender = r.gender;
        this.paid = r.paid;
        this.startTime = r.startTime;
        this.endTime = r.endTime;
    }

    /**
     * M = muž, F = žena
     * @param gender
     */
    public void setGender(char gender) {
        if(gender == 'f' || gender == 'F' || gender == 'w'){
            this.gender = Gender.F;
        }else {
            this.gender = Gender.M;
        }
        
    }

    public void setClub(String club) {
        if(!club.matches("^[A-Z]{2,5}$")){
            throw new IllegalArgumentException("Nevalidni nazev klubu");
        }
        this.club = club;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setStartTime(int startTime) {
        //this.startTime = startTime;
        this.startTime = new Time(startTime);
    }

    public void setStartTime(int hours, int minutes, int seconds) {
        //this.startTime = TimeTools.timeToSeconds(hours, minutes, seconds);
        this.startTime = new Time(hours, minutes, seconds);
    }

    public void setStartTime(String time) { //09:12:00
        //this.startTime = TimeTools.stringTimeToSeconds(time);
        this.startTime = new Time(time);
    }

    public void setEndTime(int endTime) {
        if(startTime == null){
            throw new StartTimeNotSet("Nebyl jeste zadany cas startu");
        }
        this.endTime = endTime;
    }

    public void setEndTime(int hours, int minutes, int seconds) {
        if(startTime == null){
            throw new StartTimeNotSet("Nebyl jeste zadany cas startu");
        }
        this.endTime = TimeTools.timeToSeconds(hours, minutes, seconds);
    }
    
    public void setEndTime(String time) { //09:12:00
        if(startTime == null){
            throw new StartTimeNotSet("Nebyl jeste zadany cas startu");
        }
        this.endTime = TimeTools.stringTimeToSeconds(time);
    }
// Alternative defensive copy, in addition clone() can be overriden    
//    private Runner(String name, String surName, int runnerNumber) {
//        this.name = name;
//        this.surName = surName;
//        registrationNumber = runnerNumber;
//    }
//    
//    public Runner getZavodnik() {
//        Runner copy = new Runner(this.name, this.surName, this.registrationNumber);
//        copy.club = this.club;
//        copy.gender = this.gender;
//        copy.paid = this.paid;
//        copy.startTime = this.startTime;
//        copy.endTime = this.endTime;
//        return copy;
//    }
    
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
    
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public char getGender() {
        return gender.toString().charAt(0);
    }

    public String getClub() {
        return club;
    }

    public int getWave() {
        return wave;
    }

    public boolean isPaid() {
        return paid;
    }

    public int getStartTime() {
        return startTime.timeToSeconds();
    }

    public int getEndTime() {
        return endTime;
    }

    private int runTime() {
        return endTime - startTime.timeToSeconds();
    }
    
    public int getRunTime() {
        if(runTime == 0 && startTime != null && endTime != 0){
            this.runTime = runTime();
        }
        return runTime;
    }
    
    @Override
    public int compareTo(Runner z2){
        return this.surName.compareTo(z2.surName);
    }
    
    @Override
    public String toString() {
        return String.format("%10s %10s %5d %15s %15s %15s", 
                name, surName, registrationNumber, 
                TimeTools.secondsToStringTime(startTime),
                TimeTools.secondsToStringTime(endTime),
                TimeTools.secondsToStringTime(getRunTime()));
    }

    public static void main(String[] args) {
        Runner prvni = new Runner("Dominik", "Šefr");
        //prvni.setStartTime(1, 15, 30);
        try{
            prvni.setEndTime(2, 30, 60);
            System.out.println(prvni);
        }catch (StartTimeNotSet e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Chyba");
        }
        Runner druhy = new Runner("Radek", "Mocek");
        System.out.println(druhy);
        prvni.setClub("AAABA");
    }
}
