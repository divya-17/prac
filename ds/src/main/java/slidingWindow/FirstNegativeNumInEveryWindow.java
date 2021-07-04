package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

Given an arr of numbers and a window k, find the first negative number in each window.

arr = [12, -1, -7, 8, -15, 30, 16, 28]
k=3

first -ve in each windows:
[12, -1, -7] -> -1
[-1, -7, 8] -> -1
[-7, 8, -15]-> -7
[8, -15, 30]-> -15
[30, 16, 28]-> 0

o/p:
result => [-1, -1, -7, -15, 0]

 */
public class FirstNegativeNumInEveryWindow {


    public static void main(String[] args) {


        int[] arr = new int[] {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> result = new ArrayList<>();

        getFrstNegNumInEachWindow(arr,k,result);

        System.out.println(result);
    }

    private static void getFrstNegNumInEachWindow(int[] arr, int k, List<Integer> result) {

        Queue<Integer> indexQueue = new LinkedList<>();
        int strt = 0;
        int end = strt;

        while (end < arr.length){

            if(arr[end] < 0){
                indexQueue.add(end);
            }
            if(end-strt+1 == k){

                if(!indexQueue.isEmpty()){
                    result.add(arr[indexQueue.peek()]);
                }
                else if(indexQueue.isEmpty()){
                    result.add(0);
                }
                if(arr[strt] < 0){
                    indexQueue.remove();
                }
                strt++;

            }

            end++;
        }
    }
}
