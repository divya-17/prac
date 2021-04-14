package ArraysQues;

import java.util.HashMap;
import java.util.Map;

/*

Given an unordered list consisting of consecutive integers without any duplicates. You are allowed to swap any 2 elements.
You need to find minimum number of swaps required to sort the array

Exp:

arr = [7, 1, 3, 2, 4, 5, 6]

1st iteration:
swap (index[0], index[1])
arr = [1, 7, 3, 2, 4, 5, 6]

2nd iteration:
swap (index[1], index[3])
arr = [1, 2, 3, 7, 4, 5, 6]

3rd iteration:
swap (index[3], index[4])
arr = [1, 2, 3, 4, 7, 5, 6]

4th iteration:
swap (index[4], index[5])
arr = [1, 2, 3, 4, 5, 7, 6]

5th iteration:
swap (index[5], index[6])
arr = [1, 2, 3, 4, 5, 6, 7]

Minimum swap count to sort the array = 5

Link for explaination: https://www.youtube.com/watch?v=JrzIgYS3SqM

 */
public class Minimum2Swaps {

    public static void main(String[] args) {

        int [] arr1 = {7, 1, 3, 2, 4, 5, 6};
        int[] arr2 = {6, 3, 8, 10, 7, 4, 5, 2, 1, 9};

        int n = getMinimumSwapCount(arr2);

        System.out.println("Minimum swap count is "+n);

    }

    private static int getMinimumSwapCount(int[] arr) {

        int totalCount = 0;
        Map<Integer,Boolean> visitedMap = new HashMap<>();

        for (int i =0 ; i < arr.length ; i++){


            if(visitedMap.get(i) == null) {
                int a = i;
                int b = arr[i] - 1;
                visitedMap.put(a, true);

                while (b != i) {

                    a = b;
                    b = arr[a] - 1;
                    totalCount++;
                    visitedMap.put(a, true);

                }
                System.out.println("HashMap is " + visitedMap);

            }
            else{
                continue;
            }
        }
    return totalCount;
    }

}
