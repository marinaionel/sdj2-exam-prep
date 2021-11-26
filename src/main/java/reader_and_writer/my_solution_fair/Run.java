package reader_and_writer.my_solution_fair;

public class Run {
    public static void main(String[] args) {
        ISharedResource sharedResource = new SharedResource();

        for (int i = 0; i < 10; i++) {
            new Thread(new Reader(sharedResource)).start();
            new Thread(new Writer(sharedResource)).start();
        }
    }
}
