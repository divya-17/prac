package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array of N numbers that ideally should contain numbers 1 to N , but it has some numbers missing and
some numbers duplicate. Find missing and duplicate numbers (using O(1) space)
 */
public class MultipleMissingAndMultipleDup {

    private static Set<Integer> missingNums = new HashSet<>();
    private static Set<Integer> duplicateNums = new HashSet<>();

    public static void main(String[] args) {

        int[] inputArr= new int[] {2, 3, 1, 8, 2, 3, 5, 1};
        getMissingAndDuplicateElem(inputArr);

        System.out.println("Duplicate Nums "+duplicateNums);
        printArr(inputArr);
        System.out.println("Missing Nums "+missingNums);
    }

    private static void printArr(int[] inputArr) {

        for(int i =0; i < inputArr.length; i++){
           if(inputArr[i] != i+1){
               missingNums.add(i+1);
           }
        }
    }

    private static void getMissingAndDuplicateElem(int[] inputArr) {

        for(int i =0; i < inputArr.length; i++){

            while (inputArr[i] != i+1 ){

                if(inputArr[inputArr[i]-1] != inputArr[i]){
                    swapIndicies(i,inputArr[i]-1,inputArr);
                }
                else{
//                 missingNums.add(i+1);
                 duplicateNums.add(inputArr[i]);
                 break;
                }
            }
        }
    }

    private static void swapIndicies(int i, int i1, int[] inputArr) {

        int temp =  inputArr[i];
        inputArr[i] = inputArr[i1];
        inputArr[i1] = temp;
    }
}
