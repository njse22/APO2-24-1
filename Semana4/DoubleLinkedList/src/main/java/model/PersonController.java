package model;

import structures.DoubleLinkedList;

public class PersonController {

    private DoubleLinkedList people;

    public PersonController() {
        people = new DoubleLinkedList();
    }

    public void addPerson(String name, String id, int age){
        Person p = new Person(name, id, age);
        people.addNode(p);
    }

    public String printPeople(){
        return people.printList();
    }

    public Person searchPerson(String name, String id, int age){
        Person p = (Person) people.search(new Person(name, id, age)).getValue();
        return p;
    }
}
