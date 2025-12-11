public class RaceConditionExample {

    static class BankAccount {
        private int balance = 100;

        public void withdraw(int amount) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() +
                                 " is going to withdraw $" + amount);

                // Simulate some processing time
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance -= amount;
                System.out.println(Thread.currentThread().getName() +
                                 " completed withdrawal. Remaining balance: $" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() +
                                 ": Not enough balance!");
            }
        }

        public int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        // Create two threads that will both try to withdraw money
        Thread thread1 = new Thread(() -> account.withdraw(80), "Thread-1");
        Thread thread2 = new Thread(() -> account.withdraw(80), "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("\nFinal balance: $" + account.getBalance());
        // Should be -60 (overdrawn!) but due to race condition check might pass for both
    }
}
