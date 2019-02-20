package esi.atl.G39864.Blokus.Model.test;

import esi.atl.G39864.blokus.Model.IO.ReadFile;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Stock;
import esi.atl.gg39864.blokus.model.Position;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  this class test the method of the class piece
 * @author Chris
 */
public class PieceTest {

    @Test
    public void testPiece() {
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(2);
        List<Piece> listPiece = stock.getListOfStock();
        Piece piece = listPiece.get(20);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(piece.getPosPiece(i, j));
            }
            System.out.print("\n");
        }
    }

    @Test
    public void testListPiece() {
        boolean isEguals = true;
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(2);
        List<Piece> listPiece = stock.getListOfStock();

        Piece piece = listPiece.get(0);
        Position position1 = new Position(5, 5);
        List<Position> listPos = piece.getListPos(position1);

        for (Position pos : listPos) {
            System.out.println(pos.getI() + " " + pos.getJ());
        }
        if (!(listPos.size() == 1) && !(listPos.get(0) == position1)) {
            isEguals = false;
        }

        assertTrue(isEguals);
    }

}
