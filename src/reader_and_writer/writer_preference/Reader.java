package reader_and_writer.writer_preference;

public class Reader implements Runnable{

    private WritersPreferenceSafeReadWrite sharedResourceController;
    private String name;

    public Reader(WritersPreferenceSafeReadWrite sharedResourceController, String name) {
        this.sharedResourceController = sharedResourceController;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(name + " wants read access");
            sharedResourceController.acquireRead();
            int i = sharedResourceController.doRead();
            System.out.println(name + " read " + i);
            sharedResourceController.releaseRead();
            System.out.println(name + " released read access");
        }
    }
}
