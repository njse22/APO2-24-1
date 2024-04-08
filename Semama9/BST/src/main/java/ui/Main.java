package ui;

import model.BST;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(50);
        System.out.println(tree.getRoot().getValue());

        tree.add(72);
        System.out.println(tree.getRoot().getRight().getValue());

        tree.add(49);
        System.out.println(tree.getRoot().getLeft().getValue());

        tree.add(80);
        System.out.println(tree.getRoot().getRight().getRight().getValue());

        tree.add(65);
        System.out.println(tree.getRoot().getRight().getLeft().getValue());


        System.out.println("***************************************");
        System.out.println(tree.search(49));

        System.out.println("***************************************");
        System.out.println(tree.getMin());

        tree.delete(80);
        System.out.println(tree.getList());

    }
}
