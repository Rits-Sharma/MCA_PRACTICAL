// Question 12: Thread Interruption
// Create a thread that counts infinitely until interrupted. Main thread should interrupt it after 3 seconds. Handle the interruption gracefully.

public class Question12 {
    public static void main(String[] args) {
        Thread countingThread = new Thread(new ThreadInterruptionExample());
        countingThread.start(); // start the counting thread

        try {
            Thread.sleep(3000); // main thread waits 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread interrupting counting thread...");
        countingThread.interrupt(); // interrupt the counting thread
    }
}

class ThreadInterruptionExample implements Runnable{
    @Override
    public void run() {
        int i = 1;
        try {
            while (true) {
                System.out.println("Counting: " + i++);
                Thread.sleep(100); // simulate work
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted. Stopping gracefully.");
        }
    }
}
