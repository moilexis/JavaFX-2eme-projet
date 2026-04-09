package vue;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import modele.*;


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
            for (DateCalendrier date : moisCalendrier.getDates()){
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(buttonGroup);
                tilePaneMois.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                            public void handle (ActionEvent actionEvent) {
                        System.out.println(boutonDate.getUserData().toString());
                    }
                });
                if (date.getMois() != moisCalendrier.getMois()){
                    boutonDate.setId("horsMois");
                }
                if (date.compareTo(today) == 0){
                    boutonDate.setId("today");
                }
            }
            tilePaneMois.setAccessibleText(ConstantesCalendrier.Mois.values()[idxMois-1].toString());
            monthStackPane.getChildren().add(tilePaneMois);
        }
    }

}
