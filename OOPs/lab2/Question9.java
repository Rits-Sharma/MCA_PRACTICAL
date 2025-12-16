// 9. Create a class OnlineExam with a static method startTimer that starts a countdown timer for an online exam. Use a static block to initialize default timer settings (e.g., exam duration, interval between updates)    

class OnlineExam {
    // Static variables for default settings
    private static int examDuration;      // in seconds
    private static int updateInterval;    // in seconds

    // Static block to initialize default settings
    static {
        examDuration = 20;    // default exam duration: 30 seconds
        updateInterval = 10;   // default update interval: 5 seconds
        System.out.println("Static block executed. Default settings initialized.");
    }

    // Static method to start the countdown timer
    public static void startTimer() {
        int remainingTime = examDuration;

        System.out.println("Exam started. Duration: " + examDuration + " seconds.");
        while (remainingTime > 0) {
            try {
                Thread.sleep(updateInterval * 1000); // pause for update interval
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted.");
                return;
            }
            remainingTime -= updateInterval;
            if (remainingTime > 0) {
                System.out.println("Time remaining: " + remainingTime + " seconds.");
            } else {
                System.out.println("Exam over!");
            }
        }
    }
}

public class Question9 {
    public static void main(String[] args) {
        OnlineExam.startTimer();
    }
}
