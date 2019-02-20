/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.G39864.blokus.ia.model;

import esi.atl.gg39864.blokus.model.Game;

/**
 *
 * @author chris home
 */
public class Context {

    private Strategy strategy;

    public void setStrategy(PlayIARandom strategy) {
        this.strategy = strategy;
    }

    public void playStrategie(Game game) {
        strategy = new PlayIARandom(game);
        strategy.playIa(game);

    }

}
