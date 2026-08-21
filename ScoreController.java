package com.example.demo1;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



public class ScoreController {
    private Label scoreLabel;
    private Label livesLabel;
    private int score;
    //private MainCharacter tanjiro1;
    private int lives;
    private HBox scoreHBox;

    public ScoreController(HBox scoreBox /*MainCharacter tanjiro1*/) {
        //this.tanjiro1 = tanjiro1;
        scoreHBox = scoreBox;
        score = 0;
        lives = 3;
        scoreLabel = new Label("SCORE: " + score);
        scoreHBox.setAlignment(Pos.CENTER);
        livesLabel = new Label("LIVES: " + lives);
        scoreHBox.getChildren().addAll(scoreLabel, livesLabel);
        scoreHBox.setAlignment(Pos.TOP_LEFT);

    }

    public void updateScore(int points) {
        score += points;
        scoreLabel.setText("SCORE:" + score);
    }
    // public Label getLivesLabel() {
    //  return livesLabel;
    //}
    public void removeLabels() {
        scoreHBox.getChildren().remove(scoreLabel);
        scoreHBox.getChildren().remove(livesLabel);
    }


    public void updateLives(int lives) {
        this.lives -= lives;
        livesLabel.setText("LIVES:" + this.lives);
    }

    public double getLives() {
        return this.lives;
    }

}
