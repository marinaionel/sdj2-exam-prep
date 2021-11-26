package observer_property;

import java.beans.PropertyChangeEvent;

public class Observer1 implements Observer {
    public Observer1(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener(this::update);
    }

    @Override
    public void update(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("less than 5")) {
            System.out.println("1 :: The number " + event.getNewValue() + " is less than 5.");
        }
    }
}
