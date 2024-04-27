package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import model.strategyPattern.EasyModeStrategy;
import model.strategyPattern.HardModeStrategy;
import view.AppWindow;

public class StrategySelectionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand();
        JRadioButton button = (JRadioButton) e.getSource();
        switch (action) {
            case AppWindow.EASY_ACTION:
                App.model.setStrategy(new EasyModeStrategy(App.model));
                App.win.getCanvas().repaint();
                break;
            case AppWindow.HARD_ACTION:
                App.model.setStrategy(new HardModeStrategy(App.model));
                App.win.getCanvas().repaint();
                break;
        }
    }
}
