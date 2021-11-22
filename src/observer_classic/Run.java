package observer_classic;

public class Run {
    public static void main(String[] args) {
        Subject subject = new Subject();

        IObserver observer1 = new Observer("Observer #1");
        IObserver observer2 = new Observer("Observer #2");
        IObserver observer3 = new Observer("Observer #3");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        observer1.setSubject(subject);
        observer2.setSubject(subject);
        observer3.setSubject(subject);

        observer1.update();
        observer2.update();
        observer3.update();

        subject.sendMessage("New Message");

        subject.unregisterObserver(observer1);
        subject.unregisterObserver(observer2);
        subject.unregisterObserver(observer3);
    }
}
