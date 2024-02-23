package model;

public class PersonList {

    private Person first;

    public void addPerson(String name, String id){
        Person person = new Person(name, id);

        // caso base --> la lista esta vacia
        if(first == null){
            first = person;
        }
        // segundo caso --> la lista no esta vacia
        else {

            if(first.getNext() == null){
                first.setNext(person);
            }
            // caso iterativo --> la lista tiene mas de dos elementos
            else {
                Person current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(person);
            }
        }
    }

    public String printList(){
        String msj = "[ ";
        Person current = first;
        msj += current +" ";
        while (current.getNext() != null){
            current = current.getNext();
            msj += current + " ";
        }
        msj += " ]";
        return msj;
    }

    public Person search(String id){
        Person found = null;
        // caso base
        if(first.getId().equals(id)){
            found = first;
        }
        // caso iterativo
        else {
            Person current = first;
            boolean isFound = false;

            // recorrer la lista
            while (current.getNext() != null && !isFound){
                if(current.getId().equals(id)){
                    found = current;
                    isFound = true;
                }
                // actualizar el actual de la lista
                current.getNext();
            }
        }
        return found;
    }

    public Person getFirst() {
        return first;
    }

    public void setFirst(Person first) {
        this.first = first;
    }


}
