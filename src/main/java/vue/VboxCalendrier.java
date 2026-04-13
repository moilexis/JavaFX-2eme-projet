package vue;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.*;

import java.util.List;


public class VboxCalendrier extends VBox {
    public VboxCalendrier() {
        super.setSpacing(3);

        Date today = new DateCalendrier();

        StackPane monthStackPane = new StackPane();

        ToggleGroup buttonGroup = new ToggleGroup();
        for (int idxMois = 1; idxMois <= 12 ; idxMois ++ ){
            CalendrierDuMois moisCalendrier = new CalendrierDuMois(idxMois, today.getAnnee());
            TilePane tilePaneMois = new TilePane();
            tilePaneMois.setHgap(15);

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
        HBox titre = new HBox();
        titre.setAlignment(Pos.CENTER);
        Label etiDuMois = new Label(ConstantesCalendrier.Mois.values() [today.getMois()-1]+ " " + today.getAnnee());
        etiDuMois.setId("etiquetteMoisCalendrier");
        this.getChildren().add(etiDuMois);
        this.getChildren().add(titre);

        List<Node> liste = monthStackPane.getChildren();
        while ((liste.get(liste.size()-1).getAccessibleText())!=(ConstantesCalendrier.Mois.values()[today.getMois()-1].toString() )){
            liste.get(0).toFront();
            etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + today.getAnnee());


        }
        //création des boutons
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Button Retourrapide = new Button("<<");
        Retourrapide.setOnAction(e-> {
            System.out.println("premier mois");
            while ((liste.get(liste.size()-1).getAccessibleText())!=(ConstantesCalendrier.Mois.values()[0].toString() )) {
                liste.get(liste.size()-1).toBack();
                etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + today.getAnnee());
            }
        });
        menu.getChildren().add(Retourrapide);

        Button retourButton = new Button("<");
        retourButton.setOnAction(e-> {
            System.out.println("Mois précédent");
            liste.get(liste.size()-1).toBack();
            etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + today.getAnnee());
        });
        menu.getChildren().add(retourButton);

        Button avanceButton = new Button(">");
        avanceButton.setOnAction(e-> {
            System.out.println("Mois suivant");
            liste.get(0).toFront();
            etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + today.getAnnee());
        });
        menu.getChildren().add(avanceButton);

        Button Avancerapide = new Button(">>");
        Avancerapide.setOnAction(e-> {
            System.out.println("dernier mois");
            while ((liste.get(liste.size()-1).getAccessibleText())!=(ConstantesCalendrier.Mois.values()[11].toString() )) {
                liste.get(0).toFront();
                etiDuMois.setText(liste.getLast().getAccessibleText()+ " " + today.getAnnee());
            }
        });
        menu.getChildren().add(Avancerapide);

        this.getChildren().add(monthStackPane);
        this.getChildren().add(menu);

    }

}
