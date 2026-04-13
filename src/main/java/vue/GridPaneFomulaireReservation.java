package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;


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
        Label lblCours = new Label("_Cours");
        TextField tfCours = new TextField();
        Label niveau = new Label("Niveau");

        ToggleGroup tgNiveau = new ToggleGroup();
        ToggleButton btnDeb = new ToggleButton();
        btnDeb.setSelected(true);
        btnDeb.setToggleGroup(tgNiveau);
        ToggleButton btnMoy = new ToggleButton();
        btnMoy.setToggleGroup(tgNiveau);
        ToggleButton btnAvc = new ToggleButton();
        btnAvc.setToggleGroup(tgNiveau);
        ToggleButton btnExp = new ToggleButton();
        btnExp.setToggleGroup(tgNiveau);


        Label lbldeb =  new Label("_Debut");
        Label lblfin = new Label("_Date");
    }
}
