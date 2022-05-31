package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
 */
public class NQueensProb {

    private static List<String> allQueenTracks;

    public static void main(String[] args) {

        int n = 2;
        int[][] matrix = new int[n][n];
        for(int i =0; i < matrix.length; i++){
            Arrays.fill(matrix[i],0);
        }
        allQueenTracks = new ArrayList<>();
        getAllQueenTracks(matrix,0,"");
        System.out.println(allQueenTracks);

    }

    private static void getAllQueenTracks(int[][] chessGrid, int col, String path) {

        if(col == chessGrid[0].length){
            allQueenTracks.add(path);
            return;
        }

        for(int row = 0; row < chessGrid.length; row++){
            if(isQueenSafe(row,col,chessGrid)) {
                chessGrid[row][col] = 1;
                getAllQueenTracks(chessGrid, col + 1, path + " " + row + "-" + col);
                chessGrid[row][col] = 0;
            }
        }
    }

    private static boolean isQueenSafe(int row, int col, int[][] chessGrid) {

        for(int i = row-1 , j= col ; i >=0; i--){
            if(chessGrid[i][j] == 1){
                return false;
            }
        }
        for(int i = row-1, j = col-1; i >=0 && j >=0; i--,j--){
            if(chessGrid[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j < chessGrid.length;i--,j++){
            if(chessGrid[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
