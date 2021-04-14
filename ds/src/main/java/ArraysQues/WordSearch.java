package ArraysQues;

import javafx.util.Pair;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/*
Leetcode link: https://leetcode.com/problems/word-search/

Given a grid of m X n words and a string , return true if word exists in the grid.

Possible paths allowed: words can be constructed by sequentially ajacent cells where ajacent cells are horizontal
and vertical neighbours.

ex:
Input:
    [A, B, C, E]
    [S, F, C, S]
    [A, D, E, E]

word: "ABCCED"

output: true

 */
public class WordSearch {


    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'},
                               {'S', 'F', 'C', 'S'},
                               {'A', 'D', 'E', 'E'}};
        byte[][] bitsBoard = { {0, 0, 0, 0},
                               {0, 0, 0, 0},
                               {0, 0, 0, 0}
        };

        String word = "ABCB";
       // String word = "SEE";

        wordInGrid(board,word,bitsBoard);
    }

    private static void wordInGrid(char[][] board, String word,byte[][] bitsBoard) {

        int i,j;
        Character firstChar = word.charAt(0);
        List<Pair<Integer,Integer>> possibleStartCoordinates = new ArrayList<>();

        Boolean wordFound = false;

        for(i =0 ; i < 3; i++){
            for (j =0 ; j < 4; j++){
                if(board[i][j] == firstChar){
                    Pair<Integer,Integer> startCoordinate = new Pair<>(i,j);
                    possibleStartCoordinates.add(startCoordinate);
                }
            }
        }
        if(word.length() > 1) {
            for (Pair<Integer, Integer> coordinate : possibleStartCoordinates) {

                Pair startCoordinate = coordinate;
                Boolean completeWordExist = true;
                int charPointer = 1;

                while (completeWordExist && charPointer <= word.length() - 1) {

                    startCoordinate = searchAdjacentCells(startCoordinate, board, word.charAt(charPointer), bitsBoard);

                    // character not found in adjacent cells
                    if (startCoordinate == null) {
                        completeWordExist = false;
                        break;
                    }
                    charPointer++;
                }

                if (completeWordExist) {
                    wordFound = true;
                    break;
                }

            }
        }

        System.out.println("Word found: "+wordFound);

    }

    private static Pair<Integer, Integer> searchAdjacentCells(Pair<Integer, Integer> coordinate,
                                                              char[][] charMatrix,
                                                              char charAt, byte[][] bitsBoard) {
        int i = coordinate.getKey();
        int j = coordinate.getValue();

        if (i+1 < 3 && bitsBoard[i+1][j] != 1){
            if (charMatrix[i+1][j] == charAt){
                bitsBoard[i+1][j] = 1;
                return new Pair(i+1,j);
            }
        }

        if( i-1 > 0 && bitsBoard[i-1][j] != 1){
            if(charMatrix[i-1][j] == charAt){
                bitsBoard[i-1][j] = 1;
                return new Pair(i-1,j);
            }
        }

        if(j+1 < 4 && bitsBoard[i][j+1] != 1 ){
            if(charMatrix[i][j+1] == charAt ){
                bitsBoard[i][j+1] = 1;
                return new Pair(i,j+1);
            }
        }

        if(j-1 > 0 && bitsBoard[i][j-1] != 1){
            if(charMatrix[i][j-1] == charAt){
                bitsBoard[i][j-1] = 1;
                return new Pair(i,j-1);
            }
        }
        return null;
    }
}
