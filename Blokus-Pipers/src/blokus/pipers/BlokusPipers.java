package blokus.pipers;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.PlayerManager;
import esi.atl.G39864.blokus.view.Console.Treatment;    

/**
 * this class allows to launch the game Blokus with the class Game and Treatment
 *
 * @author g39864
 */
public class BlokusPipers {

    /**
     * this class launch the game Blokus with two class, Game and Treatment
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        PlayerManager playerManager = new PlayerManager();
        Treatment treatment = new Treatment(game, playerManager);
        treatment.playGame(game);
    }
    
}
