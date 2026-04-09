module com.example.deuxieme_projet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.graphics;
    //    requires com.example.deuxieme_projet;


    opens com.example.deuxieme_projet to javafx.fxml;
    exports com.example.deuxieme_projet;
    exports vue;
}