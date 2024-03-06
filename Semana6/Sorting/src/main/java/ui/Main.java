package ui;

import util.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 4, 10, 7, 11, 3, 9, 2};
        ArrayList<Integer> listInt = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            listInt.add(arr[i]);
        }

        Sorting sorting = new Sorting();

        arr = sorting.sort(arr);
        listInt = sorting.insertion(listInt);

        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            System.out.println(listInt.get(i));
        }

    }
}
