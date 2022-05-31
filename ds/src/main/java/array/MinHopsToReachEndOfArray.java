package array;

/*

IMP Ques:

Given an array such that number at any index of array indicates max number of jumps that can be
taken from that position, find minimum number of hops required to reach end of the array.

ex [1, 2]
    1 at index 0 indicates we can make 1 jump from this point.
    2 at index 1 indicates we can make 1, 2 jumps from this point.
 */
public class MinHopsToReachEndOfArray {

    public static void main(String[] args) {

        int[] inputArr = new int[] {1, 3, 2, 0, 1, 4};

        int [] inputArr1 = new int[] {2, 3, 1, 1, 4};

        int[] inputArr2 = new int[] {2, 0, 0, 1, 6};
        int minJumpsRequired = getMinJumpsRequiredToReachEndOfArr(inputArr1);
        if(minJumpsRequired == Integer.MAX_VALUE){
            System.out.println("Min jumps required "+"-1");

        }else {
            System.out.println("Min jumps required " + minJumpsRequired);
        }


        int minJumpsRequired1 = getMinJumpsRequiredOptimized(inputArr1);
        System.out.println("Result "+minJumpsRequired1);
    }

    /*
        This approach takes O(n)
     */
    private static int getMinJumpsRequiredOptimized(int[] inputArr1) {

       int currPos = 0;
       int maxReachable = 0;
       int jump =0;

       for(int i =0; i < inputArr1.length-1; i++){

           maxReachable = Math.max(maxReachable,inputArr1[i]+i);

           if(i == currPos){
               currPos = maxReachable;
               jump++;
           }
       }
       return jump;
    }


    /*
        This approach takes O(n^2) TC.
     */
    private static int getMinJumpsRequiredToReachEndOfArr(int[] inputArr) {

        int[] minHopArr = new int[inputArr.length];

        minHopArr[0] = 0;
        for(int i = 1; i < minHopArr.length; i++){
            minHopArr[i] = Integer.MAX_VALUE;
        }
        for(int j = 1; j < inputArr.length; j++){

            for(int i = 0; i<j; i++){

                if(inputArr[i]+i >= j && minHopArr[i] != Integer.MAX_VALUE){

                    minHopArr[j] = Math.min(minHopArr[j],minHopArr[i]+1);
                }
            }
        }
        printArr(minHopArr);
        return minHopArr[minHopArr.length-1];
    }

    private static void printArr(int[] minHopArr) {

        for(int j =0; j < minHopArr.length; j++){
            System.out.print(minHopArr[j]+" , ");
        }
        System.out.println();
    }
}
