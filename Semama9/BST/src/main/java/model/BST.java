package model;

import java.util.ArrayList;
import java.util.List;

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
        if(current.getValue().compareTo(node.getValue()) <= 0){
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

    public T getMin(){
        T found = null;
        // el árbol no estya vacio
        // caso base
        if(root != null){
            found = getMin(root);
        }
        return found;
    }

    // métod recursivo
    private T getMin(Node<T> current){
        T found = null;
        if(current.getLeft() != null){
            found = getMin(current.getLeft());
        }
        else {
           found = current.getValue();
        }
        return found;
    }

    public List<T> getList(){
        ArrayList<T> elements = null;
        if(root != null){
            elements = new ArrayList<>();
            getList(root, elements);
        }
        return elements;
    }

    private List<T> getList(Node<T> current, ArrayList<T> elements){
        if(current != null){
            getList(current.getLeft(), elements);
            elements.add(current.getValue());
            getList(current.getRight(), elements);
        }

        return elements;

    }




    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
