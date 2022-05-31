package binarySearch;

/*
Given a sorted array, find the count of occurence of a number in that array.
Ex:
inputArr = [2, 4, 10, 10, 10, 19, 20 ]
 */
public class CountOfElemInSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[] {2, 4, 10, 10, 10, 10, 10, 10, 19, 20};
        int elemToSearch = 10;

        int frstIndex = getFirstOccurenceIndex(arr,elemToSearch);
        int lastIndex = getLastOccurenceIndex(arr,elemToSearch);

        System.out.println("first index is "+frstIndex);
        System.out.println("lst index is "+lastIndex);
        System.out.println("Total count is "+(lastIndex-frstIndex+1));
    }

    private static int getLastOccurenceIndex(int[] inputArr, int elemToSearch) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;
        int midIndex = 0;
        int lstIndex = -1;

        while (strtIndex <= endIndex){

            midIndex = strtIndex + (endIndex-strtIndex)/2;

            if(inputArr[midIndex] == elemToSearch){
                lstIndex= midIndex;
                strtIndex = midIndex+1;
            }
            else if(inputArr[midIndex] > elemToSearch){
                endIndex = midIndex-1;
            }
            else if(inputArr[midIndex] < elemToSearch){
                strtIndex = midIndex+1;
            }
        }
        return lstIndex;

    }

    private static int getFirstOccurenceIndex(int[] inputArr, int elemToSearch) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;
        int midIndex = 0;
        int frstIndex = -1;

        while (strtIndex <= endIndex){

            midIndex = strtIndex + (endIndex-strtIndex)/2;

            if(inputArr[midIndex] == elemToSearch){
                frstIndex= midIndex;
                endIndex = midIndex-1;
            }
            else if(inputArr[midIndex] > elemToSearch){
                endIndex = midIndex-1;
            }
            else if(inputArr[midIndex] < elemToSearch){
                strtIndex = midIndex+1;
            }
        }
        return frstIndex;

    }
}
