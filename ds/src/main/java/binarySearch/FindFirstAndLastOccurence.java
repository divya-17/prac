package binarySearch;

/*
Given an sorted array with repetitive numbers, find the first and last occurence of any elem in that array.
Ex:
inputArr = [2, 4, 10, 10, 10, 18, 20]
elem: 10

O/p:
firstIndex = 2
lastIndex = 4

 */
public class FindFirstAndLastOccurence {

    public static void main(String[] args) {

        int [] inputArr = new int[]{2, 4, 10, 10, 10, 18, 20};
        int elemToSearch = 10;
        int frstIndex = getFirstOccurenceIndex(inputArr,elemToSearch);
        int lastIndex = getLastOccurenceIndex(inputArr,elemToSearch);

        System.out.println("First Index of "+elemToSearch+" is "+frstIndex);
        System.out.println("Last Index of "+elemToSearch+" is "+lastIndex);

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
                strtIndex = strtIndex+midIndex;
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
