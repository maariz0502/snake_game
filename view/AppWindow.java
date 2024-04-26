package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.App;
import controller.ButtonPressListener;
import controller.KeyPressListener;
import controller.StrategySelectionListener;
import model.strategyPattern.EasyModeStrategy;
import model.strategyPattern.HardModeStrategy;
import view.statePattern.GameState;
import view.statePattern.GameStateInit;

public class AppWindow extends JFrame{
    
    private AppCanvas canvas;
    public static final int GRID_SIZE = 20;

    public JButton startPauseButton;
    public JButton restartButton;
    public JButton exitButton;
    public JRadioButton easyModeButton;
    public JRadioButton hardModeButton;

    public static final String START_ACTION = "Start";
    public static final String PAUSE_ACTION = "Pause";
    public static final String RESTART_ACTION = "App Restart";
    public static final String EXIT_ACTION = "Exit";
    public static final String EASY_ACTION = "Easy Mode";
    public static final String HARD_ACTION = "Hard Mode"; 

    private GameState gameState;


    public void init(){
        Container cp = getContentPane();
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);

        

        JPanel southPanel = new JPanel();
        JPanel actionPanel = new JPanel();
        JPanel strategyPanel = new JPanel();
        easyModeButton = new JRadioButton(EASY_ACTION, App.model.getStrategy() instanceof  EasyModeStrategy);
        hardModeButton = new JRadioButton(HARD_ACTION, App.model.getStrategy() instanceof  HardModeStrategy);
        startPauseButton = new JButton(START_ACTION);
        restartButton = new JButton(RESTART_ACTION);
        exitButton = new JButton(EXIT_ACTION);

        strategyPanel.add(easyModeButton);
        strategyPanel.add(hardModeButton);
        actionPanel.add(startPauseButton);
        actionPanel.add(restartButton);
        actionPanel.add(exitButton);
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(strategyPanel);
        southPanel.add(actionPanel);

        ButtonGroup strategyButtonGroup = new ButtonGroup();
        strategyButtonGroup.add(easyModeButton);
        strategyButtonGroup.add(hardModeButton);

        cp.add(BorderLayout.SOUTH, southPanel);

        ButtonPressListener buttonPressListener = new ButtonPressListener();
        StrategySelectionListener strategySelectionListener = new StrategySelectionListener();
        easyModeButton.addActionListener(strategySelectionListener);
        hardModeButton.addActionListener(strategySelectionListener);
        startPauseButton.addActionListener(buttonPressListener);
        restartButton.addActionListener(buttonPressListener);
        exitButton.addActionListener(buttonPressListener);

        KeyPressListener keyPressListener = new KeyPressListener();
        canvas.addKeyListener(keyPressListener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);

        // disable focusable in all other GUI components
        startPauseButton.setFocusable(false);
        restartButton.setFocusable(false);
        exitButton.setFocusable(false);
        easyModeButton.setFocusable(false);
        hardModeButton.setFocusable(false);


        gameState = new GameStateInit();
    }

    public void goNextState(){
        gameState.goNext(this);
    }

    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public AppCanvas getCanvas() {
        return canvas;
    }
}
