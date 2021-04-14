package ArraysQues;

import java.util.Arrays;

/*

https://leetcode.com/problems/uncrossed-lines/
 */
public class UncrossedLines {


    public static void main(String[] args) {


//        int A [] = {2, 5, 1, 2, 5};
//        int B [] = {10, 5, 2, 1, 5, 2};

//        int A[] = {1, 3, 7, 1, 7, 5};
//        int B[]  = {1, 9, 2, 5, 1};

        int A[] = {1, 4, 2};
        int B[] = {1, 2, 4};

        int numLines = maxUncrossedLines(A, B);

        System.out.println("Max uncrossed lines "+numLines);
    }

    private static int maxUncrossedLines(int[] a, int[] b) {

        int[] arr1;
        int [] arr2;
        int totalCount = 0;

        if(a.length < b.length){
            arr1 = a;
            arr2 = b;
        }
        else {
            arr1 = b;
            arr2 = a;
        }

        int jStrtIndex = -1;

        for(int i = 0; i < arr1.length; i++){

            for(int j=jStrtIndex+1; j< arr2.length; j++){

                if(arr1[i] == arr2[j]){
                    totalCount ++;
                    jStrtIndex = j;
                    break;
                }
            }
        }


        return totalCount;
    }
}
