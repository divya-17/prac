package binarySearch;

/*
Given a sorted array and a key(which may or may not be present in the array itself), find the elem in the array
which has smallest abs diff from the given key.

Ex:
arr = [2, 4, 6, 10, 12]
key = 7

absDiffArr = [5, 3, 1, 3, 5]
minAbsDiff = 1;
Ans: 6
binaryArr
 */
public class MinDiffElemInSortedArr {

    public static void main(String[] args) {

        int arr [] = new int[] {1, 3, 8, 10, 15};
        int key = 12;

        int floorIndex = getFloorIndex(arr,key);
        System.out.println("Floor Index is "+floorIndex);
        int ceilIndex = getCeilIndex(arr,key);
        System.out.println("Ceil Index is "+ceilIndex);

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        if(Math.abs(arr[floorIndex]-key)< minValue){
            minIndex = floorIndex;
            minValue = Math.abs(arr[floorIndex]-key);
        }
        if(Math.abs(arr[ceilIndex] - key) < minValue){
            minIndex = ceilIndex;
        }
        System.out.println("Result => "+arr[minIndex]);
    }

    private static int getCeilIndex(int[] arr, int key) {

        int strtIndex = 0;
        int endIndex = arr.length-1;

        int ceilIndex = Integer.MAX_VALUE;

        while(strtIndex <= endIndex){

            int midIndex = strtIndex+ (endIndex-strtIndex)/2;

            if(arr[midIndex] == key){
                return midIndex;
            }
            else if(arr[midIndex] > key && midIndex < ceilIndex){
                ceilIndex = midIndex;
                endIndex = midIndex-1;
            }
            else if(arr[midIndex] < key){
                strtIndex = midIndex+1;
            }

        }
        return ceilIndex;
    }

    private static int getFloorIndex(int[] arr, int key) {

        int strtIndex = 0;
        int endIndex = arr.length-1;

        int floorIndex = Integer.MIN_VALUE;

        while(strtIndex <= endIndex){

            int midIndex = strtIndex+ (endIndex-strtIndex)/2;

            if(arr[midIndex] == key){
                return midIndex;
            }

            if(arr[midIndex] < key && midIndex > floorIndex){
                floorIndex = midIndex;
                strtIndex = midIndex+1;
            }
            if(arr[midIndex] > key){
                endIndex = midIndex-1;
            }
        }
        return floorIndex;
    }
}
