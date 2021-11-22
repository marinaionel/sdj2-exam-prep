package mvvm_example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        try {
            loader.setLocation(Paths.get("src\\mvvm_example\\file.fxml").toUri().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        View view = loader.getController();
        Model model = new Model();
        ViewModel viewModel = new ViewModel(model);
        view.init(viewModel);
        stage.setTitle("To uppercase");
        assert root != null;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
