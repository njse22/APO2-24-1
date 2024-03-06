package structures;

public class CircularList {
    private Node first;
    private Node last;

    public void addNode(Object obj){
        Node node = new Node(obj);
        // caso base --> la lista esta vacia
        if(first == null){
            first = node;
            last = node; // para dos punteros
            // para la lista circular
            first.setPrevious(last);
            last.setNext(first);
        }
        // segundo caso --> la lista no esta vacia
        else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
            last.setNext(first);
            first.setPrevious(last);
        }
    }

    public String printList(){
        String msj = "[ ";
        Node current = first;
        msj += current +" ";
        // para la lista circular
        while (current.getNext() != first){
            current = current.getNext();
            msj += current + " ";
        }
        msj += " ]";
        return msj;
    }

    public Node search(Object value){
        Node found = null;
        // caso base
        if(!isEmpty() && first.getValue().equals(value)){
            found = first;
        }
        // cuando se conoce la referencia al final
        else if (!isEmpty() && last.getValue().equals(value)) {
            found = last;
        }

        // caso iterativo
        else {
            Node current = first;
            boolean isFound = false;

            // recorrer la lista
            //
            while (current != last && !isFound){
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

    public boolean isEmpty(){
        return (first == null) & (last == null);
    }


    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}
