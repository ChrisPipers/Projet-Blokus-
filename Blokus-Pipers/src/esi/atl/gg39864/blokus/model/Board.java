package esi.atl.gg39864.blokus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * this class initialize a Board of Piece, the size is 20 * 20
 *
 * @author g39864
 */
public class Board {

    private final Piece[][] board;
    private final int length = 20;          //longueur
    private final int width = 20;           // largeur

    /**
     * this is the constructor of Board with the size length * width
     */
    public Board() {
        board = new Piece[length][width];
    }

    /**
     * this method allows to place a Piece in the Board with a Position, a game
     * and a piece
     *
     * @param game is the game where add a Piece of her Board
     * @param piece is the Piece to add in the Board
     * @param position is the Position where we want to add the piece
     * @return a boolean true if the Piece is add or false if not
     */
    public boolean addPiece(Game game, Piece piece, Position position) {
        if (piece == null) {
            throw new IllegalStateException("no piece selected, can not play");
        }
        if (position == null) {
            throw new IllegalStateException("no position selected, can not play");
        }
        boolean add = false;
        List<Position> listPos = game.getPieceSelected().getListPos(position);

        if (game.getCurrentPlayer().getScorePlayer().getScore() == 0) {
            if ((isInBoard(listPos)) && posFirstPiece(game, position, listPos)) {
                for (Position listPo : listPos) {
                    board[listPo.getJ()][listPo.getI()] = piece;
                }
                add = true;
            }
        } else if (isAddPossible(listPos, piece.getColor())) {
            for (Position listPo : listPos) {
                board[listPo.getJ()][listPo.getI()] = piece;
            }
            add = true;
        }
        return add;
    }

    public boolean isAddPossible(List<Position> listPos, Color color) {
        boolean isPossible = false;
        if ((isInBoard(listPos)
                && (verifCorners(listPos, color))
                && (verifSides(listPos, color))
                && (verifPosPieceIsNull(listPos)))) {
            isPossible = true;
        }
        return isPossible;
    }

    /**
     * this method verify if the first piece is placed in the corner respective
     * of the player
     *
     * @param game is the parameter for know the corner of the current player
     * @param position is the position where we want to add the piece
     * @param listPos is the list of positions of the piece to add
     * @return true if the conner is it of the current player or not if not
     */
    public boolean posFirstPiece(Game game, Position position, List<Position> listPos) {
        boolean startPosOk = false;
        Player playerCurrent = game.getCurrentPlayer();

        for (Position pos : listPos) {
            if (pos.getI() == playerCurrent.getStartPosition().getI()
                    && pos.getJ() == playerCurrent.getStartPosition().getJ()) {
                startPosOk = true;
                break;
            }
        }
        return startPosOk;
    }

    /**
     * this method allows to know if the list of the position of the piece
     * selected to add is in the board
     *
     * @param listPos is the list of the position of the piece selected
     * @return a boolean true if each position are in the board or false if not
     */
    public boolean isInBoard(List<Position> listPos) {
        boolean isInside = true;

        for (Position listPo : listPos) {
            if ((listPo.getI() > 19) || (listPo.getJ() > 19)
                    || (listPo.getI() < 0) || (listPo.getJ() < 0)) {
                isInside = false;
                break;
            }
        }
        return isInside;
    }

