// Question 7: Join Method 
// Create three threads where:
//  • Thread1 counts 1-5
//  • Thread2 starts only after Thread1 completes
//  • Thread3 starts only after Thread2 completes
//  Use join() method to coordinate them.

public class Question7 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1 : " + i);
            }
        });
        Thread thread2 = new Thread(()-> {
            for (int i = 6; i <= 10; i++) {
                System.out.println("Thread 2 : " + i);
            }
        });
        Thread thread3 = new Thread(()-> {
            for (int i = 11; i <= 15; i++) {
                System.out.println("Thread 3 : " + i);
            }
        });

        try {
            thread1.start();
            thread1.join();  // Thread2 waits for Thread1

            thread2.start();
            thread2.join();  // Thread3 waits for Thread2

            thread3.start();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
