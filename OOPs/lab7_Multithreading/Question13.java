// Question 13: CountDownLatch
// Use CountDownLatch to create a race starter program. Main thread should wait for 4 ”runners” (threads) to get ready, then signal all to start simultaneously.

import java.util.concurrent.CountDownLatch;

// Main class (public)
public class Question13 {
    public static void main(String[] args) throws InterruptedException {
        int runners = 4;

        CountDownLatch readyLatch = new CountDownLatch(runners);
        CountDownLatch startLatch = new CountDownLatch(1);

        // Create runner threads
        for (int i = 1; i <= runners; i++) {
            Thread t = new Thread(new Runner(i, readyLatch, startLatch));
            t.start();
        }

        // Wait for all runners to be ready
        readyLatch.await();
        System.out.println("All runners are ready. On your marks, get set, go!");

        // Signal all runners to start simultaneously
        startLatch.countDown();
    }
}

// Runnable class (same file, not public)
class Runner implements Runnable {
    private int runnerNumber;
    private CountDownLatch readyLatch;
    private CountDownLatch startLatch;

    public Runner(int runnerNumber, CountDownLatch readyLatch, CountDownLatch startLatch) {
        this.runnerNumber = runnerNumber;
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        System.out.println("Runner " + runnerNumber + " is ready.");
        readyLatch.countDown(); // signal ready
        try {
            startLatch.await(); // wait for start signal
            System.out.println("Runner " + runnerNumber + " started running!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

