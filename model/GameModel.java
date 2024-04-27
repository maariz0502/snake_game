package model;

import java.util.ArrayList;
import java.util.Random;

import controller.App;
import model.strategyPattern.EasyModeStrategy;
import model.strategyPattern.StrategyPattern;
import view.AppCanvas;
import view.AppWindow;

public class GameModel {
    public Snake snake;
    public Food food;
    public ArrayList<Obstacle> obstacle = new ArrayList<>();
    public String messages;
    public int score;
    private StrategyPattern  strategy;
    
    public GameModel(){
        snake = new Snake();
        strategy = new EasyModeStrategy(this);
        obstacle.add(new Obstacle(9999, 9999));
        init();
    }

    public void init(){
        snake.init();
        score = 0;
        messages = "Click <Start> to play";
        food = createFood();
    }

    public Food createFood(){
        Random random = new Random();
        int x, y;
        do{
        x = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        y = random.nextInt(AppCanvas.HEIGHT / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        }while(isInsideSnake(x, y));
        return new Food(x, y);
    }

    public boolean isInsideSnake(int x, int y){
        for(var node: snake.nodes){
            if(node.x == x && node.y == y)return true;
        }
        return false;
    }

    public boolean isInsideFood(int x, int y){
        if(food.x == x && food.y == y)
            return true;
        else
            return false;
    }

    public Obstacle createObstacle(){
        Random random = new Random();
        int x, y;
        do{
        x = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        y = random.nextInt(AppCanvas.HEIGHT / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        }while(isInsideSnake(x, y) || isInsideFood(x,y));
        return new Obstacle(x, y);
    }

    public boolean snakeGotFood(){
        var food = App.model.food;
        var head = App.model.snake.nodes.get(0);
        return food.x == head.x && food.y == head.y;
    }

    public boolean snakeLeftScene(){
        var head = App.model.snake.nodes.get(0);
        return head.x <= 0 || head.x >= AppCanvas.WIDTH
            || head.y <= 0 || head.y >= AppCanvas.HEIGHT;
    }

    public boolean snakeHitsItsBody(){
        var nodes = App.model.snake.nodes;
        var head = nodes.get(0);
        for(int i = 1 ; i < nodes.size() ; i++){
            var n = nodes.get(i);
            if(head.x == n.x && head.y == n.y) return true;
        }
        return false;
    }

    public boolean snakeHitsObstacle(){
        var obstacle = App.model.obstacle;
        var head = App.model.snake.nodes.get(0);
        for(int i = 0 ; i < obstacle.size() ; i++){ 
            if(obstacle.get(i).x == head.x && obstacle.get(i).y == head.y){
                return true;
            }
        }
        return false;
    }
    

    public StrategyPattern getStrategy() {
        return strategy;
    }
    public void setStrategy(StrategyPattern strategy) {
        this.strategy = strategy;
    }
}
