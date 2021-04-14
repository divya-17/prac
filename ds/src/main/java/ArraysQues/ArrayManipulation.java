package ArraysQues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

Given a single dimensional arrays of zero and a list of operations, for each operation add a value to each element
of the array between 2 indices, inclusive. Once all operations are performed, return the maximum value

Ex:

Input:
a   b   k

1   2   100
2   5   100
3   4   100

InputArr = [0, 0, 0, 0, 0, 0]

Sol:

[0     0     0     0     0     0]
+100   +100
       +100  +100  +100  +100
             +100  +100


 [ 100, 200 , 200, 200,  100, 0 ] ==> final Arr


 Max element in final arr is 200.

 Algorithm used here- prefix sum algo

 Explaination video: https://www.youtube.com/watch?v=hDhf04AJIRs

 */
public class ArrayManipulation {


    public static void main(String[] args) {


        int arr [] = {0 ,0, 0, 0, 0, 0};
        int m =3;
        int [] [] queries = new int [m][3];

        queries[0][0] = 1;
        queries[0][1] = 2;
        queries[0][2] = 100;

        queries[1][0] = 2;
        queries[1][1] = 5;
        queries[1][2] = 100;

        queries[2][0] = 3;
        queries[2][1] = 4;
        queries[2][2] = 100;

        int n  = arrayManipulation(queries,arr,m);
    }

    private static int arrayManipulation(int[][] queries, int [] arr,int m) {

        int max=0;
        for (int i =0; i < m; i++){

            int startIndex = queries[i][0]-1;
            int endIndex = queries[i][1]-1;
            int sumValue = queries[i][2];

            arr[startIndex] = arr[startIndex]+sumValue;

            if(endIndex < arr.length-1) {
                arr[endIndex + 1] = arr[endIndex+1]-sumValue;
            }
        }
        System.out.println("Resultant array "+ Arrays.toString(arr));

        //Iterating through the array and summing up the elements
        for(int k =0; k <arr.length; k++){

            if (k!=0){
                arr[k] = arr[k]+arr[k-1];
            }
            if(arr[k] > max){
                max = arr[k];
            }
        }

        System.out.println("Final array "+Arrays.toString(arr));
        System.out.println("Max is "+max);
        return 0;
    }




}
