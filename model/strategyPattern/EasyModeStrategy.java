package model.strategyPattern;

import controller.App;
import model.GameModel;

public class EasyModeStrategy implements StrategyPattern{

    private GameModel model;   

    public EasyModeStrategy(GameModel model){
        this.model = model;
    } 

 

    @Override
    public void play() {
    } 
}
