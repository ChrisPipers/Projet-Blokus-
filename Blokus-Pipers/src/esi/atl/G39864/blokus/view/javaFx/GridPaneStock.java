package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Stock;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * this mehtod allows to build the gridpanestock container each stock and
 * information on each player
 *
 * @author chris home
 */
public class GridPaneStock extends GridPane {

    private final GridPanePieces gridPanePieces;
    private final List<GridPane> listGridPanePieces;
    private final int numGrid;

    public GridPaneStock(Game game, int numPlayer, int numGrid) {
        listGridPanePieces = new ArrayList<>();
        this.numGrid = numGrid;
        gridPanePieces = new GridPanePieces();
        Stock stock = game.getListPlayer().get(numPlayer).getStock();
        List<Piece> listPiece = stock.getListOfStock();
        for (int i = 0; i < 7; i++) {
            ColumnConstraints column = new ColumnConstraints(7, 40, 60);
            this.getColumnConstraints().add(column);
        }
        for (int j = 0; j < 3; j++) {
            RowConstraints row = new RowConstraints(3, 40, 60);
            this.getRowConstraints().add(row);
        }
        int nbPiece = 0;
        int temp = 1;

        for (int m = 0; m < 7; m++) {
            for (int numLigne = 0; numLigne < 3; numLigne++) {
                Piece piece = listPiece.get(nbPiece);
                int numGridPane = temp;
                temp++;
                piece = listPiece.get(nbPiece);

                this.add(gridPanePieces.gridpanePiece(piece, numGridPane, game), m, numLigne);
                listGridPanePieces.add(gridPanePieces.gridpanePiece(piece, numGridPane, game));
                nbPiece++;
            }
        }

        this.setHgap(5.0);
        this.setVgap(5.0);

    }

    /**
     * this method allows to return the gridPaneStock
     *
     * @return the gridPaneStock of the class
     */
    public List<GridPane> getGridPaneStock() {
        return this.listGridPanePieces;
    }

}
