// Question 11: Inter-Thread Communication
// Implement producer-consumer with single item buffer using wait() and notify() . Producer produces numbers 1-10, consumer consumes them.

public class Question11 {
    public static void main(String[] args) {
        MessageBox b = new MessageBox();

        Thread producer = new Thread(new Producer(b));
        Thread consumer = new Thread(new Consumer(b));

        producer.start();
        consumer.start();
    }
}

class MessageBox {
    private String msg;
    private boolean hasMessage;

    public synchronized void putMessage(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.msg = message;
        hasMessage = true;
        System.out.println("Produced: " + message);
        notify();
    }
    public synchronized String getMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        hasMessage = false;
        System.out.println("Consumed: " + msg);
        notify();
        return msg;
    }
}

class Producer implements Runnable {
    MessageBox box;

    public Producer(MessageBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            box.putMessage("Message : " + i);
        }
    }
}

class Consumer implements Runnable {
    MessageBox box;

    public Consumer(MessageBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            box.getMessage();
        }
    }
}

