package school;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Competition {

    private ArrayList<Runner> runners;
    private String name;

    public static final Collator col = Collator.getInstance(new Locale("cs", "CZ"));
    //public static final Comparator<Runner> COMP_BY_NAME = (Runner r1, Runner r2) -> r1.getSurName().compareTo(r2.getSurName());
    public static final Comparator<Runner> COMP_BY_NAME = (Runner r1, Runner r2) -> {
        int value = col.compare(r1.getSurName(),r2.getSurName());   
        if (value == 0){
            value = col.compare(r1.getName(), r2.getName());
        }
        return value;
    };
    
    public Competition(String name) {
        this.name = name;
        runners = new ArrayList<>();
    }

    public void registerRunner(String name, String surname) {
        Runner newRunner = new Runner(name, surname);
        this.runners.add(newRunner);
    }
    
    public void removeRunner(int runnerNumber) {
        Runner runner = findRunner(runnerNumber);
        boolean runnerRemoved = runners.remove(runner);

        if (!runnerRemoved) {
            throw new NoSuchElementException("Runner not found.");
        }
    }

    public void setStartTimeAll(int hours, int minutes, int seconds) {
        for (Runner runner : runners) {
            runner.setStartTime(hours, minutes, seconds);
        }
    }
    
    public void setStartTimeAll(int startTime) {
        for (Runner runner : runners) {
            runner.setStartTime(startTime);
        }
    }
    
    //The start time is calculated based on the registration number 
    public void setStartTimeAll(int offsetInMinutes, int startTime) {
        for (Runner runner : runners) {
            int mult = runner.getRegistrationNumber();
            runner.setStartTime(startTime + mult * (offsetInMinutes * 60));
        }
    }

    public void setStartTimeAll(int offsetInMinutes, int hours, int minutes, int seconds) {
        for (Runner runner : runners) {
            int mult = runner.getRegistrationNumber();
            runner.setStartTime(hours, minutes + (offsetInMinutes * mult), seconds);
        }
    }

    public void setStartTimeOf(int runnerNumber, int hours, int minutes, int seconds) {
        findRunner(runnerNumber).setStartTime(hours, minutes, seconds);
    }
    
    public void setEndTimeOf(int runnerNumber, int hours, int minutes, int seconds) {
        findRunner(runnerNumber).setEndTime(hours, minutes, seconds);
    }
    
    public Runner findRunner(int runnerNumber) {
        for (Runner runner : runners) {
            if (runner.getRegistrationNumber() == runnerNumber) {
                return runner;
            }
        }
        
        throw new NoSuchElementException("Runner not found.");
    }
    
    //deep copy
    public ArrayList<Runner> getRunners() {
        ArrayList<Runner> copy = new ArrayList<>();
        for (Runner runner : runners) {
            copy.add(new Runner(runner));
        }
        return copy;
    }
    
    private void sortBySurName(){
        Collections.sort(runners);
    }
    
    private void sortByRunTime(){
        Comparator cbrt = new ComparatorRunnerByRunTime();
        Collections.sort(runners, cbrt);
    }
    
    private void sortByNumberold(){
        Collections.sort(runners, new Comparator<Runner>(){
            @Override
            public int compare(Runner o1, Runner o2) {
                //return o1.getRunTime() - ((Runner)o2).getRunTime();
                return o1.getRunTime() - o2.getRunTime();
            }
            
        });
    }
    
    private void sortByNumber(){
        Collections.sort(runners, (Runner o1, Runner o2) -> o1.getRunTime() - o2.getRunTime());
    }
    
    private void sortBySurname(){
        Collections.sort(runners, COMP_BY_NAME);
    }
    
    public ArrayList<Runner> getRunnersSortedbySurName(){
        sortBySurName();
        return getRunners();
    }
    
    public ArrayList<Runner> sortByTime(){
        //TODO
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Runner runner : runners) {
            builder.append(runner.toString()).append("\n");
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Competition competition = new Competition("Run Czech");
        competition.registerRunner("Cyril", "Black");
        competition.registerRunner("Bob", "Green");
        competition.registerRunner("Alice", "Blue");
        System.out.println(competition);

        competition.setStartTimeAll(2, 12, 0, 0);
        System.out.println(competition);
        
        competition.setEndTimeOf(3, 12, 30, 0);
        System.out.println(competition);
        
        competition.sortBySurName();
        System.out.println(competition);
    }
}
