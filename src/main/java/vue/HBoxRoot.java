package vue;

import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    public HBoxRoot() {
        super();
        VboxCalendrier vboxCalendrier = new VboxCalendrier();
        this.setSpacing(10);
        this.getChildren().add(vboxCalendrier);
    }
}
