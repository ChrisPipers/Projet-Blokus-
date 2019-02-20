package esi.atl.G39864.Blokus.Model.test;

import esi.atl.gg39864.blokus.model.*;
import esi.atl.G39864.blokus.Model.IO.ReadFile;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.List;

/**
 * this class test the method of the class board 
 * @author Chris
 */
public class BoardTest {

//******************************************************************************   
//      for displayed the board 
//******************************************************************************   
/*
    for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(board.getBoardPiece(i, j));
            }
            System.out.println("");
/        }
******************************************************************************   
    /**
     * this test verify if the Board is well a Board with the dimensions 20 * 20
     */
    @Test
    public void testConstructorBoard() {
        boolean size = false;
        Board board = new Board();
        if ((board.getLength() == 20) && (board.getWidth() == 20)) {
            size = true;
        }
        assertTrue(size);
    }

    /**
     * this test verify if the Piece 1 of Stock is add to the Board with
     * instanceof for the Position (4,4) in the Board
     */
    @Test
    public void testAddPiece1() {
        Game game = new Game();
        Board board = game.getBoard();
        boolean instanceOf = false;
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(1);
        Position position = new Position(4, 4);
        board.addPiece(game, piece, position);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.getBoardPiece(i, j) != null) {

                    instanceOf = true;
                }
                assertTrue(instanceOf);
            }
        }
    }

    /**
     * this test verify if the Piece 2 of Stock is add to the Board with
     * instanceof for the Position (4,4) and the Position (5,4)in the Board
     */
    @Test
    public void testAddPiece2() {
        boolean instanceOf = false;
        Game game = new Game();
        Board board = game.getBoard();
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(2);
        Position position = new Position(4, 4);
        board.addPiece(game, piece, position);
        if ((board.getBoardPiece(4, 4) instanceof Piece)
                && (board.getBoardPiece(5, 4) instanceof Piece)) {
            instanceOf = true;
        }
        assertTrue(instanceOf);
    }

    /**
     * this test verify if the Piece 1 of Stock is add to the Board with
     * instanceof for the Position (19,19) in the Board
     */
    @Test
    public void testAddPiece3() {
        Game game = new Game();
        boolean instanceOf = false;
        Board board = game.getBoard();
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(1);
        Position position = new Position(19, 19);
        board.addPiece(game, piece, position);

        if ((board.getBoardPiece(19, 19) instanceof Piece)) {
            instanceOf = true;
        }
        assertTrue(instanceOf);
    }

    /**
     * this test verify if the Piece 2 of Stock is add to the Board with
     * instanceof for the Position (18,18) and the Position(19,18) in the Board
     */
    @Test
    public void testAddPiece4() {
        Game game = new Game();
        boolean instanceOf = false;
        Board board = game.getBoard();
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(2);
        Position position = new Position(18, 18);
        board.addPiece(game, piece, position);
        if ((board.getBoardPiece(18, 18) instanceof Piece)
                && (board.getBoardPiece(19, 18) instanceof Piece)) {
            instanceOf = true;
        }
        assertTrue(instanceOf);
    }

    /**
     * this test verify if the Piece 2 of Stock is add to the Board with
     * instanceof for the Position (19,19) and the Position(20,19) in the Board
     */
    @Test
    public void testAddPiece5() {
        Game game = new Game();
        boolean instanceOf = false;
        Board board = game.getBoard();
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(2);
        Position position = new Position(19, 19);
        board.addPiece(game, piece, position);
        if ((board.getBoardPiece(19, 19) instanceof Piece)
                && (board.getBoardPiece(20, 19) instanceof Piece)) {
            instanceOf = true;
        }
        assertFalse(instanceOf);
    }

    /**
     * this test verify if the Piece 2 of Stock is add to the Board with
     * instanceof for the Position (19,19) and the Position(20,19) in the Board
     */
    @Test
    public void testAddPiece6() {
        Game game = new Game();
        boolean instanceOf = false;
        Board board = game.getBoard();
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(1);
        Position position = new Position(19, 19);
        board.addPiece(game, piece, position);

        if ((board.getBoardPiece(19, 19) instanceof Piece)) {
            instanceOf = true;
        }
        piece = stock.getPiece(3);
        position = new Position(3, 3);
        board.addPiece(game, piece, position);

        if ((board.getBoardPiece(3, 3) instanceof Piece)
                && (board.getBoardPiece(4, 3) instanceof Piece)
                && (board.getBoardPiece(5, 3) instanceof Piece)) {
            instanceOf = true;
        }

        assertTrue(instanceOf);
    }

    /**
     * this test verify if we are in the Board with the Position (19,19) and the
     * the Piece 1 of Stock
     */
    @Test
    public void testIsInsideBoard2() {
        Game game = new Game();
        Position position = new Position(19, 19);

        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        Board board = game.getBoard();
        game.getBoard().addPiece(game, piece, position);
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);
        assertTrue(inside);
    }

    /**
     * this test verify if we are in the Board with the Position (19,19) and the
     * the Piece 1 of Stock
     */
    @Test
    public void testIsInsideBoard3() {
        Game game = new Game();
        Position position = new Position(19, 19);
        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        System.out.println(piece.toString());
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);;
        assertTrue(inside);
    }

    /**
     * this test verify if we are in the Board with the Position (20,20) and the
     * the Piece 1 of Stock
     */
    @Test
    public void testIsInsideBoard4() {
        Game game = new Game();
        Position position = new Position(20, 20);
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);
        assertFalse(inside);
    }

    /**
     * this test verify if we are in the Board with the Position (-1,-1) and the
     * the Piece 1 of Stock
     */
    @Test
    public void testIsInsideBoard5() {
        Game game = new Game();
        Position position = new Position(-1, -1);
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);
        assertFalse(inside);
    }

    /**
     * this test verify if we are in the Board with the Position (0,0) and the
     * the Piece 5 of Stock
     */
    @Test
    public void testIsInsideBoard6() {
        Game game = new Game();
        Position position = new Position(0, 0);
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(5);
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);
        assertTrue(inside);
    }

    /**
     * this test verify if we are in the Board with the Position (19,19) and the
     * the Piece 5 of Stock
     */
    @Test
    public void testIsInsideBoard7() {
        Game game = new Game();
        Position position = new Position(10, 10);
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(5);
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);
        assertTrue(inside);
    }

    /**
     * this test verify if we are in the Board with the Position (19,19) and the
     * the Piece 5 of Stock
     */
    @Test
    public void testIsInsideBoard8() {
        Game game = new Game();
        Position position = new Position(19, 19);
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        Piece piece = stock.getPiece(5);
        List<Position> listPos = piece.getListPos(position);
        boolean inside = game.getBoard().isInBoard(listPos);
        assertFalse(inside);
    }

