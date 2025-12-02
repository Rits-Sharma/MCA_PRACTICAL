// Question 1: Thread Creation
//  Create two threads that print numbers from 1 to 10 simultaneously. One thread should print odd numbers and the other even numbers. Observe the interleaving of outputs.

public class Question1 {
    public static void main(String[] args) {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();
        t1.start();
        t2.start();
    }
}

class thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i+=2) {
            System.out.println("Odd integer: " + i);
        }
    }
}

class thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i+=2) {
            System.out.println("Even integer: " + i);
        }
    }
}