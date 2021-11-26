package reader_and_writer.writer_preference;

public class RunReaderPref {

    public static void main(String[] args) {
        WritersPreferenceSafeReadWrite sr = new WritersPreferenceSafeReadWrite();
        for (int i = 0; i < 10; i++) {
            Reader r = new Reader(sr, "R"+i);
            new Thread(r).start();
        }

        for (int i = 0; i < 4; i++) {
            Writer w = new Writer(sr, "W"+i);
            new Thread(w).start();
        }
    }
}
