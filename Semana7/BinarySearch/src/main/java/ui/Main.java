package ui;

import model.Person;
import util.BinarySearch;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList();
        array.add(-2);
        array.add(0);
        array.add(3);
        array.add(5);
        array.add(7);
        array.add(11);
        array.add(15);

        BinarySearch binary = new BinarySearch();
        System.out.println(binary.binarySearch(array, 7));

        ArrayList<Person> people = new ArrayList<>();
        Person p = new Person("A3", 10);
        people.add(new Person("A0", 10));
        people.add(new Person("A1", 10));
        people.add(new Person("A2", 10));
        people.add(p);
        people.add(new Person("A4", 10));
        people.add(new Person("A5", 10));
        people.add(new Person("A6", 10));

        System.out.println(binary.genericBinarySearch(people, p ));
    }
}
