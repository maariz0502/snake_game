package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStateOver implements GameState{

    public GameStateOver(){
        App.model.obstacle.clear();
        App.win.restartButton.setEnabled(true);
        App.win.startPauseButton.setEnabled(false);
        App.win.easyModeButton.setEnabled(false);
        App.win.hardModeButton.setEnabled(false);
    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateInit());
    }

    @Override
    public void animate() {
        App.model.snake.falling();
    }
    
}
