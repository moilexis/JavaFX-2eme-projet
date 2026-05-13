package controle;

import exception.ExceptionPlanning;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.util.Pair;
import modele.*;
import vue.GridPaneFomulaireReservation;
import vue.HBoxRoot;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFomulaireReservation reservation = HBoxRoot.getReservation();

        //La source est un togglebutton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton click = (ToggleButton) event.getSource();
            DateCalendrier selDate = (DateCalendrier) click.getUserData();
            System.out.println(selDate);
            reservation.update(selDate);
            reservation.getNomResa().requestFocus();
        }
        //La sources est le bouton Enregistrer
        if (event.getSource() instanceof Button) {
            try {
                Pair<ComboBox<String>, ComboBox<String>> heuresDeb = reservation.getHeuresdebut();
                Pair<ComboBox<String>, ComboBox<String>> heuresFin = reservation.getHeuresfin();
                Horaire hor1 = new Horaire(heuresDeb.getKey().getSelectionModel().getSelectedIndex(), heuresDeb.getValue().getSelectionModel().getSelectedIndex()*15);
                Horaire hor2 = new Horaire(heuresFin.getKey().getSelectionModel().getSelectedIndex(), heuresFin.getValue().getSelectionModel().getSelectedIndex()*15);
                PlageHoraire plage = new PlageHoraire(hor1, hor2);
                System.out.println(plage);
                String intitule = reservation.getNomResa().getText();
                DateCalendrier date = reservation.getDate();
                Reservation resa = new Reservation(date, plage, intitule);
                planning.ajout(resa);
                System.out.println(planning);


            } catch (ExceptionPlanning e) {
                throw new RuntimeException(e);
            }
            reservation.getNomResa().requestFocus();
        }
    }
}
