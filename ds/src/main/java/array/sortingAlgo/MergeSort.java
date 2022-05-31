package array.sortingAlgo;

import java.util.Arrays;

/*
Time complexity of merge sort is O(nlogn) because for n levels array is split to 2 equal halves.
Merge sort uses divide and conquer.
 */
public class MergeSort {

    public static void main(String[] args) {

        int arr[] = new int[] {5, 4, 3, 2, 1};

        int[] resultArr = mergeSort(Arrays.copyOfRange(arr,0,arr.length/2+1),Arrays.copyOfRange(arr,(arr.length/2+1),arr.length));

        System.out.println("Result Arr is ");
        for(int i =0; i <resultArr.length; i++){
            System.out.print(resultArr[i]+",");
        }
        System.out.println();
    }

    private static int[] mergeSort(int[] arr1, int[] arr2) {

        if(arr1.length <= 1 && arr2.length <= 1){
            return merge(arr1,arr2);
        }

        int [] leftSortedArr = mergeSort(Arrays.copyOfRange(arr1,0,arr1.length/2),Arrays.copyOfRange(arr1,(arr1.length/2),arr1.length));

        int [] rightSortedArr = mergeSort(Arrays.copyOfRange(arr2,0,arr2.length/2),Arrays.copyOfRange(arr2,(arr2.length/2),arr2.length));

        return merge(leftSortedArr,rightSortedArr);
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
}

