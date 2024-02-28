package model;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private String id;
    private int age;

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int compare = this.age - o.getAge();
        if(compare == 0){
            compare = this.name.compareTo(o.getName());
        }
        return compare;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        // comparación por identificador
        return Objects.equals(this.id, person.getId());
    }

}
