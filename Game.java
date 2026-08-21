package com.example.demo1;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game {
    private MainCharacter tanjiro;
    private Enemies enemies;
    private ArrayList<Enemies> enemiesList;
    private Pane gamePane;
    private ScoreController scoreController;
    private HBox hBox2;
    private Timeline gameTimeline;
    private Timeline enemyTimeline;
    //private int i;



    public Game(Pane pane, HBox hBox){
        enemiesList = new ArrayList<>();
        tanjiro = new MainCharacter(pane,enemiesList);
        hBox2 = hBox;

        gamePane = pane;
        gamePane.setOnKeyPressed(this::move);
        this.generateEnemies();
        this.timeline();
        this.enemyTimeline();
        //this.damageTimeline();
        scoreController = new ScoreController(hBox /* tanjiro */);
        //i = tanjiro.getLives();
    }
    public void generateEnemies(){
        for (int i = 0; i < 10; i++){
            enemies = new Enemies(gamePane,this.randX());
            enemiesList.add(enemies);



//        root5.getChildren().add(rect);
        }




    }
    public void updateGame(){
        tanjiro.reload();
        if(tanjiro.intersect()){
            scoreController.updateScore(1);
            tanjiro.intersect();
        }
        for(Enemies e : enemiesList) {
            if (e.getRect().getY() == 590){
                e.removeEnemies();
                enemiesList.remove(e);
                scoreController.updateLives(1);
            }
        }
        if (scoreController.getLives() < 0){
            scoreController.updateLives(-1);
        }
        if (scoreController.getLives() == 0){
            this.gameOver();
        }
    }
    public void gameOver(){
        gameTimeline.stop();
        enemyTimeline.stop();
        gamePane.setOnKeyPressed(null);
        scoreController.removeLabels();
        HBox hBox = new HBox();
        gamePane.getChildren().add(hBox);
        gamePane.getChildren().remove(tanjiro.getRect());
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: rgba(133,0,255,0.87)");
        hBox.setPrefSize(Constants.DEFAULT_X,Constants.DEFAULT_Y);
        Label label = new Label("GAME OVER");
        hBox.getChildren().add(label);
        Button button = new Button("RESTART");
        button.setOnAction((ActionEvent e) -> this.restartGame());
        hBox.getChildren().add(button);
    }
    /*
    public void damage() {
        for(Enemies e : enemiesList){
            if (e.getRect().getY() == 610) {


                i --;
            }
            }
        if (i < 0) {
            i = 0;
        }



        scoreController.getLivesLabel().setText("LIVES: " + i);
    }
*/
    public void restartGame(){
        gamePane.getChildren().clear();
        new Game(gamePane,hBox2);
        gamePane.requestFocus();
    }


    public void timeline(){
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(.01),(ActionEvent e) -> updateGame());
        gameTimeline = new Timeline(keyFrame);
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.play();
    }
    public void enemyTimeline(){
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(.5),(ActionEvent e) ->  enemies.moveDown(enemiesList));
        enemyTimeline = new Timeline(keyFrame);
        enemyTimeline.setCycleCount(Animation.INDEFINITE);
        enemyTimeline.play();
    }
    /*
    public void damageTimeline(){
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(.5),(ActionEvent e) -> damage());
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

     */
    public double randX(){
        double x = ((int) (Math.random()*899)+1);
        return x;

    }

    public void move(KeyEvent e){
        KeyCode keyPressed = e.getCode();
        switch(keyPressed){
            case LEFT:
                tanjiro.moveLeft();
                break;

            case RIGHT:
                tanjiro.moveRight();
                break;
            case UP:
                tanjiro.moveUp();
                break;
            case DOWN:
                tanjiro.moveDown();
                break;

        }
        e.consume();
    }
}