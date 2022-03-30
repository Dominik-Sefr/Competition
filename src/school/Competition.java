/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package school;

/**
 *
 * @author jana.vitvarova
 */
public class Competition {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zavodnik prvni = new Zavodnik("Dominik", "Šefr");
        prvni.setStartTime(1, 15, 30);
        prvni.setEndTime(2, 30, 60);
        System.out.println(prvni.runTime());
        System.out.println(prvni);
        Zavodnik druhy = new Zavodnik("Radek", "Mocek");
        System.out.println(druhy);
    }
    
}
