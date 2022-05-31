package array;

import java.util.Arrays;

/*
IMP:
Given an unsorted array, find count of all possible pairs that satisfy the condition a[i] > a[j] where i < j.

Ex: arr = [8, 9, 4, 5, 2, 1]

Possible pairs: (8,4), (8,5) (8,2) (8,1) (9,4) (9,5) (9,2) (9,1) (4,2) (4,1) (5,2) (5,1) (2,1)
result: 13

 */
public class CountInversionOfArr {

    private static int inversionCount = 0;

    public static void main(String[] args) {

        int[] inputArr = new int[] {8, 9, 4, 5, 2, 1};

        int[] inputArr1 = new int[] {3, 5, 2, 1, 8, 6, 4, 9};

        int [] resultArr = mergeSort(Arrays.copyOfRange(inputArr1,0,(inputArr1.length/2)),
                Arrays.copyOfRange(inputArr1,inputArr1.length/2,inputArr1.length));

//        for(int x =0; x < resultArr.length; x++){
//            System.out.print(resultArr[x]+",");
//        }
//        System.out.println();
        System.out.println("Inversion count is "+inversionCount);
    }

    private static int[] mergeSort(int[] leftArr, int[] rightArr) {

        if(leftArr.length <= 1 && rightArr.length <= 1){
            return merge(leftArr,rightArr);
        }
        leftArr= mergeSort(Arrays.copyOfRange(leftArr,0,leftArr.length/2),
                Arrays.copyOfRange(leftArr,leftArr.length/2,leftArr.length));

        rightArr =  mergeSort(Arrays.copyOfRange(rightArr,0,rightArr.length/2),
                Arrays.copyOfRange(rightArr,rightArr.length/2,rightArr.length));

        return merge(leftArr,rightArr);
    }

    private static int[] merge(int[] arr1, int[] arr2) {

        int p1 = 0;
        int p2= 0 ;
        int[] mergedArr = new int[arr1.length+arr2.length];
        int index = 0;

        if(arr1.length == 0){
            return arr2;
        }
        if(arr2.length == 0){
            return arr1;
        }
        if(arr1.length == 1 && arr2.length == 1){
            if(arr1[0] > arr2[0]) inversionCount++;
        }
        else{
            int x1 = 0;
            int x2 = 0;

            while (x1 < arr1.length && x2 < arr2.length){

                if(arr1[x1] > arr2[x2]){
                    inversionCount = inversionCount+(arr1.length-x1);
                    x2++;
                }
                else{
                    x1++;
                }

            }
        }
        while (p1 < arr1.length && p2 < arr2.length){

            if(arr1[p1] < arr2[p2]){
                mergedArr[index] = arr1[p1];
                p1++;
            }
            else{
                mergedArr[index] = arr2[p2];
                p2++;
            }
            index++;
        }
        while (p1 < arr1.length){
            mergedArr[index] = arr1[p1];
            index++;
            p1++;
        }
        while (p2 < arr2.length){
            mergedArr[index] = arr2[p2];
            index++;
            p2++;
        }
        return mergedArr;
    }

    private static void printArr(int[] arr2) {

        for(int i =0; i < arr2.length; i++){
            System.out.print(arr2[i]+",");
        }
        System.out.println();
    }
}
