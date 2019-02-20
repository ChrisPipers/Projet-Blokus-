package esi.atl.G39864.blokus.view.javaFx;

import esi.atl.gg39864.blokus.model.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this class allows to launch the javaFx application
 *
 * @author Chris
 */
public class launchFx extends Application {

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        VBoxGlobal vBoxGlo = new VBoxGlobal(game);
        Scene scene = new Scene(vBoxGlo, 1000, 750);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Blokus Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * this method allows to lunch the java fx
     *
     * @param game is the parameter necessary to build the windows of the game
     */
    public static void main(String[] game) {
        launch(game);
    }

}
