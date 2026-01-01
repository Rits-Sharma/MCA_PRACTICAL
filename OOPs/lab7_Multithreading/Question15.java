// Question 15: ReentrantLock
// Rewritethecountersynchronization problem (Question 8) using instead of synchronized . Demonstrate tryLock() with timeout.

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Question15 {

    static int count = 0; // shared resource
    static ReentrantLock lock = new ReentrantLock(); // lock object

    // Increment method using lock
    public static void increment() {
        lock.lock(); // acquire lock
        try {
            count++;
        } finally {
            lock.unlock(); // always release lock
        }
    }

    // Increment method using tryLock with timeout
    public static void incrementWithTryLock() {
        try {
            // Try to acquire lock for up to 50 milliseconds
            if (lock.tryLock(50, TimeUnit.MILLISECONDS)) {
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create threads
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                //increment();               // use this for normal lock
                incrementWithTryLock();      // use this to demonstrate tryLock
            }
            System.out.println("Thread 1 finished.");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                //increment();               
                incrementWithTryLock();      
            }
            System.out.println("Thread 2 finished.");
        });

        // Start threads
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + count);
    }
}

