/*
 * Add obstacles every 20 points (MAX 5 obstacles)
 * Make the snake faster
 */

package model.strategyPattern;

import java.awt.Color;

import javax.swing.Timer;

import controller.App;
import controller.TimerListener;
import model.GameModel;

public class HardModeStrategy implements StrategyPattern{

    private GameModel model;

    public HardModeStrategy(GameModel model){
        this.model = model;
        if(model.obstacle.size() > 0){
            model.obstacle.clear();
        }
        if(App.win.getCanvas() != null){
            App.win.getCanvas().snakeColor = Color.white;
        }
        App.timer = new Timer(1000/8, new TimerListener()); 
    } 

    @Override
    public void play() {
        if(model.score % 20 == 0){
            if(model.obstacle.size() >=5){
                model.obstacle.remove(0);
            }
            model.obstacle.add(model.createObstacle());
        }
    }


}
