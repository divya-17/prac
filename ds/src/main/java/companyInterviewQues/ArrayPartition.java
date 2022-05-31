package companyInterviewQues;

import javax.persistence.criteria.CriteriaBuilder;

/*
Given an unsorted array, find the index in the array such that if we partition the array at that index
then all elem in the left of that index is smaller than all elems in the right of that index.

Ex:
arr: [5, 1, 4, 3, 6, 8, 10, 7, 9]
O/p: 4

arr: [5, 1, 4, 4]
O/p: -1 (No such index exist)

 */
public class ArrayPartition {

    public static void main(String[] args) {

        int[] ipArr = new int[] {5, 1, 4, 3, 6, 8, 10, 7, 9};
        //int[] ipArr1 = new int[] {5, 1, 4, 4};

        printArr(ipArr);
        int res1 = findPartitionIndx(ipArr);
        //int res2 = findPartitionIndx(ipArr1);
    }

    private static int findPartitionIndx(int[] ipArr) {

        int minSoFar = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;

        int [] minArr = new int[ipArr.length];
        int [] maxArr = new int[ipArr.length];

        for(int i = 0; i < ipArr.length; i++){


            if(ipArr[i] > maxSoFar){
                maxArr[i] = ipArr[i];
                maxSoFar = ipArr[i];
            }
            else{
                maxArr[i] = maxSoFar;
            }

        }
        for(int i = ipArr.length-1; i >= 0; i--){
            if(ipArr[i] < minSoFar){
                minArr[i] = ipArr[i];
                minSoFar = ipArr[i];
            }
            else{
                minArr[i] = minSoFar;
            }
        }

        int resIndex = -1;
        for(int i =0; i < minArr.length; i++){
            if(minArr[i] == maxArr[i]){
                resIndex = i;
                break;
            }
        }
        return resIndex;
    }


    private static void printArr(int[] ipArr) {

        for(int i =0; i < ipArr.length; i++){
            System.out.print(ipArr[i]+",");
        }
        System.out.println();
    }
}
