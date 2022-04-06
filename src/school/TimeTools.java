package school;

public final class TimeTools {
    
    private TimeTools(){
        
    }
    
    public static String secondsToStringTime(int secondsInput){
        int hours = secondsInput / 3600;
        int minutes = secondsInput / 60 % 60;
        int seconds = secondsInput % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    public static int timeToSeconds(int hours, int minutes, int seconds){
        return hours*3600 + minutes*60 + seconds;
        
    }
    
    public static int stringTimeToSeconds(String time) {
        String[] arr = time.split(":");
        int hours = Integer.parseInt(arr[0]);
        int minutes = Integer.parseInt(arr[1]);
        int seconds = Integer.parseInt(arr[2]);
        return timeToSeconds(hours, minutes, seconds);
    }
    
    public static void main(String[] args) {
        System.out.println(secondsToStringTime(7323));
        System.out.println(timeToSeconds(2, 2, 3));
        System.out.println(stringTimeToSeconds("02:02:03"));
    }
}
