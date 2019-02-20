package esi.atl.gg39864.blokus.model;

import esi.atl.G39864.blokus.ia.model.Context;
import java.util.ArrayList;
import java.util.List;
import esi.atl.G39864.blokus.mvc1.Observer;
import esi.atl.G39864.blokus.mvc1.Subject;
import esi.atl.G39864.blokus.view.javaFx.HBoxAction;
import esi.atl.G39864.blokus.view.javaFx.HBoxCentrale;
import esi.atl.G39864.blokus.view.javaFx.VBoxGlobal;
import javafx.scene.control.Alert;

/**
 * this method allows to play the game make the all of treatment of the game.
 *
 * @author Chris
 */
public final class Game implements Subject {

    private final List<Observer> listObserver;            // pas de new car Observer est abstract
    private final Board board;
    private List<Player> listPlayer = new ArrayList<>();
    private Player currentPlayer;
    private boolean end;
    private Piece selectedPiece = null;
    private final PlayerManager playerManager;
    private Position positionSelected;
    private int gridStockSelected;
    private HBoxCentrale hBoxCentrale;
    private HBoxAction hBoxAction;

    /**
     * this class build a new game for play and initialize all of it
     */
    public Game() {
        this.end = false;
        listObserver = new ArrayList<>();
        board = new Board();
        playerManager = new PlayerManager();
        listPlayer = playerManager.getListPlayers();
        this.currentPlayer = playerManager.getCurrentPlayer();
        positionSelected = new Position(0, 0);
    }

    /**
     * this method allows to play on the console mode only
     *
     * @param position is the position where put the piece seleted in the stock
     * of the player
     * @param piece is the piece selected in the stock by the player for put it
     * in the board
     */
    public void playConsole(Position position, Piece piece) {
        boolean addPiece = false;
        do {
            System.out.println("on passe ici ");
            addPiece = board.addPiece(this, piece, position);
        } while (!addPiece);
        nextPlayer();
        notifyObservers();
    }

    /**
     * this method allows to play in the mode user with the main java fx
     *
     * @return a boolean if the turn is played by the player
     */
    public boolean play() {
        Position position = getPositionSelected();
        boolean isAddPiece = false;
        while (!end) {
            if (!currentPlayer.isBlocked()) {

                isAddPiece = board.addPiece(this, selectedPiece, position);

                if (isAddPiece) {
                    getCurrentPlayer().getScorePlayer().setScore(selectedPiece);
                    getCurrentPlayer().getStock().delPieceStock(selectedPiece);
                    resetPieceSelected();
                    getCurrentPlayer().setNbTurnPlay();
                    nextPlayer();
                }
                position = null;
                notifyObservers();
                if ((currentPlayer.getScorePlayer().getScore() > 0)) {
                    if (!board.notPosPossible(this)) {
                        currentPlayer.setIsBlocked();
                    }
                }
            } else {
                nextPlayer();
            }
            end = isEnd();
        }
        if (end) {

            endGame();
        }
//        playIa();
        return isAddPiece;
    }

    public void endGame() {
        Alert winner = new Alert(Alert.AlertType.INFORMATION);
        winner.setTitle("Fin de partie");
        winner.setHeaderText("le gagnant est " + playerManager.getPlayerWinner().getName());
        winner.setContentText("vous avez :" + playerManager.getPlayerWinner().getScorePlayer().getScore() + " points");
        winner.showAndWait();

    }

    /**
     * this method allows to past at the next player, change the current player
     * by the next player
     */
    public void nextPlayer() {
        this.currentPlayer = playerManager.nextPlayer(currentPlayer);
        notifyObservers();
    }

    /**
     * this method allows to turn the piece selected by 90 degrees in the
     * clockwise direction
     */
    public void tournePiece() {
        this.selectedPiece.rotationPiece();
        notifyObservers();
    }

    /**
     * this method allows to make a effect mirrors on the piece selected
     */
    public void mirrorPiece() {
        this.selectedPiece.mirrorPiece();
        notifyObservers();
    }

