package esi.atl.G39864.blokus.view.javaFx;

import Interro2.GrapheScore;
import Interro2.TabPaneGraphe;
import esi.atl.gg39864.blokus.model.Game;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * this class allows to build the MenuBar of the game Blokus
 *
 * @author Chris
 */
public final class BarMenu extends MenuBar {

    private final Menu menuFile;
    private final Menu menuEdit;
    private final Menu menuHelp;
    private final Game game ;
    
    /**
     * this method build the MenuBar of the game Blokus with three Menu, File,
     * Edit and Help
     */
    public BarMenu(Game game) {
        this.game = game;
        menuFile = new Menu("File");
        menuFile.getItems().add(menuFile());
        menuEdit = new Menu("Edit");
        menuEdit.getItems().add(menuEdit(game));
        menuHelp = new Menu("Help");
        menuHelp.getItems().add(menuHelp());
        this.getMenus().addAll(menuFile, menuEdit, menuHelp);
    }

    /**
     * this method allows make the action exit for close the windows when the
     * menu exit is clicked
     *
     * @return a menu item for can make the action
     */
    public MenuItem menuFile() {
        MenuItem menuExit = new MenuItem("Exit");

        menuExit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });
        return menuExit;
    }

    /**
     * this method allows to make nothing for the moment
     *
     * @return a menu item for make nothing
     */
    public MenuItem menuEdit(Game game) {
        MenuItem menuEdit = new MenuItem("Edit");
        TabPaneGraphe tabGraphePane = new TabPaneGraphe(game);
        VBox vbox = new VBox(tabGraphePane);
        
        menuEdit.setOnAction((ActionEvent a) -> {
        Scene scene = new Scene(vbox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    
                
        });
        
        return menuEdit;
    }

    /**
     * this method allows to displayed the rule of the game when the menu help
     * is clicked
     *
     * @return
     */
    public MenuItem menuHelp() {
        MenuItem menuHelp = new MenuItem("Selected on Piece in the Stock on the left side"
                + "\n" + "place the first Piece in your conner "
                + "\n" + "for the next Piece she can only touching one another by one conner"
                + "\n" + "you have three solution, play one Piece, past or stop it ");
        return menuHelp;
    }

}
