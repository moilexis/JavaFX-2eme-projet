package vue;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import modele.*;

import java.util.Calendar;

public class VboxRootCalendrier {
    public VboxRootCalendrier() {
        Date today = new DateCalendrier();

        StackPane monthStackPane = new StackPane();

        ToggleGroup buttonGroup = new ToggleGroup();
        for (int idxMois = 1; idxMois <= 12 ; idxMois ++ ){
            CalendrierDuMois moisCalendrier = new CalendrierDuMois(idxMois, today.getAnnee());
            TilePane tilePaneMois = new TilePane();

            tilePaneMois.setPrefColumns(7);

            tilePaneMois.setPrefRows(moisCalendrier.getDates().size() /7 + 1);

            tilePaneMois.setId("opaque");

            for (ConstantesCalendrier.Jours jour : ConstantesCalendrier.Jours.values()){
                Label jourLabel = new Label(jour.toString().substring(0,2));
                tilePaneMois.getChildren().add(jourLabel);
            }
        }
    }

}
