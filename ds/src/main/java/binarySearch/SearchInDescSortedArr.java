package binarySearch;

/*
Given a sorted array which is sorted in desc order, find the index of an elem in that array. Return -1 if no such
elem exists.
 */
public class SearchInDescSortedArr {

    public static void main(String[] args) {

        int [] inputArr = new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
        int elemToSearch = 4;

        int searchIndex = getIndexForElemToSearch(inputArr,elemToSearch);
        System.out.println("Search Index is "+searchIndex);
    }

    private static int getIndexForElemToSearch(int[] inputArr, int elemToSearch) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;
        int midIndex = 0;

        while (strtIndex <= endIndex){

            // Avoid using (str+end/2) as midIndex because it can cause integer overflow.
            midIndex = strtIndex+(endIndex-strtIndex)/2;

            if(inputArr[midIndex] == elemToSearch){
                return midIndex;
            }
            else if(inputArr[midIndex] > elemToSearch){
                strtIndex = midIndex+1;
            }
            else if(inputArr[midIndex] < elemToSearch){
                endIndex = endIndex-midIndex;
            }
        }
        return -1;
    }

}
