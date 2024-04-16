package org.example.demofx.control;

import org.example.demofx.model.Person;

import java.util.ArrayList;

public class PersonController {

    private ArrayList<Person> people;

    public PersonController() {
        people = new ArrayList<>();
    }

    public void addPerson(String name, int age, String id){
        Person person = new Person(name, age, id);
        people.add(person);
    }

    public String printPeople(){
        String mjs = "";
        for (int i = 0; i < people.size(); i++) {
            mjs += people.get(i) + "\n";
        }
        return mjs;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
