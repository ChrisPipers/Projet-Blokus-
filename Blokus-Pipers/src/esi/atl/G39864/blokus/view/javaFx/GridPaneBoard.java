package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Board;
import esi.atl.gg39864.blokus.model.Game;
import esi.atl.gg39864.blokus.model.Piece;
import esi.atl.gg39864.blokus.model.Position;
import javafx.event.Event;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import esi.atl.G39864.blokus.mvc1.Observer;
import esi.atl.gg39864.blokus.model.Color;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * this class allows to build the GridPane who represent the Board of the game
 *
 * @author chris home
 */
public final class GridPaneBoard extends GridPane implements Observer {

    private final Game game;
    private GridPane gridBoard;
    private final Region[][] tabRegion = new Region[20][20];
    private List<Region> listRegionSave;

    /**
     * this method build the GridPane who represent the Board of the game with a
     * Game
     *
     * @param game is the parameter for build the Board of the game
     */
    public GridPaneBoard(Game game) {
        this.game = game;
        gridPaneBoardStructur();
        this.getChildren().add(gridBoard);
        update();
        game.addObserver(this);
    }

    /**
     * this method initialize the size of the GridPane of the Board and call the
     * method coloredGridpaneBoard for colored him
     */
    public void gridPaneBoardStructur() {
        gridBoard = new GridPane();
        gridBoard.prefHeight(1.0);
        gridBoard.prefWidth(1.0);
        Board board = game.getBoard();
        gridBoard.setMinSize(18.0, 18.0);
        for (int i = 0; i < board.getWidth(); i++) {
            ColumnConstraints column = new ColumnConstraints(20, 32, 32);
            gridBoard.getColumnConstraints().add(column);
        }
        for (int j = 0; j < board.getLength(); j++) {
            RowConstraints row = new RowConstraints(20, 32, 32);
            gridBoard.getRowConstraints().add(row);
        }
        initBoardRegions();
        refreshBoard();
    }

    /**
     * this method colored the different playground of the Board
     */
    public void initBoardRegions() {
        Board board = game.getBoard();
        gridBoard.setGridLinesVisible(true);
        for (int i = 0; i < board.getWidth(); i++) {
            final int l = i;
            for (int j = 0; j < board.getLength(); j++) {
                final int k = j;
                final Region region = new Region();
                tabRegion[j][i] = region;
                listRegionSave = new ArrayList<>();
                region.setOnMouseEntered(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        if (game.getPieceSelected() != null) {
                            game.getPieceSelected().resetListPos();
                            if (game.getBoard().isAddPossible(game.getPieceSelected().getListPos(new Position(l, k)), game.getPieceSelected().getColor())) {

                                for (Position position : game.getPieceSelected().getListPos(new Position(l, k))) {
                                    if (!(position.getI() < 0 || position.getI() > 19 || position.getJ() < 0 || position.getJ() > 19 || game.getPieceSelected() == null)) {
                                        listRegionSave.add(tabRegion[position.getJ()][position.getI()]);
                                        String color = getColorCanBePlaced();
                                        tabRegion[position.getJ()][position.getI()].setStyle("-fx-background-color: " + color + " ;-fx-border-color: white;");
                                    }
                                }
                            } else {
                                for (Position position : game.getPieceSelected().getListPos(new Position(l, k))) {
                                    if (!(position.getI() < 0 || position.getI() > 19 || position.getJ() < 0 || position.getJ() > 19 || game.getPieceSelected() == null)) {
                                        listRegionSave.add(tabRegion[position.getJ()][position.getI()]);
                                        String color = getColorCanNotBePlaced();
                                        tabRegion[position.getJ()][position.getI()].setStyle("-fx-background-color: " + color + " ;-fx-border-color: white;");
                                    }
                                }
                                
                                
                                
                                
                            }
                        }
                    }
                });

                region.setOnMouseExited(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        if (game.getPieceSelected() != null) {
                            for (Position position : game.getPieceSelected().getListPos(new Position(l, k))) {
                                if (!(position.getI() < 0 || position.getI() > 19 || position.getJ() < 0 || position.getJ() > 19)) {
                                    for (Region regionSave : listRegionSave) {

                                        tabRegion[position.getJ()][position.getI()].setStyle(regionSave.getStyle());
                                        refreshBoard();
                                    }
                                }
                            }
                        }
                    }
                });
                listRegionSave.clear();

                region.setOnMouseClicked(new EventHandler() {
                    boolean add = false;

                    public void handle(Event event) {
                        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                            if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
                                game.tournePiece();
                            } else {
                                game.setPositionSelected(new Position(l, k));

                                add = game.play();
                            }
                        }
                    }
                });

                if (game.getBoard().getBoardPiece(i, j) == null) {
                    region.setStyle("-fx-background-color: black;-fx-border-color: white;");
                    gridBoard.add(region, i, j, 1, 1);
                }
            }
        }
    }

    /**
     * this method allows to refresh the board when the board have one of change
     */
    public void refreshBoard() {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (game.getBoard().getBoardPiece(i, j) == null) {
                    tabRegion[i][j].setStyle("-fx-background-color: black;-fx-border-color: white;");
                } else {
                    switch (game.getBoard().getBoardPiece(i, j).getColor()) {
                        case RED:
                            tabRegion[i][j].setStyle("-fx-background-color: red;-fx-border-color: white;");
                            break;
                        case BLUE:
                            tabRegion[i][j].setStyle("-fx-background-color: blue;-fx-border-color: white;");
                            break;
                        case YELLOW:
                            tabRegion[i][j].setStyle("-fx-background-color: yellow;-fx-border-color: white;");
                            break;
                        case GREEN:
                            tabRegion[i][j].setStyle("-fx-background-color: green;-fx-border-color: white;");

                            break;
                    }
                }
            }
        }

    }

    /**
     * this method allows to activate the refresh of the board
     */
    @Override
    public void update() {
        refreshBoard();
    }

    /**
     * this method allows to change the shadows according with the color of the
     * player
     *
     * @return a string container the color of the shadow of the color of the
     * player
     */
    public String getColorCanNotBePlaced() {
        String color = null;
        switch (game.getCurrentPlayer().getNumber()) {
            case 0:
                color = "rgba(0, 0, 255, .4)";
                break;
            case 1:
                color = "rgba(255, 255, 0, .4)";
                break;
            case 2:
                color = "rgba(255, 0, 0, .4)";
                break;
            case 3:
                color = "rgba(0, 255, 0, .4)";
                break;
        }
        return color;
    }
    
    
    
    /**
     * this method allows to change the shadows according with the color of the
     * player
     *
     * @return a string container the color of the shadow of the color of the
     * player
     */
    public String getColorCanBePlaced() {
        String color = null;
        switch (game.getCurrentPlayer().getNumber()) {
            case 0:
                color = "rgba(0, 0, 255)";
                break;
            case 1:
                color = "rgba(255, 255, 0)";
                break;
            case 2:
                color = "rgba(255, 0, 0)";
                break;
            case 3:
                color = "rgba(0, 255, 0)";
                break;
        }
        return color;
    }

}
