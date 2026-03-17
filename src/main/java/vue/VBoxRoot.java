package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;

public class VBoxRoot extends VBox {

    public VBoxRoot(int spacing) {
        super.setSpacing(spacing);
        DateCalendrier dateDuJour = new DateCalendrier();
        Label aujourdhui = new Label(dateDuJour.toString());
        getChildren().add(aujourdhui);
        DateCalendrier dateDemain = dateDuJour.dateDuLendemain();
        Label demain = new Label(dateDemain.toString());
        getChildren().add(demain);
    }


}
