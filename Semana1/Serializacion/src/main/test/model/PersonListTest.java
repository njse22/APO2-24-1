package model;

import exceptions.DuplicatePersonException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonListTest {

    private PersonList personList;

    public void setup1(){
        personList = new PersonList();
    }

    public void setup2(){
        personList = new PersonList();
        try{
            personList.addPersonToList("person1", 10, "A10");
            personList.addPersonToList("person2", 20, "A20");
            personList.addPersonToList("person3", 30, "A30");
            personList.addPersonToList("person4", 40, "A40");
            personList.addPersonToList("person5", 50, "A50");
        }
        catch (DuplicatePersonException e){
            e.printStackTrace();
        }

    }

    @Test
    public void test1(){

        // init
        setup1(); // Empty list

        // act
        boolean isException = false;
        try{
            personList.addPersonToList("person1", 10, "A10");
        }
        catch (DuplicatePersonException e){
            isException = true;
        }

        // assert
        assertEquals(1, personList.getPeople().size());

        assertEquals(personList.getPeople().get(0).getName(), "person1");
        assertEquals(personList.getPeople().get(0).getAge(), 10);
        assertEquals(personList.getPeople().get(0).getId(), "A10");

        assertFalse(isException);

    }

    @Test
    public void test2(){

        // init
        setup2();

        // act
        boolean isException = false;
        try {
            personList.addPersonToList("person1", 10, "A10");
        }
        catch (DuplicatePersonException e){
            isException = true;
        }

        // assert
        assertTrue(isException);

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
    @Test
    public void testSearchUserByIdInNotEmptyList(){
        // init
        setup2();

        // Act
        Person personFound = personList.searchPersonById("A70");

        // Assert
        assertNull(personFound);
    }

    @Test
    public void testSearchUserByIdInEmptyList(){
        // init
        setup1(); // empty list

        // Act
        Person personFound = personList.searchPersonById("A70");

        // Assert
        assertNull(personFound);
    }
}
