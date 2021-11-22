package adapter;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        PrintList pl = new Adapter();
        pl.printList(list);
    }
}
