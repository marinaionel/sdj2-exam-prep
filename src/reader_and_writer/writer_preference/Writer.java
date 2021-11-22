package reader_and_writer.writer_preference;

public class Writer implements Runnable {

    private WritersPreferenceSafeReadWrite sharedResourceController;
    private String name;

    public Writer(WritersPreferenceSafeReadWrite sharedResourceController, String name) {
        this.sharedResourceController = sharedResourceController;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(name + " wants write access");
            sharedResourceController.acquireWrite();
            sharedResourceController.doWrite();
            System.out.println(name + " changed the variable to " +
                    sharedResourceController.doRead());
            sharedResourceController.releaseWrite();
            System.out.println(name + " released write access");
        }
    }
}
