package org.icesi.demofx.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import org.icesi.demofx.model.Box;
import org.icesi.demofx.model.Box2;
import org.icesi.demofx.model.Entity;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private boolean isRunning;

    private Box box;
    private Box2 box2;

    private Entity avatar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.isRunning = true;

        this.box = new Box(canvas);
        this.box.start();

        this.box2 = new Box2(canvas);
        this.box2.events();

        this.avatar = new Entity(canvas);
        this.avatar.events();

        new Thread( ()->{
            while (isRunning){
                Platform.runLater( () -> {
                   graphicsContext.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
                   box.paint();
                   box2.paint();
                   avatar.paint();
                   avatar.updatePos();

                   double distance = Math.sqrt(
                           Math.pow(box.getPosX() - box2.getPosX(), 2 ) +
                           Math.pow(box.getPosY() - box2.getPosY(), 2));

                   System.out.println(distance);

                   if(distance <= 10){
                       this.box.event();
                   }

                } );
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } ).start();

    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}