    /**
     * this method allows to play the IA
     */
    public void playIa() {
        Context ctx = new Context();
        ctx.playStrategie(this);
        this.nextPlayer();
        notifyObservers();

    }

    /**
     * this method allows to reset the piece selected at null ( after the piece
     * is put in the board this method is called)
     */
    public void resetPieceSelected() {
        selectedPiece = null;
    }

    /**
     * this method allows to analyze if the game is end or not and return a
     * boolean
     *
     * @return a boolean true if the game is end and false if not
     */
    public boolean isEnd() {
        boolean isEnd = false;
        int nbPlayerBlocked = 0;
        for (Player player : this.listPlayer) {
            if (player.isBlocked()) {
                nbPlayerBlocked += 1;
            }
        }
        if (nbPlayerBlocked == 4) {
            isEnd = true;
        }
        return isEnd;
    }

    /**
     * this method allows to return the number ind of the four players
     *
     * @param ind is the index of the player to return
     * @return the player number ind of the list of players
     */
    public Player getPlayer(int ind) {
        return listPlayer.get(ind);
    }

    /**
     * this method allows to return the list of the four players
     *
     * @return the list of the four players
     */
    public List<Player> getListPlayer() {
        return this.listPlayer;
    }

    /**
     * this method allows to return the current player of the game
     *
     * @return the current player of the game
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * this method return the attribute end for know if the game is end or not
     *
     * @return a boolean true if the game is end and false if not
     */
    public boolean getEnd() {
        return this.end;
    }

    /**
     * this method allows to return the piece selected by the current player
     *
     * @return the piece selected by the current player
     */
    public Piece getPieceSelected() {
        return this.selectedPiece;
    }

    /**
     * this method allows to return the number of gridPaneStock selected
     *
     * @return the number of gridpane stock selected
     */
    public int getGridStockSelected() {
        return this.gridStockSelected;
    }

    /**
     * this method allows to return the board of the game
     *
     * @return the board of the game
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * this method return the position selected by the player in the board
     *
     * @return the position seleted by the palayer in the board
     */
    public Position getPositionSelected() {
        return this.positionSelected;
    }

//    public Color getColorPlayer(){
//        
//    }
    /**
     * this method allows to change the num of stock selected and verify if it
     * is well it of the current player
     *
     * @param gridStockSelected is the number of stock selected
     */
    public void setGridStockSelected(int gridStockSelected) {
        this.gridStockSelected = gridStockSelected;
    }

    /**
     * this method allows to set the piece selected by the current player
     *
     * @param numPiece is the number of the piece to select in the stock of the
     * current player
     */
    public void setPieceSelected(int numPiece) {
        System.out.println(numPiece);
        Stock stock = this.currentPlayer.getStock();
        selectedPiece = stock.getPiece(numPiece - 1);
        System.out.println(selectedPiece);
    }

    /**
     * this method allows to change the position in the board selected by the
     * player where put the piece
     *
     * @param position where put the piece
     */
    public void setPositionSelected(Position position) {
        this.positionSelected = position;
    }

    /**
     * this method allows to put the attribute end to true if the game is end
     */
    public void setEnd() {
        this.end = true;
    }

    /**
     * this method allows to put the player at blocked situation and remove it
     * at the list of the players
     */
    public void setIsBlocked() {
        this.getCurrentPlayer().setIsBlocked();
//        listPlayer.remove(this.getCurrentPlayer().getNumber() - 1);
        this.nextPlayer();
        notifyObservers();
    }

    /**
     * this method allows to add a observer at the list of observer
     *
     * @param observer is the observer to add at the list of observer
     */
    @Override
    public void addObserver(Observer observer) {
        listObserver.add(observer);
    }

    /**
     * this method allows to notify all observer of the list of observer
     */
    @Override
    public void notifyObservers() {
        listObserver.stream().forEach((observer) -> {
            observer.update();
        });
    }

    /**
     * this method allows to remove a observer at the list of observer
     *
     * @param observer is the observer to remove at the list
     */
    @Override
    public void removeObserver(Observer observer) {
        if (listObserver.contains(observer)) {
            listObserver.remove(observer);
        }
    }

}
