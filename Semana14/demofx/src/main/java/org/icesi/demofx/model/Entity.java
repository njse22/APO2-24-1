package org.icesi.demofx.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Entity {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private int frame;

    private double posX;
    private double posY;

    private ArrayList<Image> run;

    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;



    public Entity(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.run = new ArrayList<>();
        this.posX = 50;
        this.posY = 50;
        this.frame = 0;

        for (int i = 0; i <= 5; i++) {
            Image image = new Image(getClass().getResourceAsStream(
                    "/hero/run/adventurer-run-0"+i+".png"),
                    100, 100, false, false);
            run.add(image);
        }
    }

    public void paint() {
        graphicsContext.drawImage(run.get(frame%5), posX, posY);
        frame++;
    }

    public void events(){
        canvas.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            switch (event.getCode()){
                case UP -> up = true;
                case DOWN-> down = true;
                case RIGHT -> right = true;
                case LEFT -> left = true;
            }
        });

        canvas.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case UP -> up = false;
                case DOWN -> down = false;
                case RIGHT -> right = false;
                case LEFT -> left = false;
            }
        });
    }

    public void updatePos(){
        if(up){
            posY -= 10;
        }
        if(down){
            posY += 10;
        }
        if (right){
            posX += 10;
        }
        if (left){
            posX -= 10;
        }
    }


}
