package reader_and_writer.writer_preference;

public class WritersPreferenceSafeReadWrite  {

    private int activeReaders;
    private boolean isWriting;
    private int waitingWriters;

    private int sharedData;

    public WritersPreferenceSafeReadWrite() {
        activeReaders = 0;
        waitingWriters = 0;
        isWriting = false;
        sharedData = 0;
    }

    public synchronized void acquireRead() {
        while(isWriting || waitingWriters > 0) {
            try {
                if(isWriting) {
                    System.out.println("Couldn't acquire read, because of active writer");
                } else if(waitingWriters > 0) {
                    System.out.println("Cound't acqurie read, because of waiting writers");
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeReaders++;
    }

    public synchronized void releaseRead() {
        activeReaders--;
        if(activeReaders == 0){
            notifyAll();
        }
    }

    public synchronized void acquireWrite() {
        waitingWriters++;
        while(activeReaders > 0 || isWriting) {
            try {
                if(isWriting) {
                    System.out.println("Couldn't acquire write, because of active writer");
                } else if(activeReaders > 0) {
                    System.out.println("Cound't acqurie write, because of active readers");
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        isWriting = true;
    }

    public synchronized void releaseWrite() {
        isWriting = false;
        notifyAll();
    }

    public void doWrite() {
        sharedData++;
    }

    public int doRead() {
        return sharedData;
    }
}
