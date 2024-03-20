package util;

import java.util.ArrayList;

public class Recursion {

    // almacenar en una memoria temporal la información ya calculada
    private ArrayList<Integer> dp;

    public Recursion(){
        dp = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            dp.add(null);
        }
    }

    public int factorial(int n){
        int result;

        // caso base
        if(n == 0){
            result = 1;
        }
        // caso recursivo
        else {
            result = n * factorial(n-1);
        }

        return result;
    }

    // método fachada
    public String count(int n){
        String msj = "[ ";
        return count(n, msj);
    }

    public int factorialDP(int n){
        int result;

        // no se ha calculado el factorial
        if(dp.get(n) == null){
            // caso base
            if(n == 0){
                result = 1;
                dp.set(0, result);
            }
            // caso recursivo
            else {
                result = n * factorial(n-1);
                dp.set(n, result);
            }
        }
        else {
            result = dp.get(n);
        }
        return result;
    }

    public int fibonnacci(int n){
        int result;

        // primer caso base
        if(n == 0){
            result = 0;
        }
        // segundo caso base
        else if (n == 1){
            result = 1;
        }
        // caso recurrente
        else {
            result = fibonnacci(n-1) + fibonnacci(n-2);
        }

        return result;
    }

    // método recursivo
    private String count(int n, String msj){
        if(n == 0){
            msj += n + " ]";
        }
        else {
            msj += n + ", ";
            msj = count(--n, msj);
        }

        return msj;
    }



}
