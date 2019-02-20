package esi.atl.G39864.blokus.ia.model;

import esi.atl.gg39864.blokus.model.Board;
import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Player;
import esi.atl.gg39864.blokus.model.Position;
import esi.atl.gg39864.blokus.model.Stock;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * this class allows to make play th ia according with the method random
 *
 * @author chris home
 */
public class PlayIARandom implements Strategy {

    private List<Position> listEachPosFree;
    private Board board;
    private Game game;
    public Piece pieceRandom;
    public Position positionRandom;

    public PlayIARandom(Game game) {
        this.board = game.getBoard();
        if (game.getCurrentPlayer().getScorePlayer().getScore() == 0) {
            addFirstPiece(game);
        } else {
            Piece piece = pieceRandom(game);
            AnalyzePos analyzePos = new AnalyzePos(game, piece);
//            listEachPosFree = analyzePos.getListEachPosFree();
//            testToAddToEachPosToAddPiece(game);
//            listEachPosFree.clear();
        }

    }

    public void addFirstPiece(Game game) {
        int max = 20;           // not 21 because this piece cannot be placed in the conners
        int min = 1;
        Player player = game.getCurrentPlayer();
        Stock stock = game.getCurrentPlayer().getStock();
        Piece piece = stock.getPiece(1);
        System.out.println(piece.toString());
        Position position = player.getStartPosition();
        game.setPieceSelected(1);
        game.setPositionSelected(position);
        game.play();
        game.resetPieceSelected();

    }

    public void testToAddToEachPosToAddPiece(Game game) {
//        System.out.println("boucleeeeeeeeeeeeeeeee     1111111111111111");
        boolean addPossible = false;
        int nbTurn = 0;
        Piece piece = pieceRandom(game);
        Position position = positionRandom(game);

        do {
            addPossible = board.addPiece(game, piece, position);
            if (!addPossible) {
                piece.mirrorPiece();
                addPossible = board.addPiece(game, piece, position);
            }
            if (!addPossible) {
                piece.rotationPiece();
                addPossible = board.addPiece(game, piece, position);
                nbTurn++;
            }
            System.out.println(addPossible);

        } while (!addPossible && (nbTurn < 4));
//        if (!addPossible) {
//            game.getCurrentPlayer().setIsBlocked();
//        }
////        game.nextPlayer();
    }

    public Piece pieceRandom(Game game) {
//        System.out.println("boubbbbbbbbcccccccccccclllllllleeeeeeeeee 222222222222");
        int min = 2;            // 2 because the one are placed            
        int max = 20;           // not 21 because this piece cannot be placed in the conners
        Piece piece;
        int numPieceRandom;
        do {
            numPieceRandom = (int) (Math.random() * ((max - min) + 1));
            System.out.println(numPieceRandom);
            Stock stock = game.getCurrentPlayer().getStock();
            piece = stock.getPiece(numPieceRandom);
        } while (Objects.isNull(piece));
        System.out.println(piece.toString());
        game.setPieceSelected(numPieceRandom);
        return piece;

    }

    public Position positionRandom(Game game) {
        int min = 0;
        int max = this.listEachPosFree.size();
        System.out.println("size of liste " + this.listEachPosFree.size());
        int numPosRandom = (int) (Math.random() * ((max - min) + 1));
        System.out.println(numPosRandom + " position romdom");

        Position position = this.listEachPosFree.get(numPosRandom);
        game.setPositionSelected(position);;
        return position;
    }

    @Override
    public void playIa(Game game) {
        PlayIARandom playIA = new PlayIARandom(game);
        playIA.testToAddToEachPosToAddPiece(game);
        game.nextPlayer();
    }
}
