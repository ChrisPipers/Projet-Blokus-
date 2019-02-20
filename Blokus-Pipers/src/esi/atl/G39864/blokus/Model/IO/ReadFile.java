package esi.atl.G39864.blokus.Model.IO;

import esi.atl.gg39864.blokus.model.Color;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Position;
import esi.atl.gg39864.blokus.model.Stock;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * this class read a file text and creat a Stock of Piece whit the information
 * inside of the file text
 *
 * @author Chris
 */
public class ReadFile {

    private final List<Stock> listStock = new ArrayList<>();
    private List<String> listPiecesString = new ArrayList<>(); 
    /**
     * this is the constructor with a Stock
     */
    public ReadFile() {
        readFileTxt();
        for (int i = 0; i < 4; i++) {
            List<Piece> listPiece = stockPieces(i);
            Stock stock = new Stock(listPiece);
            this.listStock.add(stock);
        }
    }

    /**
     * this method read a file text, each line of the file text are a element of
     * the list
     *
     * @return a list of String with each line of the file text
     */
    public void readFileTxt() {
        String ligne;
        try {
            InputStream flux = new FileInputStream("BlokusPiece.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            while ((ligne = buff.readLine()) != null) {
                listPiecesString.add(ligne);
            }
            buff.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }

    /**
     * this method creat a List of Piece
     *
     * @param col is the Color of the Piece of the List
     * @return a List of Piece
     */
    public List stockPieces(int col) {
        int size = 0;
        Color charColor = null;
        List<Piece> listPieces = new ArrayList<>();
        List<Position> listPosPiece;
        int nbLineTab = 0;
        int nbLineFile = 0;
        int numPiece = 0;
        listPosPiece = new ArrayList<>();
        boolean[][] tabPiece = null;
        Position position = null;

        for (String line : listPiecesString) {
            listPosPiece = new ArrayList<>();
            if (nbLineFile % 5 == 0) {
                nbLineFile = 0;
                nbLineTab = 0;
                tabPiece = new boolean[4][4];
                numPiece = Integer.parseInt(line);
            } else {
                for (int i = 0; i < 4; i++) {
                    if (line.charAt(i) == 'X') {
                        tabPiece[nbLineTab][i] = true;
                        Position pos = new Position(nbLineTab, i);
                        size += 1;
                        listPosPiece.add(pos);
                    } else {
                        tabPiece[nbLineTab][i] = false;
                    }
                }
                nbLineTab++;
            }
            
            nbLineFile++;
            if (nbLineFile == 5) {
                for (int i = 0; i < 4; i++) {
                    if (tabPiece[i][0] == true) {
                        position = new Position(i, 0);
                        break;
                    }
                }
                charColor = getColorPiece(col);
                Piece piece = new Piece(tabPiece, numPiece, charColor, size);
                size = 0;
                listPieces.add(piece);
            }
            int nb = 0;
        }
        return listPieces;
    }

    public Color getColorPiece(int col) {
        Color charColor = null;
        Color color = null;
        switch (col) {
            case 0:
                charColor = color.BLUE;
                break;
            case 1:
                charColor = color.YELLOW;
                break;
            case 2:
                charColor = color.RED;
                break;
            case 3:
                charColor = color.GREEN;
                break;
        }
        return charColor;
    }

    /**
     * this method return a List of Stock of Piece
     *
     * @return a Stock of Piece
     */
    public List getListStock() {
        return this.listStock;
    }

    /**
     * this method return a Stock of a List of Stock
     *
     * @param i is the number of the Stock to select
     * @return the Stock number i of the List of Stock
     */
    public Stock getStock(int i) {
        return this.listStock.get(i);
    }
}
