package util;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch<T extends Comparable<T>> {

    public int binarySearch(ArrayList<Integer> array, int goal){
        int found = -1;

        int left = 0;
        int right = array.size()-1;
        int mid = (left+right)/2;
        //
        while (left <= right && found != mid){
            if(array.get(mid) == goal){
                found = mid;
            } else if (array.get(mid) > goal) {
                right = mid - 1;
            } else if (array.get(mid) < goal) {
                left = mid + 1;
            }

            mid = (left+right)/2;
        }

        return found;
    }


    public int genericBinarySearch(ArrayList<T> array, T goal){
        // Collections.sort(array);
        int index = -1;

        int left = 0;
        int right = array.size()-1;
        int mid = (left+right)/2;

        while (left <= right && index!= mid){
            if(array.get(mid).compareTo(goal) == 0){
                index = mid;
            } else if (array.get(mid).compareTo(goal) > 0) {
                right = mid - 1;
            } else if (array.get(mid).compareTo(goal) < 0) {
                left = mid + 1;
            }
            mid = (left+right)/2;
        }
        return index;
    }

}
