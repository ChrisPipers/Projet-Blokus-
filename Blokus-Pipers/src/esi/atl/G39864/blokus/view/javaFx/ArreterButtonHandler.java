package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * this method allows to make the action stop the game for the current player
 * where the button arreter is clicked
 *
 * @author chris home
 */
public class ArreterButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    /**
     * this method allows to make the action stop when the button arreter is
     * clicked
     *
     * @param game is the parameter necessary for make the action stop
     */
    public ArreterButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this method allows to make the action for blocked the player when he
     * click on the button arreter
     *
     * @param event is the event when the player click on the button arreter
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println(game.getCurrentPlayer().isBlocked() + "" + game.getCurrentPlayer().getNumber());
        game.setIsBlocked();
        System.out.println(game.getCurrentPlayer().isBlocked() + "" + game.getCurrentPlayer().getNumber());

    }
}
