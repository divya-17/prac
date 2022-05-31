package binarySearch;

/*
Given a binary(0s and 1s) sorted infinite array, find the index of 1st elem in the arr.
 */
public class FindIndexOfFirstOneInBinarySortedInfiniteArr {

    public static void main(String[] args) {

        int[] binaryArr = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int firstOneIndex = getIndexOfFirstOneInBinaryArr(binaryArr);

        System.out.println("Index of first 1 in binary array is "+firstOneIndex);

    }

    private static int getIndexOfFirstOneInBinaryArr(int[] binaryArr) {

        int strtIndex = 0;
        int endIndex = 1;
        boolean elemFound = false;

        while (!elemFound){

            if(binaryArr[endIndex] != 1){
                strtIndex = endIndex;
                endIndex = 2*endIndex;
            }
            else if(binaryArr[endIndex] == 1){
                elemFound = true;
            }
        }

        System.out.println("Range is between  "+strtIndex+" and "+endIndex);

        return searchInRange(strtIndex,endIndex,binaryArr);

    }

    private static int searchInRange(int strtIndex, int endIndex, int[] binaryArr) {

        int minIndex = Integer.MAX_VALUE;
        while (strtIndex <= endIndex){

            int midIndex = strtIndex+ (endIndex-strtIndex)/2;

            if(binaryArr[midIndex] ==1 && midIndex < minIndex){
                minIndex = midIndex;
                endIndex = midIndex-1;
            }
            else if(binaryArr[midIndex] == 0){
                strtIndex = midIndex+1;
            }
        }
        return minIndex;
    }
}
