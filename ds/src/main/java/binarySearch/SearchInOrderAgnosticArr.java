package binarySearch;


/*
Given a sorted array, search for an elem in the array,(array can be sorted in asc/desc order) and return the
search index.
 */
public class SearchInOrderAgnosticArr {

    public static void main(String[] args) {

        int[] ascInputArr = new int[] {1, 5, 7, 9 ,11};
        int[] descInputArr = new int[] {11, 9, 7, 5, 1};
        int elemToSearch = 9;

        int ascIndex = getIndexOfElem(ascInputArr,elemToSearch);
        System.out.println("Index of elem to search is "+ascIndex);

        int descIndex = getIndexOfElem(descInputArr,elemToSearch);
        System.out.println("Index of elem to search is "+descIndex);


    }

    private static int getIndexOfElem(int[] inputArr, int elemToSearch) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;
        int midIndex = 0;
        boolean asc=false;
        boolean desc= false;

        if(inputArr.length == 1){
            if(inputArr[0] == elemToSearch){
                return 0;
            }else {
                return -1;
            }
        }
        while (strtIndex <= endIndex){

            midIndex = strtIndex + (endIndex-strtIndex)/2;
            if(inputArr[midIndex] == elemToSearch){
                return midIndex;
            }
            else if(desc || inputArr[midIndex] > inputArr[midIndex+1]){

                desc = true;

                if(inputArr[midIndex] > elemToSearch){
                    strtIndex = midIndex+1;;
                }
                else {
                 endIndex = midIndex-1;
                }
            }

            else if(asc || inputArr[midIndex] < inputArr[midIndex+1]){

                asc = true;
                if(inputArr[midIndex] < elemToSearch){
                    strtIndex = midIndex+1;
                }
                else {
                  endIndex = midIndex -1;
                }
            }
        }
        return -1;
    }
}
