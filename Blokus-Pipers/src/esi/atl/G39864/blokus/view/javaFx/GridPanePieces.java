package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import esi.atl.gg39864.blokus.model.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this method allows to build the gridpanePiece for each piece of each stock of
 * each player
 *
 * @author Chris
 */
public class GridPanePieces extends GridPane {

    private int numGridPane;
    private List<Region> listRegion;

    /**
     * this method allows to build a gridpanepieces without parameter
     */
    public GridPanePieces() {
    }

    /**
     * this method build a GridPane with the Piece enter in parameter
     *
     * @param piece is the Piece to represent
     * @return a GridPane with the form of the Piece
     */
    public GridPane gridpanePiece(Piece piece, int numGridPane, Game game) {
        GridPane gridPiece = new GridPane();
        listRegion = new ArrayList<>();
        this.numGridPane = numGridPane;
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints(0, 10, 10);
            gridPiece.getColumnConstraints().add(column);
        }
        for (int j = 0; j < 4; j++) {
            RowConstraints row = new RowConstraints(0, 10, 10);
            gridPiece.getRowConstraints().add(row);
        }
        Color color = piece.getColor();
        
        boolean isColored = false;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                isColored = piece.getPosPiece(k, l);
                listRegion.add(coloredRegion(color, isColored));
                gridPiece.add(coloredRegion(color, isColored), l, k, 1, 1);
            }
        }
        gridPiece.setGridLinesVisible(true);
        gridPiece.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(piece.getColor().equals(game.getCurrentPlayer().getColor())){
                game.setPieceSelected(numGridPane);
                }
            }
        });

        return gridPiece;
    }

    /**
     * this method build a region for each playground of the GridPane of a
     * Piece
     *
     * @param color is the color of the Board[i][j]
     * @param isColored if the Board[i][j] haven't a color this parameter is at
     * true and if not is at false
     * @return a Region with the color of this position
     */
    public Region coloredRegion(Color color, boolean isColored) {
        Region region = new Region();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (isColored == false) {
                    region.setStyle("-fx-background-color: white;-fx-border-color: white;");
                } else {
                    switch (color.toString().substring(0, 1)) {
                        case "R":
                            region.setStyle("-fx-background-color: red;-fx-border-color: white;");
                            break;
                        case "B":
                            region.setStyle("-fx-background-color: blue;-fx-border-color: white;");
                            break;
                        case "Y":
                            region.setStyle("-fx-background-color: yellow;-fx-border-color: white;");
                            break;
                        case "G":
                            region.setStyle("-fx-background-color: green;-fx-border-color: white;");
                            break;
                    }
                }
            }
        }

        return region;
    }

}
