package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStatePlaying implements GameState{

    public GameStatePlaying(){
        App.win.startPauseButton.setText(AppWindow.PAUSE_ACTION);
        App.win.restartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
        App.win.easyModeButton.setEnabled(false);
        App.win.hardModeButton.setEnabled(false);
    }

    @Override
    public void goNext(AppWindow context) {
        if(App.model.snakeHitsItsBody() || App.model.snakeLeftScene())
            context.setGameState(new GameStateOver());
        else
            context.setGameState(new GameStatePaused());    
    }

    @Override
    public void animate() {
        App.model.snake.move();
    }
    
}
