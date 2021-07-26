package ArraysQues;


import java.util.ArrayList;
import java.util.List;

/*
This problem uses partitioning logic of quick sort
Move all negative numbers to the beginning and positive to the end with constant extra space
 */
public class MoveAllNegElemsToOneSide {


    public static void main(String[] args) {

        int arr1[] = new int[]{-1, 2, -5, -7, 8, -4, 10};

        int arr2[] = new int[]{1, -2, 3, -4, 5, -6, 7};
        System.out.println("Array before partitioning shift: ");
        printArr(arr1);
        partitioningShifts(arr1);
        System.out.println("Array after partitioning shift: ");
        printArr(arr1);


        System.out.println("Array before partitioning shift: ");
        printArr(arr2);
        partitioningShifts(arr2);
        System.out.println("Array after partitioning shift: ");
        printArr(arr2);
    }

    private static void printArr(int[] arr) {

        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void partitioningShifts(int[] arr) {

        int pIndex = 0;

        for(int i=0; i < arr.length; i++){

            if(arr[i] < 0){
                swap(pIndex,i,arr);
                pIndex++;
            }

        }
    }

    private static void swap(int pIndex, int i, int[] arr) {

        int temp = arr[pIndex];
        arr[pIndex] = arr[i];
        arr[i] = temp;

    }

}
