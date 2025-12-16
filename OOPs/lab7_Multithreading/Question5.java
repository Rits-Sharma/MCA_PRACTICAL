// Question 5: Daemon Threads
// Create a user thread that counts to 20 and a daemon thread that counts to 100. Demonstrate that the JVM exits when all user threads finish, even if daemon threads are still running.

public class Question5 {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            for (int i = 1; i < 21; i++) {
                System.out.println("User thread: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("User thread finished.");
        });

        Thread daemonThread = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Daemon Thread : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Daemon Thread finished!");
        });

        daemonThread.setDaemon(true); // MUST be called before start()

        // Start both threads
        userThread.start();
        daemonThread.start();
    }
}
