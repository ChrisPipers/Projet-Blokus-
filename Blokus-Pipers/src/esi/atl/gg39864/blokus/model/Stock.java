package esi.atl.gg39864.blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * this class allows to build a Stock
 *
 * @author Chris
 */
public class Stock {

    protected List<Piece> pieces = new ArrayList<>();

    /**
     * this is the constructor of the class Stock , he build a Stock with a List
     *
     * @param pieces is the parameter necessary to build a Stock
     */
    public Stock(List<Piece> pieces) {
        this.pieces = pieces;
    }

    /**
     * this method allows to delete a Piece of a Stock if she is placed
     *
     * @param piece is the Piece to replaced of the Stock by a piece null
     */
    public void delPieceStock(Piece piece) {
        this.pieces.set(piece.getNumberPiece() - 1, new Piece());
    }

    /**
     * this method allows to add a Piece in a Stock
     *
     * @param piece is the Piece to add to the stock.
     */
    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    /**
     * this method return the size of a Stock
     *
     * @return an Integer of the size of the Stock
     */
    public int getSize() {
        return this.pieces.size();
    }

//    public List<Piece> getListStock(){
//        return 
//    }
    /**
     * this method return the list of a Stock
     *
     * @return a list of a Stock
     */
    public List getListOfStock() {
        return this.pieces;
    }

    /**
     * this method return a Piece number i of a Stock
     *
     * @param i is the number of the Piece in the Stock to return
     * @return the Piece where the number is i of the Stock
     */
    public Piece getPiece(int i) {
        return pieces.get(i);
    }

}
