package ui;

import util.Recursion;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        //m.interativeCount(10);
        // m.recursiveCount(10);
        Recursion r = new Recursion();
        System.out.println(r.factorial(5));

        System.out.println(r.count(5));

        System.out.println(r.factorialDP(5));
        System.out.println(r.factorialDP(6));

        System.out.println("***************************");
        System.out.println(r.fibonnacci(5));

    }




    public void interativeCount(int n){
        for (int i = n; i >= 0 ; i--) {
            System.out.println(i);
        }
    }

    public void recursiveCount(int n){
        // Caso base
        if(n == 0){
            System.out.println(n);
        }
        // Caso Recursivo
        else {
            System.out.println(n);
            recursiveCount(--n);
        }
    }

}
