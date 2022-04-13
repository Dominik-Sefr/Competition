/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package school;

import java.util.Comparator;

/**
 *
 * @author 
 */
public class ComparatorRunnerByRunTime implements Comparator<Runner>{

    @Override
    public int compare(Runner o1, Runner o2) {
        return o1.getRunTime() - o2.getRunTime();
        /*if(o1.getRunTime() > o2.getRunTime()){
            return 1;
        } else if(o1.getRunTime() < o2.getRunTime()){
            return -1;
        }
        return 0;*/
        //Double.compare(o1.getRunTime(), o2.getRunTime());
    }

}
