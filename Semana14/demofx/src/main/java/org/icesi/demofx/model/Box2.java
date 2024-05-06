package org.icesi.demofx.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Box2 {

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double posX;
    private double posY;


    public Box2(Canvas canvas){
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.posX = 0;
        this.posY = 0;
    }

    public void paint(){
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(posX, posY, 50, 50);
    }

    public void events(){
        canvas.setOnMouseMoved( event -> {
            posX = event.getX();
            posY = event.getY();
        } );
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
