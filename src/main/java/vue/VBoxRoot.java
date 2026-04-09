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
            String moisActuel = ConstantesCalendrier.Mois.values()[i-1].toString();

            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(dates);
            scrollPaneDates.setAccessibleText(moisActuel);
            monthStackPane.getChildren().add(scrollPaneDates);

        }



        List<Node> liste = monthStackPane.getChildren();
        while ((liste.get(liste.size()-1).getAccessibleText())!=(ConstantesCalendrier.Mois.values()[dateDuJour.getMois()-1].toString() )){
            liste.get(0).toFront();
            etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + ceMois.getAnnee());


        }
        //création des boutons

        Button Retourrapide = new Button("<<");
        Retourrapide.setOnAction(e-> {
            System.out.println("premier mois");
            while ((liste.get(liste.size()-1).getAccessibleText())!=(ConstantesCalendrier.Mois.values()[0].toString() )) {
                liste.get(liste.size()-1).toBack();
                etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + ceMois.getAnnee());
            }
        });
        menu.getChildren().add(Retourrapide);

        Button retourButton = new Button("<");
        retourButton.setOnAction(e-> {
            System.out.println("Mois précédent");
            liste.get(liste.size()-1).toBack();
            etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + ceMois.getAnnee());
        });
        menu.getChildren().add(retourButton);

        Button avanceButton = new Button(">");
        avanceButton.setOnAction(e-> {
                System.out.println("Mois suivant");
                liste.get(0).toFront();
            etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + ceMois.getAnnee());
        });
        menu.getChildren().add(avanceButton);

        Button Avancerapide = new Button(">>");
        Avancerapide.setOnAction(e-> {
            System.out.println("dernier mois");
            while ((liste.get(liste.size()-1).getAccessibleText())!=(ConstantesCalendrier.Mois.values()[11].toString() )) {
                liste.get(0).toFront();
                etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + ceMois.getAnnee());
            }
        });
        menu.getChildren().add(Avancerapide);

        super.getChildren().add(monthStackPane);



    }


}
