package vue;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.io.File;

public class VBoxRoot extends VBox {

    public VBoxRoot(int spacing) {
        super.setSpacing(spacing);
        DateCalendrier dateDuJour = new DateCalendrier();
        CalendrierDuMois ceMois = new CalendrierDuMois(dateDuJour.getMois(),dateDuJour.getAnnee());
        StackPane monthStackPane = new StackPane();

        Label etiDuMois = new Label(ConstantesCalendrier.Mois.values() [ceMois.getMois()-1]+ " " + ceMois.getAnnee());
        etiDuMois.setId("mois");
        VBox.setMargin(etiDuMois, new Insets(15));
        getChildren().add(etiDuMois);
        for (int i =1; i <= 12 ; i++){


            CalendrierDuMois idxMois = new CalendrierDuMois(i,dateDuJour.getAnnee());



            VBox dates = new VBox();
            dates.setSpacing(spacing);
            for (DateCalendrier date : idxMois.getDates()) {
                //System.out.println(date);
                if (date.getMois() == idxMois.getMois()) {
                    Label etiCetteDate = new Label(date.toString());
                    etiCetteDate.setId("jours");
                    dates.getChildren().add(etiCetteDate);
                    VBox.setMargin(etiCetteDate, new Insets(0, 0, 5, 20));
                }

            }

            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(dates);
            monthStackPane.getChildren().add(scrollPaneDates);

        }

        super.getChildren().add(monthStackPane);



    }


}
