package controle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.PlanningCollections;
import vue.GridPaneFomulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFomulaireReservation reservation = HBoxRoot.getReservation();

        //La source est un togglebutton du calendrier
        if (event.getSource() instanceof ToggleButton){
            //a completer
        }
        //La sources est le bouton Enregistrer
        if (event.getSource() instanceof Button){
            // a completer
        }
    }
}
