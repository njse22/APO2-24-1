package ui;


import util.CountClock;
import util.PrintInterface;
import util.RunnableClass;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // creación de un Hilo desde una clase propia
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html
        CountClock countClock = new CountClock(20);
        countClock.start();

        // Creación de un Hilo con la ejecución de un método estatito
        Thread a = new Thread(Main::print);
        System.out.println(a.getName());
        a.start();

        // Creación de una interfaz Runnable para la ejecución del Hilo
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Runnable.html
        RunnableClass runnableClass = new RunnableClass(0, "this is a runnable class");
        Thread b = new Thread(runnableClass);
        b.start();

        // Creación de multiples acciones (Runables) que pueden ser ejecutadas por un conjunto de Hilos
        RunnableClass run0 = new RunnableClass(16, "Runnable 0");
        RunnableClass run1 = new RunnableClass(6, "Runnable 1");
        RunnableClass run2 = new RunnableClass(0, "Runnable 2");

        ArrayList<RunnableClass> events = new ArrayList<>();
        events.add(run0);
        events.add(run1);
        events.add(run2);

        for(RunnableClass e: events){
           new Thread(e).start();
        }

        // Definición de Una Funtional Interface en Java
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/FunctionalInterface.html
        PrintInterface printInterface = () -> {
            System.out.println("Hello from PrintInterface or Funtional Interface");
        };

        printInterface.printMessage();

        // Creación de un Hilo con una expreción lambda -> Todas las expresiones lambda en JAVA son Funtional Interface
        // la interfaz Runnable es una Functional interface
        // por ende, se puede inicializar una acción de un Hilo con una expresión lambda
        Thread c = new Thread( () -> {
            System.out.println("Hello from lambda");
        } );

        c.start();

        // comportamiento de los hilos, no necesariamente es sincrono
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread-"+i);
            new Thread(Main::print).start();
        }

    }

    // proceso
    public static void print(){
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }
}
