// Question 2: Thread vs Runnable
//  Implement the same counting program (1 to 10) using both:
//  • Extending Thread class
//  • Implementing Runnable interface. 
//  Compare both approaches.

public class Question2 {
    public static void main(String[] args) {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();
        t1.start();
        t2.start();

        // Using Runnable (passing Runnable into Thread)
        Thread t3 = new Thread(new thread3());
        Thread t4 = new Thread(new thread4());
        t3.start();
        t4.start();
        
    }
}

class thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i+=2) {
            System.out.println("Odd integer from thread: " + i);
        }
    }
}

class thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i+=2) {
            System.out.println("Even integer from thread: " + i);
        }
    }
}

class thread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i+=2) {
            System.out.println("Odd integer from runnable: " + i);
        }
    }
}

class thread4 implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i+=2) {
            System.out.println("Even integer from runnable: " + i);
        }
    }
}