//    ------------------------ verifCorners ------------------------
//    *the four coners 
//    ******* joueur 1 bleu 
//     pos 0 0 et 1 1 haut gauche                 piece et verif 
//    @Test
    public void testVerifConers1() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(1, 1);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertTrue(isOk);
    }

//     pos 0 0 et 1 0 haut droite                 piece et verif 
    @Test
    public void testVerifConers2() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        game.getCurrentPlayer().getScorePlayer().setScore(piece);
        position = new Position(1, 0);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 1 bas gauche                 piece et verif 
    @Test
    public void testVerifConers3() {
        Game game = new Game();
        Board board = game.getBoard();

        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);

        board.addPiece(game, piece, position);
        position = new Position(0, 1);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     add plusieurs pieces
    @Test
    public void testVerifConers31() {
        Game game = new Game();
        Board board = game.getBoard();

        Piece piece = game.getCurrentPlayer().getStock().getPiece(8);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(8);
        List<Position> listPos1 = game.getPieceSelected().getListPos(position);
        for (Position position1 : listPos1) {
            System.out.println(position1.toString());
        }
        board.addPiece(game, piece, position);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(board.getBoardPiece(i, j));
            }
            System.out.println("");
        }
        piece = game.getCurrentPlayer().getStock().getPiece(10);
        position = new Position(2, 2);
        color = piece.getColor();
        game.setPieceSelected(1);
        List<Position> listPos2 = game.getPieceSelected().getListPos(position);
        for (Position position2 : listPos2) {
            System.out.println(position2.toString());
        }
        board.addPiece(game, piece, position);
        game.resetPieceSelected();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(board.getBoardPiece(i, j));
            }
            System.out.println("");
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(game.getBoard().getBoardPiece(i, j));
            }
            System.out.println("");
        }
        position = new Position(0, 1);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertTrue(isOk);
    }

