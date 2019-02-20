//package esi.atl.G39864.blokus.ia.model;
//
//import esi.atl.gg39864.blokus.model.Board;
//import esi.atl.gg39864.blokus.model.Game;
//import esi.atl.gg39864.blokus.model.Piece;
//import esi.atl.gg39864.blokus.model.Player;
//import esi.atl.gg39864.blokus.model.Position;
//import esi.atl.gg39864.blokus.model.Stock;
//import java.util.List;
//import java.util.Objects;
//import java.util.Random;
//
///**
// *
// * @author chris home
// */
//public class PlayIAMostScore implements Strategy {
//
//    private List<Position> listEachPosFree;
//    private Board board;
//    private Game game;
//
//    public PlayIAMostScore(Game game) {
//        this.board = game.getBoard();
//        System.out.println("playIa");
//        System.out.println(game.getCurrentPlayer().getNumber());
//        if (game.getCurrentPlayer().getScorePlayer().getScore() == 0) {
//            addFirstPiece(game);
//            
//        } else {
//            AnalyzePos analyzePos = new AnalyzePos(game);
//            listEachPosFree = analyzePos.getListEachPosFree();
//            testToAddToEachPosToAddPiece(game);
//        }
//
//    }
//
//    public void addFirstPiece(Game game) {
//        int max = 20;           // not 21 because this piece cannot be placed in the conners
//        int min = 1;
////        int nbPiece = (int) (Math.random() * ((max - min) + 1));
////        System.out.println(nbPiece);
//Player player = game.getCurrentPlayer();
//        Stock stock = game.getCurrentPlayer().getStock();
//        Piece piece = stock.getPiece(1);
//        System.out.println(piece.toString());
//        Position position = player.getStartPosition();
//        game.setPieceSelected(1);
//        game.setPositionSelected(position);
//        System.out.println(position.toString());
//        System.out.println("play ia in ");
//        game.play();
//        System.out.println("is bug ? ");
//        game.resetPieceSelected();
//       
//    }
//    
//    
//
//    public void testToAddToEachPosToAddPiece(Game game) {
//        boolean addPossible = false;
//        int nbTurn;
//
//        Piece piece;
//        for (Position position : listEachPosFree) {
//            Stock stock = game.getCurrentPlayer().getStock();
//            for (int i = 21; i > 0; i--) {
//                if (Objects.nonNull(stock.getPiece(i))){
//                nbTurn = 0;
//                piece = stock.getPiece(i);
//                game.setPieceSelected(i);
//                    System.out.println(game.getPieceSelected().toString());
//                if (Objects.nonNull(stock.getPiece(i))) {
//                    while (!addPossible && (nbTurn < 4)) {
//                        addPossible = board.addPiece(game, piece, position);
//                        if (!addPossible) {
//                            piece.mirrorPiece();
//                            addPossible = board.addPiece(game, piece, position);
//                        } 
//                        if (!addPossible) {
//                            nbTurn++;
//                            piece.rotationPiece();
//                        }
//                    }
//                }
//                }
//            }
//        }
//        System.out.println(addPossible);
//        if (!addPossible) {
//            game.getCurrentPlayer().setIsBlocked();
//        }
//        game.nextPlayer();
//
//    }
//
//    @Override
//    public void playIa(Game game) {
//        PlayIAMostScore playIA = new PlayIAMostScore(game);
//        playIA.testToAddToEachPosToAddPiece(game);
//    }
//}
