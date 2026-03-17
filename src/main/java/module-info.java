module com.example.deuxieme_projet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.deuxieme_projet to javafx.fxml;
    exports com.example.deuxieme_projet;
    exports vue;
}