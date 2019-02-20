package esi.atl.gg39864.blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * this class build the Piece
 *
 * @author chris home
 */
public class Piece {

    private boolean[][] tabPiece = new boolean[4][4];
    private int number;
    private final Color color;
    private List<Position> listPosPiece = new ArrayList<>();
    private int size;

    /**
     * this is the constructor of a Piece with four parameters
     *
     * @param tabPiece is the position of landmark of the Piece
     * @param number is the number of the Piece
     * @param color is the color of Piece
     * @param size is the number of case of Piece
     */
    public Piece(boolean[][] tabPiece, int number, Color color, int size) {
        this.tabPiece = tabPiece;
        this.number = number;
        this.color = color;
        this.size = size;
    }

    /**
     * this is the constructor of a Piece without parameter
     */
    public Piece() {
        this.color = null;
    }

    /**
     * this method return the Board of Position of a Piece
     *
     * @return the Board of the Position of the Piece
     */
    public boolean getPosPiece(int i, int j) { // JAMAIS rertourner un tableau interne à la classe.
        return this.tabPiece[i][j];
    }

    /**
     * this method return the number of the Piece
     *
     * @return the number of the Piece
     */
    public int getNumberPiece() {
        return this.number;
    }

    /**
     * this method return the Color of the Piece
     *
     * @return the Color of a Piece
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * this method return the size of the Piece
     *
     * @return the size of a Piece
     */
    public int getSize() {
        return this.size;
    }

    /**
     * this method allow to change the Board of a Piece where she is rotate or
     * mirror effect
     *
     * @param tabPiece the new tab of the piece avec rotate or mirror effect
     */
    public void setTabPiece(boolean[][] tabPiece) {
        this.tabPiece = tabPiece;
    }

    /**
     * this method allows to return the list of Position of a Piece original
     */
    public void resetListPos() {
        this.listPosPiece.clear();
    }

    /**
     * this method allows to return the list of Position of a Piece with a
     * Position in parameter
     *
     * @param position is the position for can calculate the position of each
     * part of the piece
     * @return the list of Position of a Piece for put she in a board depending
     * on with a Position in parameter
     */
    public List<Position> getListPos(Position position) {
        int iTemp = 0 ;
        int jTemp = 0 ;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tabPiece[j][i] == true) {
                    iTemp = i;
                    jTemp = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.tabPiece[j][i] == true) {
                    if (this.getNumberPiece() == 21) {
                        Position pos = new Position(position.getI() + i  - iTemp, position.getJ() + j - jTemp);
                        listPosPiece.add(pos);
                    } else {
                        Position pos = new Position(position.getI() + i - iTemp, position.getJ() + j - jTemp);
                        listPosPiece.add(pos);
                    }

                }
            }
        }
        return listPosPiece;
    }

    /**
     * this method allows to displayed the number of the piece and her color
     *
     * @return a string with the number of the piece and her color
     */
    @Override
    public String toString() {
        return "(" + this.number + ", " + this.color + ")"; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * this method allows to turn the piece selected by 90 degrees in the
     * clockwise direction
     */
    public void rotationPiece() {
        int size = 4;
        boolean[][] tab = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tab[j][size - 1 - i] = tabPiece[i][j];
            }
        }
        this.setTabPiece(tab);
    }

    /**
     * this method allows to make a effect mirrors on the piece selected
     */
    public void mirrorPiece() {
        int size = 4;
        boolean[][] tab = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tab[i][j] = tabPiece[i][size - 1 - j];
            }
        }
        this.setTabPiece((tab));
    }

}
