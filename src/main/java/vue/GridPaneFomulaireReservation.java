package vue;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;

import java.util.ArrayList;


public class GridPaneFomulaireReservation extends GridPane {
    public GridPaneFomulaireReservation() {
        super();
        this.getStyleClass().add("FomulaireResa");
        setGridLinesVisible(true);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(20));

        DateCalendrier today = new DateCalendrier();
        Label lblDate = new Label(today.toString());
        add(lblDate, 2, 0, 2, 1);
        //SAISIE DU COURS
        Label lblCours = new Label("_cours");
        lblCours.setMnemonicParsing(true);
        add(lblCours, 1, 1, 1, 1);
        TextField tfCours = new TextField();
        lblCours.setLabelFor(tfCours);
        add(tfCours, 2, 1, 3, 1);


        //NIVEAU DU COURS
        Label niveau = new Label("Niveau");
        add(niveau, 1, 2, 1, 1);
        ToggleGroup tgNiveau = new ToggleGroup();
        RadioButton btnDeb = new RadioButton("_débutant");
        btnDeb.setMnemonicParsing(true);
        btnDeb.setSelected(true);
        btnDeb.setToggleGroup(tgNiveau);
        add(btnDeb, 2, 2, 2, 1);
        RadioButton btnMoy = new RadioButton("_moyen");
        btnMoy.setMnemonicParsing(true);
        add(btnMoy, 4, 2, 2, 1);
        btnMoy.setToggleGroup(tgNiveau);
        RadioButton btnAvc = new RadioButton("_avancé");
        btnAvc.setToggleGroup(tgNiveau);
        btnAvc.setMnemonicParsing(true);
        add(btnAvc, 2, 3, 2, 1);
        RadioButton btnExp = new RadioButton("_expert");
        btnExp.setToggleGroup(tgNiveau);
        btnExp.setMnemonicParsing(true);
        add(btnExp, 4, 3, 2, 1);

        //HORAIRES
        Label Horaire =  new Label("horaire");
        add(Horaire, 1, 4, 1, 1);
        Label hor1 = new Label("de");
        add(hor1, 2, 4, 1, 1);
        Label heure1 = new Label("h");
        add(heure1, 4, 4, 1, 1);
        Label min1 = new Label("min");
        add(min1, 6, 4, 1, 1);

        Label hor2 = new Label("à");
        add(hor2, 2,5 , 1, 1);
        Label heure2 = new Label("h");
        add(heure2, 4,5, 1, 1);
        Label min2 = new Label("min");
        add(min2, 6, 5, 1, 1);
    }
}
