package observer_property;

import java.beans.PropertyChangeEvent;

public interface Observer {
    void update(PropertyChangeEvent event);
}
