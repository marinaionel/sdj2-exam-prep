package reader_and_writer.my_solution_fair;

public interface ISharedResource {
    void acquireRead();

    void releaseRead();

    void acquireWrite();

    void releaseWrite();

    void doWrite();

    int doRead();
}
