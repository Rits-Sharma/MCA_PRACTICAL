// Question 8: Simple Synchronization 
// Create a counter class with increment() method. Create multiple threads that increment the counter 1000 times each. Demonstrate the race condition without synchronization and fix it using synchronized keyword.

// consider two thread working on the same resources then we cannot guarantee the correct output. for ex. here increment 2 times then it will either give 2000 or less then 2000 also.

// synchronization -> locking the resources by using the synchronized keyword

public class Question8 {
    static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
            System.out.println("Thread 1 finished.");
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
            System.out.println("Thread 2 finished.");
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count: " + count);
    }
}
