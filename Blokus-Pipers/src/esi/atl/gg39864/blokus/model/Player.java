package esi.atl.gg39864.blokus.model;

/**
 * this is the class for create a List of four new Players or modified her
 * argument
 *
 * @author g39864
 */
public class Player {

    private String name;
    private final Score score;
    private final Stock stock;
    private boolean isBlocked;
    private final int number;
    private final Position positionStart;
    private Color color;
    private int nbTurnPlay;

    /**
     * this is the constructor with parameter of a Player
     *
     * @param name this is the name for create a player
     * @param stock is the new Stock of the Player
     * @param number this the number of this player
     * @param positionStart is the conner where the first Piece must be placed
     */
    public Player(String name, Stock stock, int number, Position positionStart, Color color) {
        this.name = name;
        this.score = new Score();
        this.stock = stock;
        this.number = number;
        this.isBlocked = false;
        this.positionStart = positionStart;
        this.color = color;
        this.nbTurnPlay = 0;
    }

    /**
     * this method return the number of the Player
     *
     * @return the number of the Player
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * this method return a name of a Player
     *
     * @return the name of a Player
     */
    public String getName() {
        return this.name;
    }

    /**
     * this method return the score of a Player
     *
     * @return the score of a player
     */
    public Score getScorePlayer() {
        return this.score;
    }

    /**
     * this method return a Stock of a Player
     *
     * @return the stock of a Player
     */
    public Stock getStock() {
        return this.stock;
    }

    /**
     * this method allows to return the position where must start the player
     *
     * @return the position where must start the player
     */
    public Position getStartPosition() {
        return this.positionStart;
    }

    /**
     * this method return the argument of the Player if he is blocked
     *
     * @return a boolean if the game of the player is finish
     */
    public boolean isBlocked() {
        return this.isBlocked;
    }

    /**
     * this method allows to change the argument is blocked of a Player at true
     */
    public void setIsBlocked() {
        this.isBlocked = true;
    }
    
    
    public int getNbTurnPlay(){
        return this.nbTurnPlay;
    }
    
    
    public void setNbTurnPlay(){
        this.nbTurnPlay++;
    }

    /**
     * this method allows to modify the name of the player
     *
     * @param name is the new name of the Player
     */
    public void setName(String name) {
        this.name = name;
    }
    
     public Color getColor(){
        return this.color;
    }

}
