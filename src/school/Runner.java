package school;

public final class Runner implements Comparable<Runner>{

    private final String name;
    private final String surName;
    private int birthYear;
    private char gender;
    private String club;
    private int wave;
    private boolean paid;
    private int startTime;
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
        this.gender = gender;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setStartTime(int hours, int minutes, int seconds) {
        this.startTime = TimeTools.timeToSeconds(hours, minutes, seconds);
    }

    public void setStartTime(String time) { //09:12:00
        this.startTime = TimeTools.stringTimeToSeconds(time);
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setEndTime(int hours, int minutes, int seconds) {
        this.endTime = TimeTools.timeToSeconds(hours, minutes, seconds);
    }
    
    public void setEndTime(String time) { //09:12:00
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
        return gender;
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
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    private int runTime() {
        return endTime - startTime;
    }
    
    public int getRunTime() {
        if(runTime == 0 && startTime != 0 && endTime != 0){
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
        prvni.setStartTime(1, 15, 30);
        prvni.setEndTime(2, 30, 60);
        System.out.println(prvni);
        Runner druhy = new Runner("Radek", "Mocek");
        System.out.println(druhy);
    }
}
