package ui;

import model.Person;
import util.ComparatorName;
import util.Sorting;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sorting sort = new Sorting();

        int[] arr = {5, 4, 10, 7, 11, 3, 9, 2};
        ArrayList<Integer> listInt = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            listInt.add(arr[i]);
        }

        listInt = sort.selectionSort(listInt);

        System.out.println(listInt);

        ArrayList<Person> people = new ArrayList<>();
        Person p1 = new Person("name1", "A01", 10);
        Person p2 = new Person("name2", "A02", 20);
        Person p3 = new Person("name3", "A03", 30);
        Person p4 = new Person("name4", "A04", 40);
        Person p5 = new Person("named", "A05", 50);

        people.add(p5);
        people.add(p4);
        people.add(p3);
        people.add(p2);
        people.add(p1);

        ComparatorName comparatorName = new ComparatorName();

        System.out.println(people);

        people.sort(comparatorName);

        System.out.println(people);




    }
}
