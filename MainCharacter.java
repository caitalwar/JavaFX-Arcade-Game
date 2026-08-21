package com.example.demo1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MainCharacter {
    private Rectangle rect;
    private Pane pane;
    private ArrayList<Enemies> eList;
    //private int lives;


    public MainCharacter(Pane root1,ArrayList<Enemies> enemiesArrayList) {
        rect = new Rectangle(Constants.MC_X,Constants.MC_Y,Constants.MC_HEIGHT,Constants.MC_WIDTH);
        rect.setFill(Color.BLACK);
        root1.getChildren().add(rect);
        pane = root1;
        eList = enemiesArrayList;
        //lives = 3;


    }
    public boolean intersect() {
        for(int i=0; i < eList.size();i++ ) {
            Rectangle enemyRect = eList.get(i).getRect();
            if(rect.intersects(enemyRect.getLayoutBounds())){
                eList.remove(eList.get(i));
                pane.getChildren().remove(enemyRect);
                return true;



            }
        }
        return false;
    }
//public int getLives(){
        //return lives;
//}
    public Rectangle getRect() {
        return rect;
    }
    public void reload(){
      if (rect.getY() == Constants.DEFAULT_Y) {
          rect.setY(10);
      }
      else if (rect.getY() == 0){
          rect.setY(Constants.DEFAULT_Y-10);
      }
      else if (rect.getX() == Constants.DEFAULT_X){
          rect.setX(10);
      }
      else if (rect.getX() == 0){
          rect.setX(Constants.DEFAULT_X-10);
      }

    }
    public void moveRight() {
        rect.setX(rect.getX()+10);
    }
    public void moveLeft() {
        rect.setX(rect.getX() - 10);
    }
    public void moveUp(){
        rect.setY(rect.getY() - 10);
    }
    public void moveDown(){
        rect.setY(rect.getY()+10);
    }
}
