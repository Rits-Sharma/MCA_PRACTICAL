// Question 14: Semaphore
// Implement a simple connection pool using Semaphore . Create a pool of 3 connections. 5 threads should compete for connections, acquiring and releasing them.

import java.util.concurrent.Semaphore;

public class Question14 {

    // Connection pool size
    private static final int POOL_SIZE = 3;
    private static Semaphore semaphore = new Semaphore(POOL_SIZE, true); // fair semaphore

    // Simulate a connection object
    static class Connection {
        private int id;
        public Connection(int id) { this.id = id; }
        public int getId() { return id; }
    }

    // Create a pool of connections
    private static Connection[] connections = new Connection[POOL_SIZE];
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            connections[i] = new Connection(i + 1);
        }
    }

    // Method to simulate acquiring a connection
    public static Connection acquireConnection() throws InterruptedException {
        semaphore.acquire(); // acquire a permit
        // Find first available connection (for simplicity, just pick one)
        for (Connection conn : connections) {
            if (conn != null) {
                System.out.println(Thread.currentThread().getName() + " acquired connection " + conn.getId());
                return conn;
            }
        }
        return null; // this should never happen in this simple demo
    }

    // Method to release connection
    public static void releaseConnection(Connection conn) {
        System.out.println(Thread.currentThread().getName() + " released connection " + conn.getId());
        semaphore.release(); // release the permit
    }

    public static void main(String[] args) {
        int threads = 5; // 5 threads competing for 3 connections

        for (int i = 1; i <= threads; i++) {
            Thread t = new Thread(() -> {
                try {
                    Connection conn = acquireConnection();
                    Thread.sleep(2000); // simulate work using connection
                    releaseConnection(conn);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            t.start();
        }
    }
}