//    ******* joueur 2 jaune
//     pos 2 2 et 1 1 bas droite                piece et verif 
    @Test
    public void testVerifConers4() {
        Game game = new Game();
        Board board = game.getBoard();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);

        position = new Position(1, 18);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertTrue(isOk);
    }

//    * 
//     pos 1 1 et 0 0 bas droite                piece et verif 
    @Test
    public void testVerifConers5() {
        Game game = new Game();
        Board board = game.getBoard();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(1, 19);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     pos 18 18 et 19 19 bas droite                piece et verif 
    @Test
    public void testVerifConers6() {
        Game game = new Game();
        Board board = game.getBoard();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(0, 18);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//    ******* joueur 3 rouge 
//     pos 1 18 et 0 19 bas gauche               piece et verif 
    @Test
    public void testVerifConers7() {
        Game game = new Game();
        Board board = game.getBoard();
        game.nextPlayer();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        game.setPieceSelected(1);
        Position position = new Position(19, 0);
        Color color = piece.getColor();
        board.addPiece(game, piece, position);
        position = new Position(18, 1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertTrue(isOk);
    }

//     pos 0 18 et 0 19 haut droite                piece et verif 
    @Test
    public void testVerifConers8() {
        Game game = new Game();
        Board board = game.getBoard();

        game.nextPlayer();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 0);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 18 et 0 19 haut droite                piece et verif 
    @Test
    public void testVerifConers9() {
        Game game = new Game();
        Board board = game.getBoard();

        game.nextPlayer();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(19, 1);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//    ******* joueur 4 vert
//     pos 0 18 et 0 19 haut droite                piece et verif 
    @Test
    public void testVerifConers10() {
        Game game = new Game();
        Board board = game.getBoard();

        game.nextPlayer();
        game.nextPlayer();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 19);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     pos 1 1 et 2 2  et 3 4                piece, piece et verif 
    @Test
    public void testVerifConers11() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        Position position = new Position(19, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(19, 18);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     pos 1 1 et 2 2  et 3 4                piece, piece et bad verif 
    @Test
    public void testVerifConers12() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        Position position = new Position(19, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 18);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }
//
//    ***************
//     3 4                 bad verif 

    @Test
    public void testVerifConers13() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        Position position = new Position(1, 1);
        Color color = piece.getColor();
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//     piece not same color  
    @Test
    public void testVerifConers14() {
        Game game = new Game();
        Board board = game.getBoard();

        Piece piece = game.getCurrentPlayer().getStock().getPiece(1);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);

        game.nextPlayer();
        piece = game.getCurrentPlayer().getStock().getPiece(8);
        position = new Position(1, 1);
        game.setPieceSelected(8);
        board.addPiece(game, piece, position);

        position = new Position(3, 1);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = board.verifCorners(listPos, color);
        assertFalse(isOk);
    }

//    ------------------------ verifSides ------------------------
//    *the four coners 
//    player 1 blue 
//     pos 0 0 et 0 1              piece et verif = false
    @Test
    public void testVerifSides1() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(0, 1);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        game.setPieceSelected(2);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 0                 piece et verif = false
    @Test
    public void testVerifSides2() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(1, 0);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        game.setPieceSelected(2);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides3() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        game.setPieceSelected(2);
        position = new Position(1, 1);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertTrue(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides4() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        piece = game.getCurrentPlayer().getStock().getPiece(1);
        game.setPieceSelected(2);
        position = new Position(2, 2);
       List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertTrue(isOk);
    }

//    ****** player 2
    @Test
    public void testVerifSides5() {
        Game game = new Game();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(0, 18);

       List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 0                 piece et verif = false
    @Test
    public void testVerifSides6() {
        Game game = new Game();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);

        position = new Position(1, 18);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertTrue(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides7() {
        Game game = new Game();
        game.nextPlayer();
        Board board = game.getBoard();
        game.setPieceSelected(1);

        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Color color = piece.getColor();
        Position position = new Position(0, 19);
        board.addPiece(game, piece, position);
        position = new Position(1, 19);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides8() {
        Game game = new Game();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(2, 17);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertTrue(isOk);
    }

//    ****** player 3
    @Test
    public void testVerifSides9() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 0);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 0                 piece et verif = false
    @Test
    public void testVerifSides10() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 1);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertTrue(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides11() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 0);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(19, 1);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertFalse(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides12() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(17, 2);
        List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);
        assertTrue(isOk);
    }

//    ****** player 4
    @Test
    public void testVerifSides13() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 19);
List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);        assertFalse(isOk);
    }

