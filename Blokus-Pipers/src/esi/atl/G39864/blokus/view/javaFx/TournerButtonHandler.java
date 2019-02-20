package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * this class allows to actionned the action of turn piece when the button 
 * tourner of the game is clicked
 *
 * @author Chris
 */
public class TournerButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    /**
     * this method allows to action the tournerbuttonhandler when the button is
     * pressed
     *
     * @param game is the parameter necessary to use this button
     */
    public TournerButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this method allows to action the method turn the piece selected by 90
     * degrees in the clockwise direction
     *
     * @param event is the even when the button is clicked 
     */
    @Override
    public void handle(ActionEvent event) {
        game.tournePiece();
    }
}
