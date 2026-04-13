package vue;

import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    public HBoxRoot() {
        super(20);
        VboxCalendrier vboxCalendrier = new VboxCalendrier();
        GridPaneFomulaireReservation grid = new GridPaneFomulaireReservation();
        this.getChildren().add(vboxCalendrier);
        this.getChildren().add(grid);
    }
}
