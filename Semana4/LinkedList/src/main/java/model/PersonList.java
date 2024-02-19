package model;

public class PersonList {

    private Person first;

    public void addPerson(Person person){
        if(first == null){
            first = person;
        }
        else {
            if(first.getNext() == null){
                first.setNext(person);
            }
            else {
                Person temp = first.getNext();
                while (temp.getNext() != null){
                    temp = temp.getNext();
                }
                temp.setNext(person);

            }
        }

    }

    public Person getFirst() {
        return first;
    }

    public void setFirst(Person first) {
        this.first = first;
    }


}
