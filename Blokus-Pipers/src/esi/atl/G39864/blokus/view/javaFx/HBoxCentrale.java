package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * this class allows to build the HBox central with the VBox of left and the
 * GridPane of right
 *
 * @author Chris
 */
public class HBoxCentrale extends HBox {

    private final GridPaneBoard gridBoard;
    private Game game ;

    /**
     * this method build the HBox central with the VBox of left and the GridPane
     * of right
     *
     * @param game is the Game who based the display
     */
    public HBoxCentrale(Game game) {
        this.game = game;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20.0);
        VBoxLeft vBoxLeft = new VBoxLeft(game);
        vBoxLeft.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().add(vBoxLeft);
        gridBoard = new GridPaneBoard(game);
        gridBoard.setAlignment(Pos.BASELINE_RIGHT);
        this.getChildren().add(gridBoard);
        this.setOpacity(0.50);
        this.setDisable(true);
    }

    public void setDisplayHBoxCentrale(){
        this.setOpacity(1.0);
        this.setDisable(false);
    }
    
//    public void setUnDisplayHBoxCentrale(){
//        this.setOpacity(0.5);
//        this.setDisable(true);
//    }

 
}