    /**
     * this method allows to know if each position of the piece selected have a
     * corner in touch a corner of a another piece of the same color
     *
     * @param listPos if the list of the position of the piece selected
     * @param colorPiece is the color of the current player
     * @return a boolean true if one of a corner of one position touch a
     * position with the same color and false if not
     */
    public boolean verifCorners(List<Position> listPos, Color colorPiece) {
        boolean isConerOk = false;
        List<Color> listColorCor = new ArrayList<>();

        for (Position pos : listPos) {
            if (pos.getJ() - 1 > -1 && pos.getI() - 1 > -1
                    && pos.getJ() - 1 < 20 && pos.getI() - 1 < 20
                    && Objects.nonNull((board[pos.getJ() - 1][pos.getI() - 1]))) {
                listColorCor.add(((board[pos.getJ() - 1][pos.getI() - 1])).getColor());
            }
            if (pos.getJ() - 1 > -1 && pos.getI() + 1 > -1
                    && pos.getJ() - 1 < 20 && pos.getI() + 1 < 20
                    && Objects.nonNull((board[pos.getJ() - 1][pos.getI() + 1]))) {
                listColorCor.add(((board[pos.getJ() - 1][pos.getI() + 1])).getColor());
            }
            if (pos.getJ() + 1 > -1 && pos.getI() - 1 > -1
                    && pos.getJ() + 1 < 20 && pos.getI() - 1 < 20
                    && Objects.nonNull((board[pos.getJ() + 1][pos.getI() - 1]))) {
                listColorCor.add(((board[pos.getJ() + 1][pos.getI() - 1])).getColor());
            }
            if (pos.getJ() + 1 > -1 && pos.getI() + 1 > -1
                    && pos.getJ() + 1 < 20 && pos.getI() + 1 < 20
                    && Objects.nonNull((board[pos.getJ() + 1][pos.getI() + 1]))) {
                listColorCor.add(((board[pos.getJ() + 1][pos.getI() + 1])).getColor());
            }
        }

        for (Color isColor : listColorCor) {
            if (isColor.equals(colorPiece)) {
                isConerOk = true;
                break;
            }
        }
        return isConerOk;
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
    public boolean verifSides(List<Position> listPos, Color colorPiece) {
        boolean isSideOk = true;
        List<Color> listColorSid = new ArrayList<>();

        for (Position pos : listPos) {
            if (pos.getJ() - 1 > -1 && pos.getI() > -1
                    && pos.getJ() - 1 < 20 && pos.getI() < 20
                    && Objects.nonNull((board[pos.getJ() - 1][pos.getI()]))) {
                listColorSid.add(((board[pos.getJ() - 1][pos.getI()])).getColor());
            }
            if (pos.getJ() > -1 && pos.getI() + 1 > -1
                    && pos.getJ() < 20 && pos.getI() + 1 < 20
                    && Objects.nonNull((board[pos.getJ()][pos.getI() + 1]))) {
                listColorSid.add(((board[pos.getJ()][pos.getI() + 1])).getColor());
            }
            if (pos.getJ() + 1 > -1 && pos.getI() > -1
                    && pos.getJ() + 1 < 20 && pos.getI() < 20
                    && Objects.nonNull((board[pos.getJ() + 1][pos.getI()]))) {
                listColorSid.add(((board[pos.getJ() + 1][pos.getI()])).getColor());
            }
            if (pos.getJ() > -1 && pos.getI() - 1 > -1
                    && pos.getJ() < 20 && pos.getI() - 1 < 20
                    && Objects.nonNull((board[pos.getJ()][pos.getI() - 1]))) {
                listColorSid.add(((board[pos.getJ()][pos.getI() - 1])).getColor());
            }
        }

        for (Color isColor : listColorSid) {
            if (isColor.equals(colorPiece)) {
                isSideOk = false;
                break;
            }
        }
        return isSideOk;
    }

    /**
     * this method allows to verify if each position of the piece selected is
     * null, if each position are not taken
     *
     * @param listPos is the list of position of the piece selected
     * @return a boolean true if each piece of piece selected are free
     */
    public boolean verifPosPieceIsNull(List<Position> listPos) {
        boolean isPosOk = true;
        List<Boolean> listBoolean = new ArrayList<>();

        for (Position pos : listPos) {
            if ((pos.getI() < 0) || (pos.getI() > 19)
                    || (pos.getJ() < 0) || (pos.getJ() > 19)
                    || (Objects.isNull(this.board[pos.getJ()][pos.getI()]))) {
                listBoolean.add(true);
            } else {
                listBoolean.add(false);
            }
            for (Boolean bool : listBoolean) {
                if (!bool) {
                    isPosOk = false;
                    break;
                }
            }
        }
        return isPosOk;
    }

    /**
     * this method allows to know if one of position of the board is possible
     * @param game is the parameter for know different parameter 
     * @return a boolean at true if there are one of position possible and false if not
     */
    public boolean notPosPossible(Game game){
        Player player = game.getCurrentPlayer();
        Stock stock = player.getStock();
        List <Piece> listPieces = stock.getListOfStock();
        List<Boolean> listBool = new ArrayList<>();
        boolean isBlocked = false;
        for (Piece piece : listPieces) {
            if (piece != null){
                if (!listPosPossible(game, piece).isEmpty()){
                    listBool.add(true);
                }
            }
        }
        if (listBool.isEmpty()){
            isBlocked = true;
        }
        listBool.clear();
        return isBlocked;
    }
    
    
    /**
     * this method allows to analyze each position possible according with the piece
     * @param game is the parameter for know different parameter 
     * @param piece is the piece to analyze each position if can be placed
     * @return the list of the position possible of the piece on the board
     */
    public List<Position> listPosPossible(Game game, Piece piece) {
        List<Position> listPosPiece = new ArrayList<>();
        List<Position> listPosPossible = new ArrayList<>();
        Color color = piece.getColor();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Position position = new Position(i, j);
                listPosPiece = piece.getListPos(position);
                if (isAddPossible(listPosPiece, color)) {
                    
                    listPosPossible.add(new Position(i, j));
                }
            }
        }
        return listPosPossible;
    }

    /* 
    * use getter for lenght and width because if we want change the dimenssion 
    * of the board.
     */
    /**
     * the method return the length of a Board
     *
     * @return the length of the Board
     */
    public int getLength() {
        return this.length;
    }

    /**
     * the method return the width of a Board
     *
     * @return the width of the Board
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * this method allows to know the piece at the position (i, j) in the board
     *
     * @param i is the column in the board where we want know the piece
     * @param j is the row in the board where we want know the piece
     * @return a piece who ara at the position (i, j) in the board
     */
    public Piece getBoardPiece(int i, int j) {
        return this.board[i][j];
    }

}
