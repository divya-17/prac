package binarySearch;

/*
Given a nearly sorted array,(nearly sorted array is the one where elem that is suppose to be at pos i can either be
at ith pos, or (i+1)th pos or (i-1)th pos) , search for an elem in that array.
Ex:
arr = [30, 20, 40, 50, 60, 70]
elem to search: 30.

 */
public class FindElemInNearlySortedArr {

    public static void main(String[] args) {

        int [] inputArr = new int[] {30, 20, 40, 50, 60};
        int elemToSearch = 40;
        int searchIndex = getIndexOfElem(inputArr,elemToSearch);

        System.out.println("Elem "+elemToSearch+" is at index: "+searchIndex);
    }

    private static int getIndexOfElem(int[] inputArr, int elemToSearch) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;

        while (strtIndex <= endIndex){

            int midIndex = strtIndex + (endIndex-strtIndex)/2;

            if(inputArr[midIndex] == elemToSearch){
                return midIndex;
            }
            else if (midIndex-1 >= strtIndex && inputArr[midIndex-1]== elemToSearch){
                return midIndex-1;
            }
            else if(midIndex+1 <= endIndex && inputArr[midIndex+1]==elemToSearch){
                return midIndex+1;
            }

            if(inputArr[midIndex] > elemToSearch){
                endIndex = midIndex-2;
            }
            else if(inputArr[midIndex] < elemToSearch){
                strtIndex = midIndex+2;
            }
        }

        return -1;

    }
}
