package esi.atl.G39864.blokus.ia.model;

import esi.atl.gg39864.blokus.model.Board;
import esi.atl.gg39864.blokus.model.Color;
import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chris home
 */
public class AnalyzePos {

    private List<Position> listEachCornersFree = new ArrayList<>();
    private List<Position> listEachSidesFree = new ArrayList<>();
    private List<Position> listPosPossible = new ArrayList<>();
    private List<Position> listPosPrise = new ArrayList<>();
    private Board board;
    private Color color;

    public AnalyzePos(Game game, Piece piece) {
        board = game.getBoard();
        color = getColorOfPlayer(game.getCurrentPlayer().getNumber());
//        listingEachPosPlayer(game);
//        verifEachPosPlayer(color);
//System.out.println(piece.toString());
        System.out.println(color);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                Position position = new Position(i, j);
                List<Position> listPos = piece.getListPos(position);

                System.out.println("" + (board.isInBoard(listPos))
                        + (!board.verifCorners(listPos, color))
                        + (!board.verifSides(listPos, color))
                        + (board.verifPosPieceIsNull(listPos)));
                if (board.isInBoard(listPos)
                        && (board.verifCorners(listPos, color))
                        && (board.verifSides(listPos, color))
                        && (board.verifPosPieceIsNull(listPos))) {
                    listPosPossible.add(position);
                }

            }
            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
        System.out.println(listPosPossible.size() + " poqssssssdfghjk");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(board.getBoardPiece(i, j));
            }
            System.out.println("");
        }

        System.out.println("------------------------------------------------------------------------------------------------------------");

    }

    public void listingEachPosPlayer(Game game) {
//        System.out.println("on passe combien de fois ici ");
        Color col = getColorOfPlayer(game.getCurrentPlayer().getNumber());
//        System.out.println(Objects.isNull(col));
//        System.out.println(col + "coulouuuuuuuuuurr");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
////                                    System.out.println("(" + i + ", "+j+")");
//                System.out.print(Objects.isNull(this.board.getBoardPiece(i, j))+" ");
//                System.out.print(Objects.nonNull(this.board.getBoardPiece(i, j))+" ");
                if ((Objects.nonNull(this.board.getBoardPiece(i, j)))) {
//                    System.out.print(this.board.getBoardPiece(i, j).getColor());
////                    System.out.println("(" + i + ", "+j+")");
//                    System.out.println("passse ici alors ");
//                    System.out.println(col.equals(this.board.getBoardPiece(i, j)) + " same color ? ");
                    if (col.equals(this.board.getBoardPiece(i, j).getColor())) {
                        listPosPrise.add(new Position(i, j));
//                        System.out.println(listPosPrise.size()+" size of list post prise");
                    }
                }
            }
