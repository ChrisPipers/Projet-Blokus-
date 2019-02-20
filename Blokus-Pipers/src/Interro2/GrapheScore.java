package Interro2;

import esi.atl.G39864.blokus.mvc1.Observer;
import esi.atl.gg39864.blokus.model.Game;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;

/**
 * this class creat a graphe with the score of each player
 * @author G39864
 */
public class GrapheScore extends Tab implements Observer{

    private XYChart.Series player1;
    private XYChart.Series player2;
    private XYChart.Series player3;
    private XYChart.Series player4;
    private Game game;
    
    /**
     * this is the constructor of the graphe 
     * @param game 
     */
    public GrapheScore(Game game){
        this.game = game;
        this.graphe(game);
        game.addObserver(this);
    }
    
    /**
     * this is the constructor of each element of the graphe 
     * @param game 
     */
    public void graphe(Game game) {
        final NumberAxis xAxis = new NumberAxis(0,60,1);
        final NumberAxis yAxis = new NumberAxis(0,180,10);
        xAxis.setLabel("coup jouer");
        yAxis.setLabel("Score (points)");

        //creating the chart
        player1 = new XYChart.Series();
        player1.setName("joueur1");
        
        player2 = new XYChart.Series();
        player2.setName("joueur2");
        
        player3 = new XYChart.Series();
        player3.setName("joueur3");
        
        player4 = new XYChart.Series();
        player4.setName("joueur4");


        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.getData().addAll(player1, player2, player3, player4);
        lineChart.setTitle("Evolutuion des scores");
        this.setText("Evolutuion des scores");
        this.setContent(lineChart);
    }
    
    /**
     * this is the method to add each element after notification of the subject
     */
    public void addSerie() {
        
        switch(game.getCurrentPlayer().getNumber()){
            
            case 1 : player1.getData().add(game.getCurrentPlayer().getScorePlayer().getScore()); break;
            case 2 : player2.getData().add(game.getCurrentPlayer().getScorePlayer().getScore()); break;
            case 3 : player3.getData().add(game.getCurrentPlayer().getScorePlayer().getScore()); break;
            case 4 : player4.getData().add(game.getCurrentPlayer().getScorePlayer().getScore()); break;
        }
        
    }
    

    
    
    
    
    
    /**
     * this method allows to update the information after the notification of the game
     */
    @Override
    public void update() {
        addSerie();
    }
    
}
