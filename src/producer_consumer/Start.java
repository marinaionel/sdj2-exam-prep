package producer_consumer;

public class Start {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        new Consumer(blockingQueue);
        new Producer(blockingQueue);
    }
}
