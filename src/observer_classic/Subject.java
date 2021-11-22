package observer_classic;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {

    private List<IObserver> observers;
    private String message;
    private boolean changed;

    public Subject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (observer == null) throw new NullPointerException();
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        if (observer == null) throw new NullPointerException();
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<IObserver> temp;
        if (changed) {
            temp = new ArrayList<>(observers);
            changed = false;
            for (IObserver obj : temp) {
                obj.update();
            }
        }
    }

    @Override
    public String getUpdate(IObserver observer) {
        return message;
    }

    public void sendMessage(String message) {
        System.out.println("Subject: A message was sent: \"" + message + "\"");
        this.message = message;
        changed = true;
        notifyObservers();
    }

}