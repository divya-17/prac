package binarySearch;

public class FindFloorOfElemInSortedArr {

    public static void main(String[] args) {

        int [] inputArr = new int[] {1, 2, 3, 4, 8, 10, 10, 12, 19};
        int elem = 11;

        int floorResult = getFloorOfElem(inputArr,elem);
        int ceilResult = getCeilOfElem(inputArr,elem);

        System.out.println("Floor of "+elem+" is "+floorResult);
        System.out.println("Ceil of "+elem+" is "+ceilResult);

    }

    private static int getCeilOfElem(int[] inputArr, int elem) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;
        int ceilElem = Integer.MAX_VALUE;

        while (strtIndex <= endIndex){


            int midIndex = strtIndex + (endIndex-strtIndex)/2;
            if(inputArr[midIndex] ==elem){
                return elem;
            }
            else if (inputArr[midIndex] > elem && inputArr[midIndex] < ceilElem){
                ceilElem = inputArr[midIndex];
            }
            if(inputArr[midIndex] > elem){
                endIndex = midIndex -1;
            }
            else if (inputArr[midIndex] < elem){
                strtIndex = midIndex+1;
            }

        }
        return ceilElem;
    }

    private static int getFloorOfElem(int[] inputArr, int elem) {

        int strtIndex = 0;
        int endIndex = inputArr.length-1;
        int floorElem = -1;

        while (strtIndex <= endIndex){


            int midIndex = strtIndex + (endIndex-strtIndex)/2;
            if(inputArr[midIndex] ==elem){
                return elem;
            }
            else if (inputArr[midIndex] < elem && inputArr[midIndex] > floorElem){
                floorElem = inputArr[midIndex];
            }
            if(inputArr[midIndex] > elem){
                endIndex = midIndex -1;
            }
            else if (inputArr[midIndex] < elem){
                strtIndex = midIndex+1;
            }

        }
        return floorElem;
    }
}
