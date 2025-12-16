// Question 3: Thread Lifecycle
//  Create a program that demonstrates different thread states: NEW, RUNNABLE, TIMED WAITING, TERMINATED. Print the thread state at each transition.

public class Question3 {
    public static void main(String[] args) throws InterruptedException {
        threadState tState = new threadState();

        System.out.println("After creation: " + tState.getState());
        tState.start();
        System.out.println("After start: " + tState.getState());  // RUNNABLE

        Thread.sleep(500);
        System.out.println("During sleep (TIMED_WAITING): " + tState.getState()); // TIMED_WAITING

        tState.join(); // Wait for thread to finish
        System.out.println("After finished: " + tState.getState()); // TERMINATED
    }
}

class threadState extends Thread {
    public void run() {
        try {
            System.out.println("Inside thread: " + threadState.currentThread().getState());

            Thread.sleep(3000);

            System.out.println("After sleep: " + threadState.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}