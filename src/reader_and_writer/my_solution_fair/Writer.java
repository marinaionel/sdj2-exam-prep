package reader_and_writer.my_solution_fair;

public class Writer implements Runnable {
    private ISharedResource sharedResource;

    public Writer(ISharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(System.identityHashCode(this) + ":: Try to acquire write...");
            sharedResource.acquireWrite();
            System.out.println(System.identityHashCode(this) + ":: Write...");
            sharedResource.doWrite();
            System.out.println(System.identityHashCode(this) + ":: New value :: " + sharedResource.doRead());
            sharedResource.releaseWrite();
            System.out.println(System.identityHashCode(this) + ":: Released write access...");
        }
    }
}
