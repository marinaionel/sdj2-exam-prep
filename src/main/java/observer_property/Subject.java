package observer_property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Subject implements PropertyChangeSubject {
    private PropertyChangeSupport action = new PropertyChangeSupport(this);

    public void start() {
        for (int i = 0; i < 10; i++) {
            int number = new Random().nextInt(11);
            System.out.println("The number is: " + number);
            if (number < 5) {
                action.firePropertyChange("less than 5", 0, number);
            } else {
                action.firePropertyChange("more than or equal to 5", 0, number);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\nThe subject stops!");
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        action.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        action.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        action.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        action.removePropertyChangeListener(listener);
    }
}
