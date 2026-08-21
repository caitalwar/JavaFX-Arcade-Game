package com.example.demo1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class PaneOrganizer {
    private BorderPane r;
    private Label label;
    private HBox hb;
    public PaneOrganizer() {
        hb = new HBox();
        r = new BorderPane();
        label = new Label();
        Pane pane = new Pane();
        r.setCenter(pane);
        this.button();
        Game game = new Game(pane, hb);
        r.setFocusTraversable(false);
        pane.setFocusTraversable(true);


    }

    public BorderPane getRoot() {
        return r;
    }
    public void button() {
        r.setBottom(hb);
        hb.setAlignment(Pos.CENTER);
        hb.setStyle("-fx-background-color: #FF0000");
        hb.setPrefSize(20,20);
        Button button = new Button("Quit");
        button.setStyle("-fx-background-color: #FF0000");
        button.setOnAction(e -> System.exit(0));
        hb.getChildren().add(button);
        hb.setFocusTraversable(false);




    }
}
