package producer_consumer;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++)
            System.out.println("Consumed the resource :: " + queue.take());
    }
}
