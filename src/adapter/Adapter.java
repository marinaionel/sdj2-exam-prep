package adapter;

import java.util.List;

public class Adapter implements PrintList {
    private PrintString printString;

    public Adapter() {
        printString = new PrintString();
    }

    @Override
    public void printList(List<String> list) {
        //this is just for demonstration
        StringBuilder listString = new StringBuilder();
        list.forEach(value -> listString.append(value).append(", "));
        printString.printString(listString.toString().substring(0, listString.length() - 2));

//        printString.printString(list.toString());
    }
}
