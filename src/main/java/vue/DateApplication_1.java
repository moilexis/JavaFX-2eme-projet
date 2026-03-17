package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Calendar;

public class DateApplication_1 extends Application {
    public void start(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root,300,100);
        stage.setTitle("Application Dates");
        stage.setScene(scene);
        stage.show();

    }
}
