package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given matrix of length n*n. Rat starting from index (0,0) and ending up at index (n-1,n-1).
Print all possible paths that rat can take. Allowed paths are down and right

Ex:
matrix = [1, 0, 0, 0]
         [1, 1, 0, 1]
         [1, 1, 0, 0]
         [0, 1, 1, 1]

O/p: ["DDRDRR","DRDDRR"]


 */
public class RatMazeProb {

    private static List<String> allPossiblePaths;

    public static void main(String[] args) {

        int[][] matrix = new int[][]{   { 1, 0, 0, 1},
                                        { 1, 1, 0, 1},
                                        { 1, 1, 0, 0},
                                        {0, 1, 1, 1}};

        allPossiblePaths = new ArrayList<>();

        if(matrix[0][0] == 0 || matrix[matrix.length-1][matrix[0].length-1] == 0){
            System.out.println("No paths possible");
        }
        else {
            getAllMazePaths(0, 0, matrix, "");
        }
        System.out.println(allPossiblePaths);
    }

    public static void getAllMazePaths(int currRow, int currCol, int[][] matrix,String currPath){

        if(currRow == matrix.length-1 && currCol == matrix[0].length-1){
            allPossiblePaths.add(currPath);
            return;
        }
        if(matrix[currRow][currCol] == 0) {
            return;
        }
        if(currRow == matrix.length-1){
            getAllMazePaths(currRow,currCol+1,matrix,currPath+"R");
        }
        else if(currCol == matrix[0].length-1){
            getAllMazePaths(currRow+1,currCol,matrix,currPath+"D");
        }
        else{
            getAllMazePaths(currRow,currCol+1,matrix,currPath+"R");
            getAllMazePaths(currRow+1,currCol,matrix,currPath+"D");
        }

    }
}
