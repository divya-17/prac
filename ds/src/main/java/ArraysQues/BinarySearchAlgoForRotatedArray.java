package ArraysQues;

import java.util.Arrays;

/*
Search for an element in sorted and rotated array.

Search for key in an array which is rotated at some pivot unknown before hand.
Ex:
Actual Array: 1 2 3 4 5 6 7 8 9 10
Rotated Array: 5 6 7 8 9 10 1 2 3
Search key = 3

 */
public class BinarySearchAlgoForRotatedArray {

    public static void main(String[] args) {

        int[] inpArr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int [] inpArr1 = {9, 10, 1, 2, 3, 4, 5, 6, 7, 8};
        int key= 3;
        int key1=6;
        int searchIndex;
        int pivotIndex = getIndexForPivotElem(inpArr1);
        System.out.println("Pivot elem is at index "+pivotIndex);
        int [] firstHalfArr= Arrays.copyOfRange(inpArr1,0,pivotIndex);
        int [] secondHalfArr = Arrays.copyOfRange(inpArr1,pivotIndex,inpArr1.length);
        System.out.println("First Half Arr "+Arrays.toString(firstHalfArr));
        System.out.println("Second Half Arr "+Arrays.toString(secondHalfArr));

        if(key1 < inpArr1[pivotIndex]){
            searchIndex =BinarySearchAlgo.getIndexByBinarySearchAlgo(firstHalfArr,key1);
            System.out.println("Key "+key1+" is present at index "+searchIndex);
        }
        else{
            searchIndex = BinarySearchAlgo.getIndexByBinarySearchAlgo(secondHalfArr,key1);
            System.out.println("Key "+key1+" is present at index "+(searchIndex+pivotIndex));
        }

    }

    public static int getIndexForPivotElem(int[] arr){

        int lowerIndex=0;
        int upperIndex=arr.length-1;
        int middleIndex = (lowerIndex+upperIndex)/2;

        while (arr[middleIndex] > arr[middleIndex-1]) {
            if (arr[middleIndex] > arr[upperIndex]) {
                lowerIndex = middleIndex;

            } else if (arr[middleIndex] < arr[upperIndex]) {
                upperIndex = middleIndex;
            }

            middleIndex = (lowerIndex + upperIndex) / 2;

        }
        return middleIndex;
    }
}
