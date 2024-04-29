package org.icesi.animation.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import org.icesi.animation.model.Entity;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Entity entity;
    private boolean running;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.entity = new Entity(canvas);
        this.running = true;

        new Thread( ()->{
            while (running){
                Platform.runLater( () -> {
                    entity.paint();
                } );
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("controlador");
            }
        } ).start();

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}