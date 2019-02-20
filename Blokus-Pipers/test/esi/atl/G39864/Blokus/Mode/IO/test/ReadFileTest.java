package esi.atl.g39864.blokus.mode.io.test;

import esi.atl.G39864.blokus.Model.IO.ReadFile;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Stock;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * this class test the method of ReadFile 
 * @author chris home
 */
public class ReadFileTest {
    
    /**
     * this test, verify if the constructor construct 21 Pieces
     */
    @Test
    public void testConstructorReadFile () 
    {
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        List <Piece> listPiece = stock.getListOfStock();
        assertTrue(listPiece.size()==21);
    }

    /**
     * this test verify if the method ReadFile create a Stock of 21 Pieces 
     */
    @Test
    public void testReadFileSize()
    {
       
        ReadFile read = new ReadFile();
        Stock stock1 = new Stock(read.stockPieces(3));
        int sizeStock = stock1.getSize();
        assertEquals(sizeStock, 21);
    }
   
    /**
     * this test verify if the method readFile read correctly the file text
     * and verify if the first line is well read
     */
    @Test
    public void testReadFileTxt0() {
        ReadFile read = new ReadFile();
        List<String> listLineFile = new ArrayList<>();
        listLineFile = read.getListStock();
        String firstLineFile =listLineFile.get(0);
        String firstLineTest = "1";
        assertEquals(firstLineTest, firstLineFile);
    }

    /**
     * this test verify if the method readFile read correctly the file text
     * and verify if the last line is well read
     */
    @Test
    public void testReadFileTxt104() {
        ReadFile read = new ReadFile();
        
        Stock stock = read.getStock(0);
        List<String> file = new ArrayList<>();
        file = read.getListStock();
        String firstLineFile = file.get(104);
        String firstLineTest = "OOOO";
        assertEquals(firstLineTest, firstLineFile);
    }

    /**
     * this test verify if the method stockPieces creat a List of Pieces
     * and test the first Piece
     */
    @Test
    public void testStockPieces1() {
       
        boolean argCorrect = true;
        int i = 0;
        int j = 0;
        ReadFile read = new ReadFile();
        Stock stock = new Stock(read.stockPieces(1));
//        Piece piece = stock.getPiece(1,stock.getListOfStock());
        boolean [][] tab = {{true, false, false, false},
                                {false, false, false, false},
                                    {false, false, false, false},
                                        {false, false, false, false}};
//        boolean [][] tab2 = piece.getTabPiece();
        
        for (boolean[] bs : tab) {
            for (boolean b : bs) {
                if(b != tab[j][i])
                {
                    argCorrect = false;
                    break;
                }
                j++;
            }
            j=0;
            i++;
        }
//        if ( (piece.getNumberPiece()!= 1)  )
        {
            argCorrect =  false;
        }
        assertTrue(argCorrect== true);
    }
    
    // voir si faut tester color et isPlaced dans les methodes de test de piece.
    
   /**
     * this test verify if the Piece 21 of Stock is well implemented
     * verify the form of Piece and her number
     */
    @Test
    public void testStockPieces21() {
        
        
        boolean argCorrect = true;
        int i = 0;
        int j = 0;
        ReadFile read = new ReadFile();
        Stock stock = new Stock(read.stockPieces(2));
//        Piece piece = stock.getPiece(21,stock.getListOfStock());
        boolean [][] tab = {{false, true, false, false},
                                {true, true, true, false},
                                    {false, true, false, false},
                                        {false, false, false, false}};
//        boolean [][] tab2 = piece.getTabPiece();
        
        for (boolean[] bs : tab) {
            for (boolean b : bs) {
                if(b != tab[j][i])
                {
                    argCorrect = false;
                    break;
                }
                j++;
            }
            j=0;
            i++;
        }
//        if ( (piece.getNumberPiece()!= 21)  )
        {
            argCorrect =  false;
        }
        assertTrue(argCorrect== true);
    }
    
   /**
    * this test verify if the Piece 1 of Stock is well implemented
     * verify the form of Piece and her number
    */
    @Test
    public void testGetStockGetPiece1()
    {
        boolean argCorrect = true;
        int i = 0;
        int j = 0;
        ReadFile read = new ReadFile();
        Stock stock = read.getStock(0);
        List <Piece> listPiece = stock.getListOfStock();
//        Piece piece = stock.getPiece(1,stock.getListOfStock());
        boolean [][] tab = {{true, false, false, false},
                                {false, false, false, false},
                                    {false, false, false, false},
                                        {false, false, false, false}};
//        boolean [][] tab2 = piece.getTabPiece();
        
        for (boolean[] bs : tab) {
            for (boolean b : bs) {
                if(b != tab[j][i])
                {
                    argCorrect = false;
                    break;
                }
                j++;
            }
            j=0;
            i++;
        }
//        if ( (piece.getNumberPiece()!= 1)  )
        {
            argCorrect =  false;
        }
        assertTrue(argCorrect== true);
    }
    
}
