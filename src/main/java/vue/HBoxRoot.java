package vue;

import javafx.scene.layout.HBox;
import modele.PlanningCollections;

public class HBoxRoot extends HBox {
    private static PlanningCollections planning ;
    private static Object controleur ;
    private static VboxCalendrier calendrier;
    private static GridPaneFomulaireReservation reservation;
    public HBoxRoot() {
        super(20);
        //ijnstanciation des champs
        planning = new PlanningCollections();
        calendrier = new VboxCalendrier();
        reservation= new GridPaneFomulaireReservation();
        this.getChildren().add(calendrier);
        this.getChildren().add(reservation);
    }
}
