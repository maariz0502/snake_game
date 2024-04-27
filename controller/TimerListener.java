package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.observerPattern.SnakeEvent;
import view.statePattern.GameState;
import view.statePattern.GameStatePlaying;

public class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameState state = App.win.getGameState();
        state.animate();
        if(state instanceof GameStatePlaying){
            detectCollision();
        }
        App.win.getCanvas().repaint();

    }
    
    private void detectCollision(){
        // snake vs. food
        if(App.model.snakeGotFood()){
            App.model.snake.notifyObservers(SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }
        // snake vs. wall
        if(App.model.snakeLeftScene()){
            App.model.snake.notifyObservers(SnakeEvent.HIT_WALL);
        }
        // snake vs. self body
        if(App.model.snakeHitsItsBody()){
            App.model.snake.notifyObservers(SnakeEvent.HIT_SELF);
        }
        // snake vs. obstacle
        if(App.model.snakeHitsObstacle()){
            App.model.snake.notifyObservers(SnakeEvent.HIT_OBSTACLE);
        }
    }
}
