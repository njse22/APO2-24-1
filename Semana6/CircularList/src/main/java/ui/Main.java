package ui;

import structures.CircularList;

public class Main {

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.addNode("01");
        list.addNode("02");
        list.addNode("03");

        System.out.println("Print List ");
        System.out.println(list.printList());

        System.out.println("search");
        System.out.println(list.search("03"));


    }
}
