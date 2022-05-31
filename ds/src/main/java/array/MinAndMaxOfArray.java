package array;

import javafx.util.Pair;

/*
Given an unsorted array, find min and max element of the array using minimum number of comparisions

 */
public class MinAndMaxOfArray {

    public static void main(String[] args) {

        int [] arr1 = new int[] {2, 5, 1, 6, 3, 4};
        int [] arr2 = new int[] {7, 9, 11, 3, 5};

        Pair<Integer,Integer> result1 = getMinAndMaxElem(arr1);

        System.out.println("Min: "+result1.getKey());
        System.out.println("Max: "+result1.getValue());

        Pair<Integer,Integer> result2 = getMinAndMaxElem(arr2);

        System.out.println("Min: "+result2.getKey());
        System.out.println("Max: "+result2.getValue());
    }

    private static Pair<Integer, Integer> getMinAndMaxElem(int[] arr1) {

            Integer maxElem = arr1[0];
            Integer minElem = arr1[0];

            if(arr1.length >=2){

                if(arr1[0] > arr1[1]){
                    maxElem=arr1[0];
                    minElem = arr1[1];
                }
                else {
                    maxElem = arr1[1];
                    minElem = arr1[0];
                }
            }

            if(arr1.length <= 2){
                return new Pair<>(minElem,maxElem);
            }

            int startIndex = 0;

            if(arr1.length %2 == 0){
                startIndex = 2;
            }
            else{
                startIndex = 1;
            }

            while (startIndex < arr1.length){


                if(arr1[startIndex] > arr1[startIndex+1]){

                    if(arr1[startIndex] > maxElem){
                        maxElem = arr1[startIndex];
                    }
                    if(arr1[startIndex+1] < minElem){
                        minElem = arr1[startIndex+1];
                    }
                }
                else if(arr1[startIndex] < arr1[startIndex+1]){

                    if(arr1[startIndex] < minElem){
                        minElem = arr1[startIndex];
                    }
                    if(arr1[startIndex+1] > maxElem){
                        maxElem = arr1[startIndex+1];
                    }
                }
                startIndex = startIndex+2;
            }

            return new Pair<>(minElem,maxElem);
    }
}
