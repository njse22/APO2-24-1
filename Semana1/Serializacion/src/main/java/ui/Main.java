package ui;

import exceptions.DuplicatePersonException;
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
        try {
            main.people.addPersonToList("person1", 10, "A10");
            main.people.addPersonToList("person1", 10, "A10");
            main.people.addPersonToList("person2", 10, "A20");
            main.people.addPersonToList("person3", 10, "A30");
            main.people.addPersonToList("person4", 10, "A40");
            main.people.addPersonToList("person5", 10, "A50");
        } catch (DuplicatePersonException e) {
            e.printStackTrace();
        }

        main.people.addPetToPerson("pet1", 1, 0);
        main.people.addPetToPerson("pet2", 1, 1);
        main.people.addPetToPerson("pet3", 1, 2);
        main.people.addPetToPerson("pet4", 1, 3);
        main.people.addPetToPerson("pet5", 1, 4);

        main.people.save();
        main.people.saveCsvFile();

        System.out.println("********************************");

        main.people.cleanArray();

        System.out.println(main.people.getPeople());

        main.people.loadCsvFile();

        System.out.println(main.people.getPeople());
    }
}
