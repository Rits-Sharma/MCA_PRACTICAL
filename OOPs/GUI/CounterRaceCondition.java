public class CounterRaceCondition {

    static class Counter {
        private int count = 0;

        public void increment() {
            // This operation is NOT atomic:
            // 1. Read count value
            // 2. Add 1
            // 3. Write back to count
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create and start 1000 threads
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected count: 100,000");
        System.out.println("Actual count: " + counter.getCount());
        // The actual count will be less than 100,000 due to race condition!
    }
}
