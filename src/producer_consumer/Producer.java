package producer_consumer;

import org.apache.commons.lang3.RandomStringUtils;

public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            String string = RandomStringUtils.randomAlphabetic(10);
            queue.put(string);
            System.out.println("Produced the resource :: " + string);
        }
    }
}
