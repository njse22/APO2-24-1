package ui;

import model.Person;
import model.PersonList;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person();

        System.out.println(p1.getName());
        System.out.println(p1.getId());
        System.out.println(p1.getNext());

        p1.setName("nn");
        p1.setId("00");
        p1.setNext(new Person());

        System.out.println(p1.getName());
        System.out.println(p1.getId());
        System.out.println(p1.getNext());

        Person p2 = p1.getNext();
        System.out.println(p2);

        System.out.println("**************************************************");

        PersonList controller = new PersonList();
        controller.setFirst(p1);
        System.out.println(controller.getFirst());
        System.out.println(controller.getFirst().getNext());

        System.out.println("**************************************************");
        PersonList list2 = new PersonList();
        list2.addPerson(p1);
        System.out.println(list2.getFirst());
        list2.addPerson(p2);

    }
}
