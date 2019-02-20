package esi.atl.gg39864.blokus.model;

import esi.atl.G39864.blokus.Model.IO.ReadFile;
import java.util.ArrayList;
import java.util.List;

/**
 * this class allows to create a List of four Player and manager it
 *
 * @author chris home
 */
public class PlayerManager {

    private final List<Player> listPlayer = new ArrayList<>();
    private final List<Stock> listStock;
    private final ReadFile read;
    private Player currentPlayer;
    private Color color;

    /**
     * this is the constructor of the PlayerManager class, he create a List of
     * four Player
     */
    public PlayerManager() {
        read = new ReadFile();
        this.listStock = read.getListStock();
        for (int i = 0; i < 4; i++) {
            Stock stock = listStock.get(i);
            color = colorPlayer(3-i);
            Position positionStart = getPositionStart(i);
            Player player = new Player("Joueur "+i , stock, i, positionStart, color);
            listPlayer.add(player);
            
        }
        this.currentPlayer = listPlayer.get(0);
    }

    /**
     * this method allows to give the conner attribute of a Player according of
     * her number
     *
     * @param i is the number of the player in the list for know what conner
     * attribute to he
     * @return the position where the player must be started
     */
    public Position getPositionStart(int i) {
        Position positionStart = null;
        switch (i) {
            case 0:
                positionStart = new Position(0, 0);
                break;
            case 1:
                positionStart = new Position(0, 19);
                break;
            case 2:
                positionStart = new Position(19, 0);
                break;
            case 3:
                positionStart = new Position(19, 19);
                break;
        }
        return positionStart;
    }

    
    public Color colorPlayer(int numCol){
        Color [] tabColor = new Color[4];
        tabColor = Color.values();
        for (int i = 4; i < 4; i++) {
            System.out.println(tabColor[i]);
        }
        return tabColor[numCol];
    }
    
    
    
    /**
     * this method allows to know who is the current player
     *
     * @return the current player of the game
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * this method allows to passed of the next player with the old current
     * player
     *
     * @param player is the old current player
     * @return the new current player
     */
    public Player nextPlayer(Player player) {
        this.currentPlayer = listPlayer.get((player.getNumber() + 1) % 4);
        return this.currentPlayer;
    }

    /**
     * this method allows to return the list of the player
     *
     * @return the list of the player
     */
    public List<Player> getListPlayers() {
        return this.listPlayer;
    }
          
    public Player getPlayerWinner(){
        Player playerWinner = listPlayer.get(0);
        for (Player player : listPlayer) {
            if(player.getScorePlayer().getScore() > playerWinner.getScorePlayer().getScore()){
                    playerWinner = player;
            }
        }
        return playerWinner;
    }

}
