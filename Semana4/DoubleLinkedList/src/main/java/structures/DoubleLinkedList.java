package structures;

import model.Person;

public class DoubleLinkedList {
    private Node first;
    private Node last;

    public void addNode(Object obj){
        Node node = new Node(obj);

        // caso base --> la lista esta vacia
        if(first == null){
            first = node;
            last = node;
        }
        // segundo caso --> la lista no esta vacia
        else {

            if(first.getNext() == null){
                first.setNext(node);
                node.setPrevious(first);
                last = node;
            }
            // caso iterativo --> la lista tiene mas de dos elementos
            else {
                Node current = first.getNext();
                while (current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
                node.setPrevious(current);
                last = node;
            }
        }
    }

    public String printList(){
        String msj = "[ ";
        Node current = first;
        msj += current +" ";
        while (current.getNext() != null){
            current = current.getNext();
            msj += current + " ";
        }
        msj += " ]";
        return msj;
    }

    public Node search(Object value){
        Node found = null;
        // caso base
        if(first != null && first.getValue().equals(value)){
            found = first;
        }
        // caso iterativo
        else {
            Node current = first;
            boolean isFound = false;

            // recorrer la lista
            while (current != null && !isFound){
                if(current.getValue().equals(value)){
                    found = current;
                    isFound = true;
                }
                // actualizar el actual de la lista
                current = current.getNext();
            }
        }
        return found;
    }

    public void remove(String id){
        Node current = first;

        if(first != null && first.getId().equals(id)){
            first = first.getNext();
        }

        while (current != null){
            if(current.getNext() != null && current.getNext().getId().equals(id)){
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }


    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }


}
