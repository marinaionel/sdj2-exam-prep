package reader_and_writer.my_solution_fair;

public class Reader implements Runnable {
    private ISharedResource sharedResource;

    public Reader(ISharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(System.identityHashCode(this) + ":: Try to acquire read...");
            sharedResource.acquireRead();
            System.out.println(System.identityHashCode(this) + ":: Read :: " + sharedResource.doRead());
            sharedResource.releaseRead();
            System.out.println(System.identityHashCode(this) + ":: Released read access...");
        }
    }
}
