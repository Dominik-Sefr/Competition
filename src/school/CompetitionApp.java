package school;

import java.util.ArrayList;
import java.util.Scanner;

public class CompetitionApp {
    
    private static Competition competition;
    final private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        createCompetition();
        registerRunners();
        setStartTime();
        printRegisteredRunners();
    }
    
    public static void createCompetition(){
        System.out.println("Zadej jmeno zavodu");
        String name = sc.nextLine();
        competition = new Competition(name);
    }
    
    public static void registerRunners() {
        String name;
        String surName;
        System.out.println("Zadej jmena a prijmeni bezcu, ukonci slovem \"konec\"");
        while (!(name = sc.next()).equals("konec")) {
            surName = sc.next();
            competition.registerRunner(name, surName);
        }
    }
    
    public static void setStartTime() {
        System.out.print("Zadej zacatek startu: ");
        String input = sc.next();
        
        System.out.print("Zadej offset nasledujiho bezce v minutach: ");
        int offset = sc.nextInt();
        int parsedTime = TimeTools.stringTimeToSeconds(input);
        competition.setStartTimeAll(offset, parsedTime);
    }
    
    public static void printRegisteredRunners() {
        ArrayList<Runner> copy = competition.getRunnersSortedbySurName();
        for (Runner runner : copy) {
            System.out.printf("%3d. %10s %10s %15s\n", runner.getRegistrationNumber(), runner.getName(), runner.getSurName(), TimeTools.secondsToStringTime(runner.getStartTime()));
        }
    }
}
