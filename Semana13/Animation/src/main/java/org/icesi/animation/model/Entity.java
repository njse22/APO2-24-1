package org.icesi.animation.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Entity {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private int frame;

    private double posX;
    private double posY;

    private ArrayList<Image> run;

    public Entity(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.run = new ArrayList<>();
        this.posX = 50;
        this.posY = 50;
        this.frame = 0;

        for (int i = 0; i <= 5; i++) {
            Image image = new Image(getClass().getResourceAsStream(
                    "/animations/hero/run/adventurer-run-0"+i+".png"),
                    100, 100, false, false);
            run.add(image);
        }
    }

    public void paint() {

        //try {
        //    Thread.sleep(100);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}

        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //graphicsContext.setFill(Color.rgb(255, 255, 0));
        //graphicsContext.fillRect(posX, posY, 50, 50);
        graphicsContext.drawImage(run.get(frame%5), posX, posY);
        posX++;
        frame++;

    }


}
