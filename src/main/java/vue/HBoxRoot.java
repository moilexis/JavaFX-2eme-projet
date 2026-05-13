package vue;

import controle.Controleur;
import javafx.scene.layout.HBox;
import modele.*;

public class HBoxRoot extends HBox {
    private static PlanningCollections planning ;
    private static Controleur controleur ;
    private static VboxCalendrier calendrier;
    private static GridPaneFomulaireReservation reservation;
    public HBoxRoot() {
        super(20);
        //instanciation des champs
        controleur = new Controleur();
        planning = new PlanningCollections();
        calendrier = new VboxCalendrier();
        reservation= new GridPaneFomulaireReservation();
        this.getChildren().add(calendrier);
        this.getChildren().add(reservation);
    }

    public static PlanningCollections getPlanning() {
        return planning;
    }
    public static VboxCalendrier getCalendrier(){
        return calendrier;
    }
    public static Controleur getControleur(){return controleur;}
    public static GridPaneFomulaireReservation getReservation() {
        return reservation;
    }
}
