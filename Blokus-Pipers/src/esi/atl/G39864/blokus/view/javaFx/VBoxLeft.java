package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Player;
import esi.atl.gg39864.blokus.model.Stock;
import javafx.scene.layout.VBox;
import esi.atl.G39864.blokus.mvc1.Observer;

/**
 * this class allows to build the left VBox with the four VBox who contain the
 * four Stock of each Player
 *
 * @author Chris
 */
public class VBoxLeft extends VBox implements Observer {

    private final Game game;
   
    /**
     * this method build the left VBox with the four VBox who contain the four
     * Stock of each Player
     *
     * @param game is the parameter necessary for build the VBoxLeft
     */
    public VBoxLeft(Game game) {
        this.game = game;
        for (int i = 0; i < 4; i++) {
            Player player = game.getListPlayer().get(i);
            Stock stock = player.getStock();
            HBoxTextPlayer hBoxTextPlayer = new HBoxTextPlayer(player, game);
            VBoxStock vBoxStock = new VBoxStock(game, stock, i);
            
            this.getChildren().addAll(hBoxTextPlayer, vBoxStock);
            
        }
        this.setSpacing(8.0);
        game.addObserver(this);
    }

    /**
     * this method build a GridPane with the Stock of a Player and with
     * represent each Piece
     */
    public void refreshStock() {
        this.getChildren().clear();
        for (int i = 0; i < 4; i++) {
            Player player = game.getListPlayer().get(i);
            Stock stock = player.getStock();
            HBoxTextPlayer hb = new HBoxTextPlayer(player, game);
            VBoxStock v = new VBoxStock(game, stock, i);
            this.getChildren().addAll(hb, v);
        }
    }

    /**
     * this method allows to update the vboxleft when there is one of change
     */
    @Override
    public void update() {
        refreshStock();
    }

}
