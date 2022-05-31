package array;

import java.util.Arrays;

/*
 Binary Search Algo. (Complexity: Olog(n))
 */
public class BinarySearchAlgo {


    public static void main(String[] args) {


        int arr [] = {2,3,4,10,40};
        int searchKey = 40;

        int index = getIndexByBinarySearchAlgo(arr,searchKey);

        System.out.println("Index for search key "+searchKey+" is "+index);

    }

    public static int getIndexByBinarySearchAlgo(int[] arr, int searchKey){

        System.out.println("Input Arr is "+ Arrays.toString(arr));
        System.out.println("Search key is "+searchKey);

        int lowerIndex = 0;
        int higherIndex = arr.length-1;

        int middleIndex = (lowerIndex+higherIndex)/2;

        while (lowerIndex < higherIndex){

            if(arr[middleIndex] == searchKey){
                return middleIndex;
            }

            else if (arr[middleIndex] < searchKey){
                lowerIndex = middleIndex+1;
            }

            else if(arr[middleIndex] > searchKey){
                higherIndex = middleIndex - 1;
            }

            middleIndex = (lowerIndex+higherIndex)/2;

        }

        return middleIndex;

    }
}
