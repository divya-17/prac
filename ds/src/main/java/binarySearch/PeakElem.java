package binarySearch;

/*
Imp Ques: This question is based on binary search on answer concept.
Given an array of unsorted number, find any of the peak elem. Peak elem is defined by below formula:
if (arr[i] > arr[i+1] and arr[i] > arr[i-1]) then arr[i] is a peak elem.

Ex:
inputArr = [1, 2, 1, 3, 5, 6, 4]
also inputArr[-1] = inputArr[n] = -infinity
peak elems are : 2 and 6. Returning any one of the peak elem is also fine.


 */
public class PeakElem {


    public static void main(String[] args) {

        int [] arr = new int[] {1, 2, 1, 3, 5, 6, 4};
        int [] arr1 = new int[] {9, 7, 5, 3, 2, 10};

        int peakElem = getPeakElem(arr1);
        System.out.println("Peak elem is "+peakElem);

    }

    private static int getPeakElem(int[] arr) {

        int strtIndex = 0;
        int endIndex = arr.length-1;

        while (strtIndex <= endIndex){

            int midIndex = strtIndex+ (endIndex-strtIndex)/2;

            if(midIndex == 0){
                if(arr[midIndex] > arr[midIndex+1]){
                    return arr[midIndex];
                }
                else{
                    return arr[midIndex+1];
                }
            }
            else if(midIndex== arr.length){

                if(arr[midIndex] > arr[midIndex-1]){
                    return arr[midIndex];
                }
                else{
                    return arr[midIndex-1];
                }
            }

            if(arr[midIndex]> arr[midIndex+1] && arr[midIndex] > arr[midIndex-1]){
                return arr[midIndex];
            }
            else if(arr[midIndex+1] > arr[midIndex]){
                strtIndex = midIndex+1;
            }
            else if(arr[midIndex-1] > arr[midIndex]){
                endIndex = midIndex-1;
            }
            else if (arr[midIndex] <arr[midIndex+1] && arr[midIndex] < arr[midIndex-1]){
                strtIndex = midIndex+1;
            }

        }
        return -1;
    }


}
