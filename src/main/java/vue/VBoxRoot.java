package vue;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.io.File;
import java.util.List;

public class VBoxRoot extends VBox {

    public VBoxRoot(int spacing) {
        super.setSpacing(spacing);
        HBox menu = new HBox(10);

        DateCalendrier dateDuJour = new DateCalendrier();
        CalendrierDuMois ceMois = new CalendrierDuMois(dateDuJour.getMois(),dateDuJour.getAnnee());

        StackPane monthStackPane = new StackPane();

        Label etiDuMois = new Label(ConstantesCalendrier.Mois.values() [ceMois.getMois()-1]+ " " + ceMois.getAnnee());
        etiDuMois.setId("mois");
        HBox.setMargin(etiDuMois, new Insets(15));
        menu.getChildren().add(etiDuMois);




        this.getChildren().add(menu);
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
            scrollPaneDates.setAccessibleText(String.valueOf(i));
            monthStackPane.getChildren().add(scrollPaneDates);

        }
        //création des boutons
        /*
        Button retourButton = new Button("<");
        retourButton.setOnAction(e-> {
            if (ceMois.getMois()>1) {
                System.out.println("Mois précédent");
                ceMois = new CalendrierDuMois(ceMois.getMois() - 1, ceMois.getAnnee());
                etiDuMois.setText(ConstantesCalendrier.Mois.values()[ceMois.getMois() - 1] + " " + ceMois.getAnnee());
            }
            else {System.out.println("retour impossible");
            }
        });
        menu.getChildren().add(retourButton);
        Button avanceButton = new Button(">");
        avanceButton.setOnAction(e-> {
            if (ceMois.getMois()<12) {
                System.out.println("Mois suivant");
                ceMois = new CalendrierDuMois(ceMois.getMois() + 1, ceMois.getAnnee());
                etiDuMois.setText(ConstantesCalendrier.Mois.values()[ceMois.getMois() - 1] + " " + ceMois.getAnnee());
            }
            else {System.out.println("avance impossible");
            }
        });

        menu.getChildren().add(avanceButton);

         */
        List<Node> liste = monthStackPane.getChildren();
        while (monthStackPane.getAccessibleText().compareTo(liste.get(liste.size()-1).getAccessibleText()) != 0 ) {
            liste.get(0).toFront();
        }
        //monthStackPane.getChildren().get(ceMois.getMois()-1).toFront();
        super.getChildren().add(monthStackPane);



    }


}