//            System.out.println("");
        }
        System.out.println(listPosPrise.size() + "size pos prise");
    }

    public void verifEachPosPlayer(Color col) {
        listEachCornersFree = verifCorners(color);
        listEachSidesFree = verifSides(color);
//        System.out.println(listEachSidesFree.size() +" * "+ listEachSidesFree.size());
        int size = (listEachSidesFree.size() < listEachSidesFree.size()) ? listEachSidesFree.size() : listEachSidesFree.size();
//        System.out.println(size);

        for (Position posCor : listEachCornersFree) {
//            System.out.println(posCor.toString()+"----------");
            for (Position posSid : listEachSidesFree) {
//                System.out.println(posSid.toString());
//                System.out.println(posCor.getI() == posSid.getI() && posCor.getJ() == posSid.getJ());        
                if ((posCor.getI() == posSid.getI()) || (posCor.getJ() == posSid.getJ()) && (((posCor.getI() != posSid.getI()) || (posCor.getJ() != posSid.getJ())))) {                  // equals fonctionne pas 
                    System.out.println(posCor.toString() + "  dansssslllllllaaaaaaaa");
                    listPosPossible.add(posSid);
                }
            }
        }
        System.out.println(listPosPossible.size() + " pos possible ------------------------");
        for (Position position : listPosPossible) {
            System.out.println(position.toString());
        }
    }

    public Color getColorOfPlayer(int i) {
        Color color = null;
        switch (i) {
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.YELLOW;
                break;
            case 2:
                color = Color.RED;
                break;
            case 3:
                color = Color.GREEN;
                break;
        }
        return color;
    }

    /**
     * this method allows to know if a position have a corner in touch a corner
     * of a another piece of the same color
     *
     * @param pos is the position to analyze if the corners touch a another
     * piece with the same color
     * @param colorPiece is the color of the current player
     * @return a boolean true if one of a corner of one position touch a
     * position with the same color and false if not
     */
    public List<Position> verifCorners(Color colorPiece) {
        System.out.println(listPosPrise.size() + " pos prise in verif corners ");
        List<Position> listCornerFree = new ArrayList<>();
        for (Position pos : listPosPrise) {

            if (pos.getJ() - 1 > -1 && pos.getI() - 1 > -1
                    && pos.getJ() - 1 < 20 && pos.getI() - 1 < 20
                    && ((Objects.isNull(board.getBoardPiece(pos.getJ() - 1, pos.getI() - 1))))) {
                listCornerFree.add(new Position(pos.getJ() - 1, pos.getI() - 1));
            }
            if (pos.getJ() - 1 > -1 && pos.getI() + 1 > -1
                    && pos.getJ() - 1 < 20 && pos.getI() + 1 < 20
                    && ((Objects.isNull(board.getBoardPiece(pos.getJ() - 1, pos.getI() + 1))))) {
                listCornerFree.add(new Position(pos.getJ() - 1, pos.getI() + 1));
            }
            if (pos.getJ() + 1 > -1 && pos.getI() - 1 > -1
                    && pos.getJ() + 1 < 20 && pos.getI() - 1 < 20
                    && ((Objects.isNull(board.getBoardPiece(pos.getJ() + 1, pos.getI() - 1))))) {
                listCornerFree.add(new Position(pos.getJ() + 1, pos.getI() - 1));
            }
            if (pos.getJ() + 1 > -1 && pos.getI() + 1 > -1
                    && pos.getJ() + 1 < 20 && pos.getI() + 1 < 20
                    && ((Objects.isNull(board.getBoardPiece(pos.getJ() + 1, pos.getI() + 1))))) {
                listCornerFree.add(new Position(pos.getJ() + 1, pos.getI() + 1));
            }
        }
        System.out.println(listCornerFree.size() + " fin de verif corners");
        for (Position position : listCornerFree) {
            System.out.println(position);
        }
        return listCornerFree;
    }

    /**
     * this method allows to know if each position of the piece selected have a
     * side in touch a corner of a another piece of the same color
     *
     * @param listPos if the list of the position of the piece selected
     * @param colorPiece is the color of the current player
     * @return a boolean false if one of a side of one position touch a position
     * with the same color and true if not
     */
    public List<Position> verifSides(Color colorPiece) {
        boolean isSideOk = true;
        List<Position> listSideFree = new ArrayList<>();
        for (Position pos : listPosPrise) {
            System.out.println(pos.toString());
            if (pos.getJ() - 1 > -1 && pos.getI() > -1
                    && pos.getJ() - 1 < 20 && pos.getI() < 20
                    && (Objects.isNull((board.getBoardPiece(pos.getJ() - 1, pos.getI()))))
                    && (!color.equals((board.getBoardPiece(pos.getJ() - 1, pos.getI()))))) {
                listSideFree.add(new Position(pos.getJ() - 1, pos.getI()));
            }
            if (pos.getJ() > -1 && pos.getI() + 1 > -1
                    && pos.getJ() < 20 && pos.getI() + 1 < 20
                    && (Objects.isNull((board.getBoardPiece(pos.getJ(), pos.getI() + 1))))
                    && (!color.equals((board.getBoardPiece(pos.getJ(), pos.getI() + 1))))) {
                listSideFree.add(new Position(pos.getJ(), pos.getI() + 1));
            }
            if (pos.getJ() + 1 > -1 && pos.getI() > -1
                    && pos.getJ() + 1 < 20 && pos.getI() < 20
                    && (Objects.isNull((board.getBoardPiece(pos.getJ() + 1, pos.getI()))))
                    && (!color.equals((board.getBoardPiece(pos.getJ() + 1, pos.getI()))))) {
                listSideFree.add(new Position(pos.getJ() + 1, pos.getI()));
            }
            if (pos.getJ() > -1 && pos.getI() - 1 > -1
                    && pos.getJ() - 1 < 20 && pos.getI() - 1 < 20
                    && (Objects.isNull((board.getBoardPiece(pos.getJ(), pos.getI() - 1))))
                    && (!color.equals((board.getBoardPiece(pos.getJ(), pos.getI() - 1))))) {
                listSideFree.add(new Position(pos.getJ(), pos.getI() - 1));

            }
        }
        System.out.println(listSideFree.size() + " nb de side free");
        for (Position pos : listSideFree) {
            System.out.println(pos.toString());
        }
        return listSideFree;
    }

    public List<Position> getListEachPosFree() {
        return this.listEachCornersFree;
    }
}
