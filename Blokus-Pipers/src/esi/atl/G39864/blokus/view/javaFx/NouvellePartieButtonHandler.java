package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * this class allows to make the action nouvelle partie when the button nouvelle
 * partie is clicked
 *
 * @author chris home
 */
public class NouvellePartieButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;
    private HBoxAction hBoxAction;
    private HBoxCentrale hBoxCentrale;
    /**
     * this method allows to creat a new part when the button nouvelle partie is
     * clicked
     *
     * @param game is the game where restart it 
     */
    public NouvellePartieButtonHandler(Game game, HBoxAction hBoxAction, HBoxCentrale hBoxCentrale ) {
        this.game = game;
        this.hBoxAction = hBoxAction;
        this.hBoxCentrale = hBoxCentrale;
    }

    /**
     * this method allows to change the visibility of the other button visible 
     * when the new part is launch
     * 
     * @param event is the event when the button is clicked
     */
    @Override
    public void handle(ActionEvent event) {
        this.hBoxCentrale.setDisplayHBoxCentrale();
        this.hBoxAction.setButtonsVissibles();
    }
    

}
