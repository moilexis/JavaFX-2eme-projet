package vue;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
        Label etiCeMois = new Label("#########"+ConstantesCalendrier.Mois.values() [ceMois.getMois()-1]+ " " + ceMois.getAnnee()+"#########");
        etiCeMois.setId("mois");
        getChildren().add(etiCeMois);

        VBox dates = new VBox();
        dates.setSpacing(spacing);
        for (DateCalendrier date : ceMois.getDates()) {
            //System.out.println(date);
            if ( date.getMois() == ceMois.getMois()) {
                Label etiCetteDate = new Label(date.toString());
                etiCetteDate.setId("jours");
                dates.getChildren().add(etiCetteDate);
                VBox.setMargin(etiCetteDate,new Insets(5,0,5,20));
            }
        }
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(dates);
        super.getChildren().add(scrollPaneDates);

    }


}
