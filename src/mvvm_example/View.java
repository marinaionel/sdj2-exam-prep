package mvvm_example;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

public class View {
    public JFXTextArea text;
    public JFXButton button;

    private ViewModel viewModel;

    public void init(ViewModel viewModel) {
        this.viewModel = viewModel;
        text.textProperty().bindBidirectional(viewModel.textProperty());
    }

    public void onButton() {
        viewModel.toUpperCase(text.getText());
    }
}