//     pos 0 0 et 1 0                 piece et verif = false
    @Test
    public void testVerifSides14() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(18, 18);
List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);        assertTrue(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides15() {
        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 19);
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        Color color = piece.getColor();
        position = new Position(19, 18);
List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);        assertFalse(isOk);
    }

//     pos 0 0 et 1 1                  piece et verif = true
    @Test
    public void testVerifSides16() {

        Game game = new Game();
        game.nextPlayer();
        game.nextPlayer();
        game.nextPlayer();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(19, 19);
        Color color = piece.getColor();
        game.setPieceSelected(1);
        board.addPiece(game, piece, position);
        position = new Position(17, 17);
List <Position>listPos = piece.getListPos(position);
        boolean isOk = board.verifSides(listPos, color);        assertTrue(isOk);
    }

//    ------------------------ verifPosPiece ------------------------
//     0 0 piece 2 on 2 verif with piece 3  pos 1 1, 1 2, 1 3 = false
    @Test
    public void testVerifPosPiece1() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        game.setPieceSelected(8);
        board.addPiece(game, piece, position);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(board.getBoardPiece(i, j));
            }
            System.out.println("");
        }
        position = new Position(1, 1);
        game.setPieceSelected(2);
        boolean isOk = board.verifPosPieceIsNull(game.getPieceSelected().getListPos(position));
        assertFalse(isOk);
    }

//     0 0 piece 2 ( 0 0 - 0 1 - 1 0 - 1 1 ) on 2 verif with piece 3  pos 2 1, 2 2, 2 3 = true
    @Test
    public void testVerifPosPiece2() {

        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        game.setPieceSelected(8);
        board.addPiece(game, piece, position);
        position = new Position(2, 2);
        game.setPieceSelected(2);
        boolean isOk = board.verifPosPieceIsNull(game.getPieceSelected().getListPos(position));
        assertTrue(isOk);
    }

//     0 0 piece 2 ( 0 0 - 0 1 - 1 0 - 1 1 ) on 2 verif with piece 3  pos 2 1, 2 2, 2 3 = true
    @Test
    public void testVerifPosPiece3() {

        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        game.setPieceSelected(10);
        board.addPiece(game, piece, position);
        position = new Position(2, 2);
        game.setPieceSelected(2);
        boolean isOk = board.verifPosPieceIsNull(game.getPieceSelected().getListPos(position));
        assertTrue(isOk);
    }

