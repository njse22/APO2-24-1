package org.example.demofx2.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.demofx2.model.Person;

public class PersonController {

    private static PersonController instance;

    private ObservableList<Person> people;

    private PersonController(){
        people = FXCollections.observableArrayList();
    }

    public static PersonController getInstance(){
        if (instance == null){
            instance = new PersonController();
        }
        return instance;
    }

    public void addPerson(String name, int age){
        Person p = new Person(name, age);
        people.add(p);
    }

    public ObservableList<Person> getPeople() {
        return people;
    }

    public void setPeople(ObservableList<Person> people) {
        this.people = people;
    }


}
