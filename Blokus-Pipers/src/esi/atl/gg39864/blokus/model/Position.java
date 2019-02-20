package esi.atl.gg39864.blokus.model;

/**
 * this class allows to build a position and use it
 *
 * @author g39864
 */
public class Position {

    private final int i; // utiliser des minuscules.
    private final int j;
    private static final int MAX = 19;
    private static final int MIN = 0;

    /**
     * this is the constructor of an position
     *
     * @param i is the line of a position
     * @param j is the column of a position
     */
    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * this method test if the position is in the board
     *
     * @param position is the position to check if is in the Board
     * @return a boolean true if the position is in Board or false if not
     */
    public boolean isInside(Position position) { // dans Board?
        boolean inside = true;

        if ((position.i < MIN) || (position.i > MAX) // utiliser des constantes
                || (position.j < MIN) || (position.j > MAX)) {
            inside = false;
        }
        return inside;
    }

    /**
     * this method return the parameter i, line, of a Piece
     *
     * @return the parameter i of a Position
     */
    public int getI() {
        return this.i;
    }

    /**
     * this method return the parameter j, column, of a Piece
     *
     * @return the parameter j of a Position
     */
    public int getJ() {
        return this.j;
    }

    /**
     * this method allows to return a string of a position return (i, j)
     *
     * @return a string of the position
     */
    @Override
    public String toString() {
        return "(" + this.i + ", " + j + ")"; //To change body of generated methods, choose Tools | Templates.
    }

}
