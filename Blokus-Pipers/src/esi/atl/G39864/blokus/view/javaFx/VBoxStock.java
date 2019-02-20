package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Stock;
import java.util.List;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * this class allows to build the vbox container four gridPaneStock
 * @author chris home
 */
public class VBoxStock extends VBox {

    private final GridPaneStock gridPaneStock;
    private final List<GridPane> listGridPaneStock;

    /**
     * this method allows to build the vbox container four gridPaneStock
     * @param game is the parameter necessary for create each geirPaneStock
     * @param stock is the parameter necessary for create each geirPaneStock
     * @param i is used for numbered the gridPaneStock and know the number of stock 
     * used for build it
     */
    public VBoxStock(Game game, Stock stock, int i) {
        gridPaneStock = new GridPaneStock(game, i, i);
        listGridPaneStock = gridPaneStock.getGridPaneStock();
        this.getChildren().add(gridPaneStock);
    }

    /**
     * this method allows to return the gridPane stock used when the player 
     * chose her piece in the stock
     * @return 
     */
    public List<GridPane> getGridPaneStockPieces() {
        return this.listGridPaneStock;
    }

}
