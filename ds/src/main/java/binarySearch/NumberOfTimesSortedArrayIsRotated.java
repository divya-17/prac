package binarySearch;

/*

Given a rotated sorted array, find number of times the sorted array has been rotated.
In a cyclic array: if elem is present at index i then formula for next and prev elems are:
next elem = (i+1)%N
prev elem = (i-N+1)%N;
Because cyclic array starts all over again when it reaches it's last index.

 */
/* Doubt */

public class NumberOfTimesSortedArrayIsRotated {

    public static void main(String[] args) {

        int[] rotatedArr1 = new int[]{11, 12, 15, 18, 2, 5, 6, 8};
        int[] rotatedArr2 = new int[]{15, 18, 2, 5, 6, 8, 11, 12};

        int index = getIndexForPivotElem(rotatedArr1);
        System.out.println("Pivot index is at " + index);
        int len = rotatedArr1.length;

        System.out.println("Number of times elem is rotated is " + (len - index));
    }

    private static int getIndexForPivotElem(int[] inputArr) {

        int strtIndex = 0;
        int endIndex = inputArr.length - 1;
        int N = inputArr.length;

        while (strtIndex <= endIndex) {

            int midIndex = strtIndex + (endIndex - strtIndex) / 2;
            int nextElem = (midIndex+1)%N;
            int prevElem = (midIndex+N-1)%N;

            if (inputArr[midIndex] < inputArr[nextElem] && inputArr[midIndex] < inputArr[prevElem]) {
                return midIndex;
            }

            // pivot elem in left array
            if (inputArr[midIndex] <= inputArr[endIndex]) {
                endIndex = midIndex - 1;
            }
            // pivot elem in right array
            else if (inputArr[strtIndex] <= inputArr[midIndex]) {
                strtIndex = midIndex + 1;
            }

        }
        return -1;
    }
}
