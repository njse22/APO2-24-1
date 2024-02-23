package ui;

import model.Person;
import model.PersonList;

public class Main {

    public static void main(String[] args) {

        System.out.println(" Creación de la lista y agregar de la lista");
        PersonList list = new PersonList();

        list.addPerson("person1", "00");
        list.addPerson("person2", "01");
        list.addPerson("person3", "02");
        list.addPerson("person4", "03");
        list.addPerson("person5", "04");
        list.addPerson("person6", "05");

        System.out.println("Print de la lista");
        System.out.println(list.printList());




    }
}
