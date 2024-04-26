/*
 * Add obstacles every 20 points
 */

package model.strategyPattern;

import controller.App;
import model.GameModel;

public class HardModeStrategy implements StrategyPattern{

    private GameModel model;  

    public HardModeStrategy(GameModel model){
        this.model = model;
    } 

    @Override
    public void play() {
    }


}
