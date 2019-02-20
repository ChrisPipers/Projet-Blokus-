package esi.atl.G39864.blokus.view.Console;

import esi.atl.gg39864.blokus.model.Board;
import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Player;
import java.util.List;

/**
 * this class allows to displayed he different element of the game
 * @author Chris
 */
public class Display {

    /**
     * this method is the constructor without parameter
     */
    public Display() {

    }

    /**
     * this method display the name and number of the player to play
     *
     * @param player is the play where is to her turn
     * @param i is the number of the Player in the List of Player
     */
    public void nameNumPlayer(Player player, int i) {
        System.out.println(player.getName() + " " + (i + 1) + " your turn");
    }

    /**
     * this method display the different option for the player
     */
    public void help() {

        System.out.println("enter :" + "\n"
                + "show, for show the Board of game" + "\n"
                + "stock, for display you stock" + "\n"
                + "play n i j , for placed the Piece n to the "
                + "Position(i,j)" + "\n"
                + "help, for diplayed the command possible" + "\n"
                + "next, for past the turn" + "\n"
                + "exit, for quit the Game" + "\n"
                + "enter your command :");
    }

    /**
     * this method return a String of a Board for visualized it
     *
     * @param game
     */
    public void toStringBoard(Game game) {
        Board board = game.getBoard();
        String stringBoard = "";
        for (int i = 0; i < 20; i++) {
            stringBoard += "---------------------------------------------------------------------------------";
            stringBoard += "\n" + "|";
            for (int j = 0; j < 20; j++) {
                if (game.getBoard().getBoardPiece(i, j) == null) {
                    stringBoard += "   " + "|";
                } else {
                    String color = board.getBoardPiece(i, j).getColor().toString().substring(0,1);
                    stringBoard += " " + color + " " + "|";
                }
            }
            stringBoard += "\n";
        }
        stringBoard += "---------------------------------------------------------------------------------";
        System.out.println(stringBoard);
    }

    /**
     * this method display the name of the layer enter in parameter
     *
     * @param player is the Player to display her name
     */
    public void displayName(Player player) {
        System.out.println(player.getName());
    }

    
    
    /**
     * this method display the Stock of the Piece
     *
     * @param player is the Player to displayed her Stock
     */
    public void displayStock(Player player) {
        String sPiece = "";
        System.out.println("Player : " + player.getName() + " number :" );
        List<Piece> listPeice = player.getStock().getListOfStock();
        for (Piece piece : listPeice) {
            sPiece += piece.getNumberPiece() + "\n";
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (piece.getPosPiece(i, j) == true) {
                        sPiece += piece.getColor() + " ";
                    } else {
                        sPiece += "  ";
                    }
                }
                sPiece += "\n";
            }
            sPiece += "\n";

        }
        System.out.println(sPiece);
    }
}
