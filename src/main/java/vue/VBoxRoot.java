package vue;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

public class VBoxRoot extends VBox {

    public VBoxRoot(int spacing) {
        super.setSpacing(spacing);

        DateCalendrier dateDuJour = new DateCalendrier();
        CalendrierDuMois ceMois = new CalendrierDuMois(dateDuJour.getMois(),dateDuJour.getAnnee());
        Label etiCeMois = new Label("#########"+ConstantesCalendrier.Mois.values() [ceMois.getMois()-1]+ " " + ceMois.getAnnee()+"#########");
        getChildren().add(etiCeMois);

        VBox dates = new VBox();
        dates.setSpacing(spacing);
        for (DateCalendrier date : ceMois.getDates()) {
            //System.out.println(date);
            if ( date.getMois() == ceMois.getMois()) {
                Label etiCetteDate = new Label(date.toString());
                dates.getChildren().add(etiCetteDate);
            }
        }
        ScrollPane scrollPaneDates = new ScrollPane();
        scrollPaneDates.setContent(dates);
        super.getChildren().add(scrollPaneDates);
    }


}
