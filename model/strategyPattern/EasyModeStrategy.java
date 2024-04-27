package model.strategyPattern;
import javax.swing.Timer;

import controller.App;
import controller.TimerListener;
import model.GameModel;

public class EasyModeStrategy implements StrategyPattern{

    private GameModel model;   

    public EasyModeStrategy(GameModel model){
        this.model = model;
        if(model.obstacle.size() > 0){
            model.obstacle.clear();
        }
        App.timer = new Timer(1000/4, new TimerListener()); 
    } 
    
    @Override
    public void play() {
        if(model.obstacle.size() > 0){
            model.obstacle.clear();
        }
    } 
}
