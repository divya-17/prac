package binarySearch;

/*
Given a rotated sorted array, find index of an elem in that array.
Ex: arr : [11  12  15  18  2  5  6  8]
Elem to search: 15
O/p: 2
 */
public class FindElemInRotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[] {11, 12, 15, 18, 2, 5, 6, 8};
        int elemToSearch = 15;
        int pivotIndex = getIndexOfPivotElem(arr);
        System.out.println("Index of pivot elem "+pivotIndex);
        int elemIndex = findElemIndexUsingBinarySearch(arr,elemToSearch,pivotIndex);
        System.out.println("Index of the elem is "+elemIndex);
    }

    private static int findElemIndexUsingBinarySearch(int[] arr, int elemToSearch, int pivotIndex) {

        int firstHalfStrIndex = 0;
        int firstHalfEndIndex = pivotIndex-1;

        while (firstHalfStrIndex <= firstHalfEndIndex){

            int midIndex = firstHalfStrIndex + (firstHalfEndIndex-firstHalfStrIndex)/2;

            if(arr[midIndex] == elemToSearch){
                return midIndex;
            }
            else if(arr[midIndex] > elemToSearch){
                firstHalfEndIndex = midIndex-1;
            }
            else if(arr[midIndex] < elemToSearch){
                firstHalfStrIndex = midIndex+1;
            }
        }

        int secondHalfStrIndex =pivotIndex;
        int secondHalfEndIndex = arr.length-1;

        while (secondHalfStrIndex <= secondHalfEndIndex){

            int midIndex = secondHalfStrIndex + (secondHalfEndIndex-secondHalfStrIndex)/2;

            if(arr[midIndex] == elemToSearch){
                return midIndex;
            }
            else if(arr[midIndex] > elemToSearch){
                secondHalfEndIndex = midIndex-1;
            }
            else if(arr[midIndex] < elemToSearch){
                secondHalfStrIndex = midIndex+1;
            }
        }

      return -1;
    }

    private static int getIndexOfPivotElem(int[] arr) {
        int strtIndex =0;
        int endIndex = arr.length-1;
        int N = arr.length;

        while (strtIndex <= endIndex) {

            int midIndex = strtIndex + (endIndex - strtIndex) / 2;
            int nextIndex = (midIndex + 1) % N;
            int prevIndex = (midIndex + N - 1) % N;

            if (arr[midIndex] < arr[nextIndex] && arr[midIndex] < arr[prevIndex]) {
                return midIndex;
            }
            if(arr[midIndex] < arr[endIndex]){
                endIndex = midIndex-1;
            }
            else if(arr[midIndex] > arr[strtIndex]){
                strtIndex = midIndex+1;
            }
        }
        return -1;
    }
}
