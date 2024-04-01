package model;

public class BST<T extends Comparable<T>> {

    private Node<T> root;

    // trigger
    public void add(T value){
        Node<T> node = new Node<>(value);
        if(root == null){
            this.root = node;
        }
        else {
            add(node, root);
        }

    }

    // método recursivo -> activado por un trigger
    private void add(Node<T> node, Node<T> current){
        // Evaluar valor del Nodo
        if(current.getValue().compareTo(node.getValue()) < 0){
            // se agrega por derecha
            if(current.getRight() == null){
                // caso base
                current.setRight(node);
            }
            else {
                // caso recursivo
                add(node, current.getRight());
            }
        }
        else {
            // se agrega por izquierda
            if(current.getLeft() == null){
                current.setLeft(node);
            }
            else {
                add(node, current.getLeft());
            }
        }
    }

    public T search(T value){
        T found = null;
        if (root != null && value.compareTo(root.getValue()) == 0){
            found = root.getValue();
        }
        else if (value.compareTo(root.getValue()) < 0) {
            found = search(value, root.getLeft());
        }
        else if (value.compareTo(root.getValue()) > 0){
            found = search(value, root.getRight());
        }

        return found;
    }

    private T search(T value, Node<T> current){
        T found = null;

        if(current != null){
            if(value.compareTo(current.getValue()) == 0){
                // caso base
                found = current.getValue();
            }
            // casos recursivo
            else if(value.compareTo(current.getValue()) < 0){
                found = search(value, current.getLeft());
            }
            else if (value.compareTo(current.getValue()) > 0){
                found = search(value, current.getRight());
            }
        }

        return found;
    }


    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
