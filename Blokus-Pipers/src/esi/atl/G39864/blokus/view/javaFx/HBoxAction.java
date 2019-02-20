package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

/**
 * this class allows to build a HBox with the four action possible, Nouvelle
 * Partie, Passer, J'arrête and Tourner
 *
 * @author Chris
 */
public class HBoxAction extends HBox {

    private final Button butPass;
    private final Button butStop;
    private final Button butTurned;
    private final Button butMirror;
    private final Button butNewPart;
    private HBoxCentrale hBoxCentrale;

    /**
     * this method build a HBox with the four action possible, Nouvelle Partie,
     * Passer, J'arrête and Tourner
     *
     * @param game is the game necessary for make each action of each button
     */
    public HBoxAction(Game game, HBoxCentrale hBoxCentrale) {
        butNewPart = new Button("Nouvelle Partie");
        NouvellePartieButtonHandler nouvellePartieButtonHandler = new NouvellePartieButtonHandler(game, this, hBoxCentrale );
        butNewPart.addEventHandler(ActionEvent.ACTION, nouvellePartieButtonHandler);
        butNewPart.setAlignment(Pos.BOTTOM_CENTER);

        butPass = new Button("Passer");
        PasserButtonHandler paserButtonHandler = new PasserButtonHandler(game);
        butPass.addEventHandler(ActionEvent.ACTION, paserButtonHandler);
        butPass.setAlignment(Pos.BOTTOM_CENTER);
        butPass.setDisable(true);

        butStop = new Button("j'arrête");
        ArreterButtonHandler arreterButtonHandler = new ArreterButtonHandler(game);
        butStop.addEventHandler(ActionEvent.ACTION, arreterButtonHandler);
        butStop.setAlignment(Pos.BOTTOM_CENTER);
        butStop.setDisable(true);

        butTurned = new Button("Tourner");
        TournerButtonHandler tournerButtonHandler = new TournerButtonHandler(game);
        butTurned.addEventHandler(ActionEvent.ACTION, tournerButtonHandler);
        butTurned.setAlignment(Pos.BOTTOM_CENTER);
        butTurned.setDisable(true);

        butMirror = new Button("Mirrors");
        MirrorsButtonHandler mirrosButtonHandler = new MirrorsButtonHandler(game);
        butMirror.addEventHandler(ActionEvent.ACTION, mirrosButtonHandler);
        butMirror.setDisable(true);

        this.getChildren().addAll(butNewPart, butPass, butStop, butTurned, butMirror);
    }

    /**
     * this method allows to change the visibility the button where the button
     * nouvelle partie is clicked
     */
    public void setButtonsVissibles() {
        this.butPass.setDisable(false);
        this.butStop.setDisable(false);
        this.butTurned.setDisable(false);
        this.butMirror.setDisable(false);
        this.butNewPart.setDisable(true);
    }

}
