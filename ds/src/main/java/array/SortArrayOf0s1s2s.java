package array;

/*
Given an array of 0s,1s and 2s, sort an array without using any sorting algorithm

Ex: I/p: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
O/p:     {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

Below algorithm is called : Dutch national flag algorithm.

 */
public class SortArrayOf0s1s2s {

    public static void main(String[] args) {

        int [] arr = new int[] {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println("Array before sorting ");
        printArr(arr);
        sortArray(arr);
        System.out.println("Array after sorting");
        printArr(arr);
    }

    private static void printArr(int[] arr) {

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void sortArray(int[] arr) {

        int lowIndx = 0;
        int midIndx = 0;
        int highIndx = arr.length-1;


        while (midIndx <= highIndx){

            if(arr[midIndx] == 2){
                swap(highIndx,midIndx,arr);
                highIndx--;
            }

            if(arr[midIndx] == 0){
                swap(lowIndx,midIndx,arr);
                lowIndx++;
                midIndx++;
            }

            if(arr[midIndx] == 1){
                midIndx++;
            }
        }
    }

    private static void swap(int indx1, int indx2, int[] arr) {

        int temp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = temp;

    }


}
