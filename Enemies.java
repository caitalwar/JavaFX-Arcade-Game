package com.example.demo1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Enemies {
    private Rectangle rect;
    private Pane pane;

    public Enemies(Pane root5,double x) {
        rect = new Rectangle(x, Constants.ENEMY_Y, Constants.ENEMY_HEIGHT, Constants.ENEMY_WIDTH);
        rect.setFill(Color.RED);
        root5.getChildren().add(rect);
        pane = root5;




    }

    public Rectangle getRect() {

        return rect;
    }
    public void moveDown(ArrayList<Enemies> arraylist){
        for(Enemies enemies: arraylist){
            Rectangle newRect = enemies.getRect();
            newRect.setY(newRect.getY()+20);


        }


    }
    public void removeEnemies(){
        pane.getChildren().remove(rect);
        }
    }

