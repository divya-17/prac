package binarySearch;

/*
Given a bitonic array(bitonic array is the one that increases monotonically and then descreases monotonically).

Ex: arr = [1, 3, 8, 12, 4, 2]
 */
public class FindMaxElemInBitonicArray {


    public static void main(String[] args) {

        int[] inputArr = new int[] {1, 3, 8, 12, 4, 2};

        int maxElem = getMaxElemInArr(inputArr);

        System.out.println("Max elem in bitonic array is "+maxElem);
    }

    private static int getMaxElemInArr(int[] arr) {

        int strtIndex = 0;
        int endIndex = arr.length-1;

        while (strtIndex <= endIndex){

            int midIndex = strtIndex + (endIndex-strtIndex)/2;

            if(arr[midIndex] > arr[midIndex+1] && arr[midIndex] > arr[midIndex-1]){
                return arr[midIndex];
            }
            else if(arr[midIndex] < arr[midIndex+1]){
                strtIndex = midIndex+1;
            }
            else if(arr[midIndex] > arr[midIndex+1]){
                endIndex = midIndex-1;
            }
        }
        return -1;
    }
}
