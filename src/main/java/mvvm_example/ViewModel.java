package mvvm_example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private Model model;
    private StringProperty text;

    public ViewModel(Model model) {
        this.model = model;
        text = new SimpleStringProperty();
    }

    public void toUpperCase(String text) {
        this.text.setValue(model.toUpperCase(text));
    }

    public StringProperty textProperty() {
        return text;
    }
}
