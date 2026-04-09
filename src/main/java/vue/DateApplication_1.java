package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Calendar;

public class DateApplication_1 extends Application {
    public void start(Stage stage) {

        VBox root = new VboxRootCalendrier();
        Scene scene = new Scene(root,300,100);
        stage.setTitle("Application Dates");
        stage.setScene(scene);
        File css = new File("css"+File.separator+"styles.css");
        scene.getStylesheets().add(css.toURI().toString());
        stage.show();

    }
}
