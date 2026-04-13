package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class DateApplication_1 extends Application {
    public void start(Stage stage) {

        HBox root = new HBoxRoot();
        Scene scene = new Scene(root,800,500);
        stage.setTitle("Application Dates");
        stage.setScene(scene);
        File css = new File("css"+File.separator+"styles.css");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();

    }
}
