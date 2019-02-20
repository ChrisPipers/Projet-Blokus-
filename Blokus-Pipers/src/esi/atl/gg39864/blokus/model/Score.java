package esi.atl.gg39864.blokus.model;

/**
 * this class allows to build a score and manage it
 *
 * @author Chris
 */
public class Score {

    private int scorePlayer;

    /**
     * this is the constructor of a Score
     */
    public Score() {
        scorePlayer = 0;
    }

    /**
     * this method allows to return the Score of a Player
     *
     * @return the Score of a Player
     */
    public int getScore() {
        return this.scorePlayer;
    }

    /**
     * this method allows to modified the Score of a Player according of the
     * Piece add to the board
     *
     * @param piece is the Piece add to Board for know her valor of point
     */
    public void setScore(Piece piece) {
        System.out.println(piece.getSize() + "size");
        switch (piece.getSize()) {
            case 1:
            case 2:
                scorePlayer += 1;
                break;
            case 3:
                scorePlayer += 2;
                break;
            case 4:
                scorePlayer += 5;
                break;
            case 5:
                scorePlayer += 12;
                break;
        }
    }

}
