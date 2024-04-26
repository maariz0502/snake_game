package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStatePaused implements GameState {

    public GameStatePaused(){
        App.win.startPauseButton.setText(AppWindow.START_ACTION);
        App.win.restartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
        App.win.easyModeButton.setEnabled(false);
        App.win.hardModeButton.setEnabled(false);
    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void animate() {

    }
    
}
