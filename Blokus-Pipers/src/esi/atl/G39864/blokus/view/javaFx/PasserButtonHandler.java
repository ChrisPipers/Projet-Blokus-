package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * this class allows to actionned the action of passed the turn of the player
 * when the button passed of the game is clicked
 *
 * @author chris home
 */
public class PasserButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    /**
     * this method allows to action the passed at the next player when the
     * button is pressed
     *
     * @param game is the parameter necessary to use this button
     */
    public PasserButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this method allows to use the method nextplayer when the button passer is
     * clicked
     *
     * @param event is the even when the button is clicked
     */
    @Override
    public void handle(ActionEvent event) {
        game.nextPlayer();
    }

}
