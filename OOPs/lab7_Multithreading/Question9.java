// Question 9: Synchronized Method vs Block
//  Create a shared printer class. Implement two versions:
//  • Using synchronized method
//  • Using synchronized block
//  Compare the granularity of locking in both approaches.

public class Question9 {
    public static void main(String[] args) {
        Printer p = new Printer();
        Mythread th = new Mythread(p, "Thread 1");
        Mythread2 th2 = new Mythread2(p, "Thread 2");
        th.start();
        th2.start();
    }
}

class Printer {
    public synchronized void print1(String str) {
        System.out.println(str + " is running.");
    }
    public void print2(String str) {
        synchronized(this) {
            System.out.println(str + " is running.");
        }
    }
}

class Mythread extends Thread {
    Printer printer;
    public Mythread(Printer printer, String name) {
        this.printer = printer;
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            printer.print1(Thread.currentThread().getName());
        }
    }
}

class Mythread2 extends Thread {
    Printer printer;
    public Mythread2(Printer printer, String name) {
        this.printer = printer;
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            printer.print2(Thread.currentThread().getName());
        }
    }
}