//     0 0 piece 2 ( 0 0 - 0 1 - 1 0 - 1 1 ) on 2 verif with piece 3  pos 19 19 - 20 19 - 21 19 (out) bas droite = false
    @Test
    public void testVerifPosPiece4() {

        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        game.setPieceSelected(10);
        board.addPiece(game, piece, position);

        position = new Position(0, 3);
        game.setPieceSelected(2);
        boolean isOk = board.verifPosPieceIsNull(game.getPieceSelected().getListPos(position));
        assertFalse(isOk);
    }

//     0 0 piece 2 ( 0 0 - 0 1 - 1 0 - 1 1 ) on 2 verif with piece 3  pos 19 0 - 19 1 - 19 2 (haut droit) = false
    @Test
    public void testVerifPosPiece5() {

        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        game.setPieceSelected(8);
        board.addPiece(game, piece, position);
        position = new Position(19, 0);
        game.setPieceSelected(2);
        boolean isOk = board.verifPosPieceIsNull(game.getPieceSelected().getListPos(position));
        assertTrue(isOk);
    }

//     0 0 piece 2 ( 0 0 - 0 1 - 1 0 - 1 1 ) on 2 verif with piece 3  pos 0 19 - 0 20 - 0 21 (out) bas gauche = false
    @Test
    public void testVerifPosPiece6() {

        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(0);
        Position position = new Position(0, 0);
        game.setPieceSelected(8);
        board.addPiece(game, piece, position);
        position = new Position(0, 18);
        game.setPieceSelected(2);
        boolean isOk = board.verifPosPieceIsNull(game.getPieceSelected().getListPos(position));
        assertTrue(isOk);
    }

// ------------------------ verifCorners && verifSides ------------------------
    /* 
    
    1 2
    1 2
    1 2
    1
    
     */
    @Test
    public void testverifConersAndVerifSides1() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(9);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(10);
        board.addPiece(game, piece, position);
        piece = game.getCurrentPlayer().getStock().getPiece(10);

        position = new Position(1, 0);
        game.setPieceSelected(3);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = (board.verifCorners(listPos, color) && board.verifSides(listPos, color));
        assertFalse(isOk);
    }

    /*
    
    1
    1
    1
    1 
      2 2
      2 2
    
     */
    @Test
    public void testverifConersAndVerifSides2() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(9);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(10);
        board.addPiece(game, piece, position);
        piece = game.getCurrentPlayer().getStock().getPiece(10);

        position = new Position(1, 4);
        game.setPieceSelected(8);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = (board.verifCorners(listPos, color) && board.verifSides(listPos, color));
        assertTrue(isOk);
    }

    /*
    1
    1
    1
    1 2 2
      2 2
     */
    @Test
    public void testverifConersAndVerifSides3() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(9);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(10);
        board.addPiece(game, piece, position);
        piece = game.getCurrentPlayer().getStock().getPiece(10);

        position = new Position(1, 3);
        game.setPieceSelected(8);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = (board.verifCorners(listPos, color) && board.verifSides(listPos, color));
        assertFalse(isOk);
    }

    /*
    1
    1
    1
    1 
      2 2
      2 2
    
     */
    @Test
    public void testverifConersAndVerifSides4() {
        Game game = new Game();
        Board board = game.getBoard();
        Piece piece = game.getCurrentPlayer().getStock().getPiece(9);
        Position position = new Position(0, 0);
        Color color = piece.getColor();
        game.setPieceSelected(10);
        board.addPiece(game, piece, position);
        piece = game.getCurrentPlayer().getStock().getPiece(10);

        position = new Position(1, 4);
        game.setPieceSelected(8);
        List<Position> listPos = piece.getListPos(position);
        boolean isOk = (board.verifCorners(listPos, color) && board.verifSides(listPos, color));
        assertTrue(isOk);
    }

//    ------------------------ verifPosPiece &&  ------------------------
}
