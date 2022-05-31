package binarySearch;

import javafx.util.Pair;

/*
Given a 2D array that is sorted row wise and column wise, search for a key in that matrix.

Ex:
Matrix : [10, 20, 30, 40]
         [15, 25, 35, 45]
         [27, 29, 37, 48]
         [32, 33, 39, 50]

 Key = 32.

 O/p: Index of key is (3,0)
 */
public class SearchAnElemInTwoDimenSortedArr {

    public static void main(String[] args) {

        int[] [] matrix = new int[][] {{10, 20, 30, 40},
                                       {15, 25, 35, 45},
                                       {27, 29, 37, 48},
                                       {32, 33, 39, 50}};


        int key = 37;

        Pair keyIndex = getIndexOfKey(key,matrix);
        System.out.println("Index of key "+key+" is "+keyIndex);
    }

    private static Pair<Integer,Integer> getIndexOfKey(int key, int[][] matrix) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int rowIndex = 0;
        int colIndex = colLen-1;


        while ( (rowIndex <= rowLen-1) && (colIndex >=0)){

            int currentKey = matrix[rowIndex][colIndex];

            if(currentKey == key){
                return new Pair(rowIndex,colIndex);
            }
            else if( key > currentKey){
                rowIndex = rowIndex+1;
            }
            else if(key < currentKey){
                colIndex = colIndex-1;
            }
        }

        return new Pair<>(-1,-1);
    }
}
