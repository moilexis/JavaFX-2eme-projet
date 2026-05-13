package vue;

import controle.Controleur;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import modele.DateCalendrier;
import modele.Horaire;
import modele.PlageHoraire;

import java.util.ArrayList;



public class GridPaneFomulaireReservation extends GridPane {
    private DateCalendrier dateDuJour;
    private Label dateLabel;
    private Pair<ComboBox<String>, ComboBox<String>> heuresDebut;
    private Pair<ComboBox<String>, ComboBox<String>> heuresFin;
    private TextField nomResa;
    public GridPaneFomulaireReservation() {
        super();
        this.getStyleClass().add("FomulaireResa");
        //setGridLinesVisible(true);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(20));
        DateCalendrier today = new DateCalendrier();
        dateDuJour = today;
        dateLabel = new Label(dateDuJour.toString());
        add(dateLabel, 2, 0, 4, 1);
        //SAISIE DU COURS
        Label lblCours = new Label("_cours");
        lblCours.setMnemonicParsing(true);
        add(lblCours, 1, 1, 1, 1);
        TextField tfCours = new TextField();
        tfCours.setPromptText("entrez le nom du cours");
        nomResa = tfCours;
        Platform.runLater(()-> tfCours.requestFocus());
        lblCours.setLabelFor(tfCours);
        add(tfCours, 2, 1, 4, 1);


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
        RadioButton btnExp = new RadioButton("e_xpert");
        btnExp.setToggleGroup(tgNiveau);
        btnExp.setMnemonicParsing(true);
        add(btnExp, 4, 3, 2, 1);

        //HORAIRES
        String[] HEURES = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","23","24"};
        String[] MINUTES = {"0","15","30","45"};
        Label Horaire =  new Label("horaire");
        add(Horaire, 1, 4, 1, 1);
        Label hor1 = new Label("de");
        add(hor1, 2, 4, 1, 1);

        ComboBox<String> cbHeure1 = peupleComboBox(HEURES);
        cbHeure1.getSelectionModel().select(7);
        add(cbHeure1,3, 4, 1, 1);
        Label heure1 = new Label("h");
        add(heure1, 4, 4, 1, 1);

        ComboBox<String> cbMin1 = peupleComboBox(MINUTES);
        cbMin1.getSelectionModel().select(0);
        add(cbMin1, 5, 4, 1, 1);
        Label min1 = new Label("min");
        add(min1, 6, 4, 1, 1);

        heuresDebut = new Pair<>(cbHeure1,cbMin1);

        Label hor2 = new Label("à");
        add(hor2, 2,5 , 1, 1);
        ComboBox<String> cbHeure2 = peupleComboBox(HEURES);
        cbHeure2.getSelectionModel().select(8);
        add(cbHeure2, 3, 5, 1, 1);
        Label heure2 = new Label("h");
        add(heure2, 4,5, 1, 1);

        ComboBox<String> cbMin2 = peupleComboBox(MINUTES);
        cbMin2.getSelectionModel().select(0);
        add(cbMin2, 5, 5, 1, 1);
        Label min2 = new Label("min");
        add(min2, 6, 5, 1, 1);

        heuresFin = new Pair<>(cbHeure2,cbMin2);

        //VALIDATION
        Button annuler = new Button("_Annuler");
        annuler.setMnemonicParsing(true);
        add(annuler, 3, 6, 2, 1);

        annuler.setOnAction(e -> {
            //reset du formulaire
            tfCours.setText("");
            cbHeure1.getSelectionModel().select(7);
            cbMin1.getSelectionModel().select(0);
            cbHeure2.getSelectionModel().select(8);
            cbMin2.getSelectionModel().select(0);
            //refocus sur le textfield
            tfCours.requestFocus();
        });
        Button enregistrer = new Button("_Enregistrer");
        enregistrer.setMnemonicParsing(true);
        enregistrer.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());
        add(enregistrer, 5, 6, 2, 1);


    }
    public DateCalendrier getDate() {
        return dateDuJour;
    }
    public Label getDateLabel(){
        return dateLabel;
    }
    private ComboBox<String> peupleComboBox(String[] strings){
        ComboBox<String> cb = new ComboBox<>();
        for (String s : strings){
            cb.getItems().add(s);
        }
        return cb;
    }

    public Pair<ComboBox<String>, ComboBox<String>> getHeuresdebut() {
        return heuresDebut;
    }
    public Pair<ComboBox<String>, ComboBox<String>> getHeuresfin() {
        return heuresFin;
    }
    public TextField getNomResa() {
        return nomResa;
    }

    public void update(DateCalendrier dateSel) {
        dateDuJour = dateSel;
        dateLabel.setText(dateDuJour.toString());
    }
}
