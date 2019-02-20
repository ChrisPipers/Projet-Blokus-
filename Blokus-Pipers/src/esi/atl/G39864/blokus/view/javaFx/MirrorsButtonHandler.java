package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Position;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * this class allows to make the action mirrors on a piece when the button
 * mirror is pressed
 *
 * @author chris home
 */
public class MirrorsButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;
    List<Position> listPosTurn;

    /**
     * this class allows to make a mirror effect on the piece
     *
     * @param game is the parameter necessary to use this button
     */
    public MirrorsButtonHandler(Game game) {
        this.game = game;
    }

    /**
     * this class allows to make the action mirror effect on the piece selected
     * in the game
     *
     * @param event is the event when the button mirror is clicked
     */
    @Override
    public void handle(ActionEvent event) {
        game.mirrorPiece();
    }
}
