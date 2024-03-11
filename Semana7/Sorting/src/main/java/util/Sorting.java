package util;

import java.util.ArrayList;

public class Sorting<T extends Comparable<T>> {


    public int[] sort(int[] arr){

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public ArrayList<T> insertion(ArrayList<T> arr){
        for (int i = 1; i < arr.size(); i++) {
            T current = arr.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(arr.get(j)) < 0){
                arr.set(j+1, arr.get(j));
                --j;
            }
            arr.set(j+1, current);
        }
        return arr;
    }

    public ArrayList<T> selectionSort(ArrayList<T> arr){

        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i).compareTo(arr.get(j)) > 0){
                    // intercambio
                    T blue = arr.get(i); // es mayor
                    T red = arr.get(j); // es menor
                    arr.set(j, blue);
                    arr.set(i, red);
                }
            }
        }

        return arr;
    }


}
