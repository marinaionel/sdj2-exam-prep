package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<String> queue = new LinkedList<>();

    public synchronized void put(String t) {
        while (queue.size() >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(t);
//      notifyAll() wakes all of the threads that are blocked in wait() calls
        notifyAll();
    }

    public synchronized String take() {
        while (queue.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return queue.poll();
    }
}