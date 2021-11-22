package observer_classic;

public interface ISubject {

    void registerObserver(IObserver observer);

    void unregisterObserver(IObserver observer);

    void notifyObservers();

    String getUpdate(IObserver observer);

}
