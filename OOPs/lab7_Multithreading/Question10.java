// Question 10: Static Synchronization
// Create a class with both instance and static synchronized methods. Demonstrate that static synchronization locks the class level while instance synchronization locks object level.

class Counter {
    // Instance synchronized method (locks object level)
    public synchronized void instanceIncrement() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Instance: " + i);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }

    // Static synchronized method (locks class level)
    public static synchronized void staticIncrement() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Static: " + i);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

public class Question10 {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        // Instance level threads (different objects)
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                c1.instanceIncrement();
            }
        },"T1");         // ↑→ this is the lambda equivalent and t1 is the expandable form for this function that is used in t2, t3 and t4.
        Thread t2 = new Thread(() -> c2.instanceIncrement(), "T2");

        t1.start();
        t2.start();

        // Static level threads (class lock)
        Thread t3 = new Thread(() -> Counter.staticIncrement(), "T3");
        Thread t4 = new Thread(() -> Counter.staticIncrement(), "T4");

        t3.start();
        t4.start();
    }
}
