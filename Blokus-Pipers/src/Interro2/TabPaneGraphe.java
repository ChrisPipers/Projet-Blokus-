/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interro2;

import esi.atl.gg39864.blokus.model.Game;
import javafx.scene.control.TabPane;

/**
 *
 * @author G39864
 */
public class TabPaneGraphe extends TabPane {

   
    private Game game;

    /**
     * this is the constructor of the tabPaneGraphe 
     * @param game 
     */
    public TabPaneGraphe(Game game) {
        this.game = game;
        GrapheScore grapheScore = new GrapheScore(game);
        int scorePlayer1 = game.getListPlayer().get(0).getScorePlayer().getScore();
        int scorePlayer2 = game.getListPlayer().get(1).getScorePlayer().getScore();

        int scorePlayer3 = game.getListPlayer().get(2).getScorePlayer().getScore();

        int scorePlayer4 = game.getListPlayer().get(3).getScorePlayer().getScore();

        this.getTabs().add(grapheScore);
        game.addObserver(grapheScore);
    }

}
