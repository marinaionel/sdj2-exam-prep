package observer_classic;

public interface IObserver {

    void update();

    void setSubject(ISubject subject);
}
