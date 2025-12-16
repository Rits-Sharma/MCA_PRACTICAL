// Question 6: Thread Sleep 
// Write a program that creates a clock thread displaying time every second using Thread.sleep(1000) . The clock should run for 10 seconds then stop.

public class Question6 {
    public static void main(String[] args) {
        Thread clock = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " second");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        clock.start();
    }
}
