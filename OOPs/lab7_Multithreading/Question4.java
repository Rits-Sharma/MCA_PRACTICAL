// Question 4: Thread Naming and Priority
// Create three threads with different priorities (MIN, NORM, MAX) and names. Each thread should print its name and priority, then count to 5. Observe the execution order.

public class Question4 {
    public static void main(String[] args) {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();
        thread3 t3 = new thread3();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        
        t1.start();
        t2.start();
        t3.start();
    }
}

class thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 1 : " + i);
        }
    }
}
class thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 2 : " + i);
        }
    }
}
class thread3 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread 3 : " + i);
        }
    }
}