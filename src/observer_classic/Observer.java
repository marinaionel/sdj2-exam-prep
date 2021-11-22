package observer_classic;

public class Observer implements IObserver {

    private String name;
    private ISubject subject;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String text = subject.getUpdate(this);
        System.out.println(text == null ? name + ": no new message" : name + ": new message: \"" + text + "\"");
    }

    @Override
    public void setSubject(ISubject subject) {
        this.subject = subject;
    }
}
