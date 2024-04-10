package ui;

import model.BST;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(50);
        //System.out.println(tree.getRoot().getValue());

        tree.add(60);
        //System.out.println(tree.getRoot().getRight().getValue());

        tree.add(40);
        //System.out.println(tree.getRoot().getLeft().getValue());

        tree.add(30);
        //System.out.println(tree.getRoot().getRight().getRight().getValue());

        tree.add(45);
        //System.out.println(tree.getRoot().getRight().getLeft().getValue());

        tree.add(70);
        tree.add(55);
        tree.add(20);
        tree.add(35);
        tree.add(43);
        tree.add(47);
        tree.add(80);


        System.out.println("***************************************");
        System.out.println(tree.search(49));

        System.out.println("***************************************");
        System.out.println(tree.getMin());

        System.out.println(tree.delete(40));
        System.out.println(tree.getList());

    }
}
