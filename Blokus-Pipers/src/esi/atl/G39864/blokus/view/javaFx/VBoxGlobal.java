package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * this class allows to build the VBox global with all Layout of the game,
 * MenuBar, HBox central and HBox with the action
 *
 * @author Chris
 */
public class VBoxGlobal extends VBox {
    
    private final HBoxAction hboxAct;
    private final HBoxCentrale hBoxCent;
    
    /**
     * this method build the VBox global with all Layout of the game, MenuBar,
     * HBox central and HBox with the action
     * @param game is the Game for build the display
     */
    public VBoxGlobal(Game game) {
        this.setSpacing(20.0);
        BarMenu menu = new BarMenu(game);
        hBoxCent = new HBoxCentrale(game);
        hboxAct = new HBoxAction(game, hBoxCent);
        hboxAct.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(menu,hBoxCent, hboxAct);
        
       
    
    }
    
    
 
    
}
