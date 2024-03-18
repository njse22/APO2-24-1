package util;

public class Recursion {

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


    // método recursivo
    private String count(int n, String msj){
        if(n == 0){
            msj += n + " ]";
        }
        else {
            msj += n + ", ";
            msj += count(--n, msj);
        }

        return msj;
    }



}
