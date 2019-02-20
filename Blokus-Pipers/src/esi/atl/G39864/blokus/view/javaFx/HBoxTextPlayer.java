package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Player;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * this class allows to build hboxTextplayer container the different information
 * of the player
 *
 * @author chris home
 */
public class HBoxTextPlayer extends HBox {

    HBox hboxInfoPlayer;

    /**
     * this method build a text zone with the status of a Player
     *
     * @param player is the Player to build a text with her parameter
     * @param game is the parameter for know the current player of the game
     */
    public HBoxTextPlayer(Player player, Game game) {
        String bloked;
        if (!player.isBlocked()) {
            bloked = "Ok";
        } else {
            bloked = "Non Ok";
        }
        Text textNumPlayer = new Text("Joueur " + player.getNumber());
        Text textScorePlayer = new Text("Score :");
        Text textScore = new Text(player.getScorePlayer().getScore() + "");
        Text textBloked = new Text(bloked);
        this.getChildren().addAll(textNumPlayer, textScorePlayer, textScore, textBloked);

        if (player.getNumber() == game.getCurrentPlayer().getNumber()) {
            this.setStyle("-fx-background-color: #00FFFFAA;");
        }
        this.setSpacing(40.0);
    }
}
