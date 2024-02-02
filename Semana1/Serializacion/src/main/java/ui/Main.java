package ui;

import model.PersonList;

import java.io.File;

public class Main {

    private PersonList people;

    public Main(){
        people = new PersonList();
    }


    public static void main(String[] args) {

        Main main = new Main();



        System.out.println("Ruta del proyecto: " + System.getProperty("user.dir"));
        File ruta = new File(System.getProperty("user.dir"));

        System.out.println("is directory: " + ruta.isDirectory());
        System.out.println("is file: " + ruta.isFile());
        System.out.println("is AbsolutePath: " + ruta.getAbsolutePath());
        System.out.println("is Path: " + ruta.getPath());
        System.out.println("is name: " + ruta.getName());

        String[] lista = ruta.list();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);

        }

        System.out.println("*****************************************");
        main.people.addPersonToList("person1", 10, "A10");
        main.people.addPersonToList("person2", 10, "A20");
        main.people.addPersonToList("person3", 10, "A30");
        main.people.addPersonToList("person4", 10, "A40");
        main.people.addPersonToList("person5", 10, "A50");
        main.people.save();
    }
}
