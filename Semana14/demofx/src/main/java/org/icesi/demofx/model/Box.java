package org.icesi.demofx.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Box extends Thread{

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double posX;
    private double posY;
    private boolean isLive;

    public Box(Canvas canvas){
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.posX = 50;
        this.posY = 50;
        this.isLive = true;
    }

    public void paint(){
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(posX, posY, 50, 50);
    }

    @Override
    public void run() {
        while (isLive){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            posX++;
        }

        while (posY <= canvas.getHeight()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            posY++;
        }
    }

    public void event(){

        canvas.setOnMouseClicked(event -> {
            isLive = false;
        });

    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
