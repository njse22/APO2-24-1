package ui;

import model.PersonController;

public class Main {

    public static void main(String[] args) {
        PersonController controller = new PersonController();
        controller.addPerson("person1", "001", 10);
        controller.addPerson("person2", "002", 20);
        controller.addPerson("person3", "003", 30);

        System.out.println(controller.printPeople());

        System.out.println(controller.searchPerson("person1", "001", 10));
    }
}
