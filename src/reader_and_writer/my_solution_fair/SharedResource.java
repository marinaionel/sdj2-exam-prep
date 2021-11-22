package reader_and_writer.my_solution_fair;

public class SharedResource implements ISharedResource {
    //shared resource
    private int shared, activeReaders, activeWriters, waitingReaders, waitingWriters;

    public SharedResource() {
    }

    @Override
    public synchronized void acquireRead() {
        waitingReaders++;
        while (activeWriters > 0 || waitingWriters > waitingReaders) {
            try {
                System.out.println("Couldn't acquire read!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingReaders--;
        activeReaders++;
    }

    @Override
    public synchronized void releaseRead() {
        activeReaders--;
        if (activeReaders == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized void acquireWrite() {
        waitingWriters++;
        while (activeReaders > 0 || activeWriters > 0 ||
                waitingWriters < waitingReaders) {
            try {
                System.out.println("Couldn't acquire write!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        activeWriters++;
    }

    @Override
    public synchronized void releaseWrite() {
        activeWriters--;
        notifyAll();
    }

    @Override
    public void doWrite() {
        shared++;
    }

    @Override
    public int doRead() {
        return shared;
    }
}
