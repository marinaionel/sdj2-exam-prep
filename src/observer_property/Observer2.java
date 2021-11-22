package observer_property;

import java.beans.PropertyChangeEvent;

public class Observer2 implements Observer {
    public Observer2(PropertyChangeSubject subject) {
        subject.addPropertyChangeListener(this::update);
    }
    @Override
    public void update(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("more than or equal to 5")){
            System.out.println("2 :: The number " + event.getNewValue() + " is more than or equal to 5");
        }
    }
}
