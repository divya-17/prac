package practice;

import java.util.ArrayList;
import java.util.List;

public class FirstOccurenceInArrayUsingRec {

    public static void main(String[] args) {
        

        int arr[] = new int[] {2, 5, 7, 9, 5, 8};

        int elem = 5;
        int index = 0;

        int firstIndex = getFirstIndex(arr,elem,index);
        System.out.println("First index of "+elem+" is -> "+firstIndex);
    }

    private static int getFirstIndex(int[] arr, int elem, int index) {

        if(index == arr.length){
            return  -1;
        }
        if(arr[index] == elem){
            return index;
        }
        return getFirstIndex(arr,elem,index+1);
    }
}
