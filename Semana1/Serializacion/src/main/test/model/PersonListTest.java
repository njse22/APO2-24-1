package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonListTest {

    private PersonList personList;

    public void setup1(){
        personList = new PersonList();
    }

    public void setup2(){
        personList = new PersonList();
        personList.addPersonToList("person1", 10, "A10");
        personList.addPersonToList("person2", 20, "A20");
        personList.addPersonToList("person3", 30, "A30");
        personList.addPersonToList("person4", 40, "A40");
        personList.addPersonToList("person5", 50, "A50");

    }

    @Test
    public void test1(){

        // init
        setup1();

        // act
        personList.addPersonToList("person1", 10, "A10");

        // assert
        assertEquals(1, personList.getPeople().size());

    }

    @Test
    public void test2(){

        // init
        setup1();

        // act
        personList.addPersonToList("person1", 10, "A10");

        // assert
        assertEquals(personList.getPeople().get(0).getName(), "person1");
        assertEquals(personList.getPeople().get(0).getAge(), 10);
        assertEquals(personList.getPeople().get(0).getId(), "A10");

    }

    @Test
    public void test3(){
        // init
        setup2();

        // Act
        Person personFound = personList.searchPersonById("A20");

        // Assert
        assertNotNull(personFound);

    }

}
