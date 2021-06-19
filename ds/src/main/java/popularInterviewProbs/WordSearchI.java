package popularInterviewProbs;

import javafx.util.Pair;

/*

This problem is same as WordSearchBackTrack but is done a bit differently.

Prb:

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"

Output: true

 */
public class WordSearchI {

    public static Boolean exist;

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}

        };


        String word = "ABCCED";

        Boolean exist = wordSearch(board,word);

        System.out.println("Word exist: "+exist);
    }

    public static Boolean wordSearch(char[][] board, String word) {

        //printboard(board);

        Boolean found = false;
        int pos=0;
        outerloop:
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length;j++){
                if(board[i][j] == word.charAt(pos)){
                    found = true;
                    exist = wordExistInBoard(board,i,j,word,pos);
                    if(exist) {
                        break outerloop;
                    }
                }
            }
        }

        if(!found) exist= false;

        //System.out.println(exist);

        return exist;
    }

    private static void printboard(char[][] board) {

        for(int i=0;  i< board.length; i++){
            for (int j=0 ; j < board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static Boolean wordExistInBoard(char[][] board, Integer i, Integer j, String word,int pos) {

        char temp = 0;
        pos = pos+1;

        if(pos == word.length()){
            return true;
        }
        Pair<Boolean, Pair<Integer,Integer>> charsAtAdjCells= checkAdjacentCells(board, i,j, word,pos);

        if(charsAtAdjCells.getKey().equals(false)){
            return false;
        }

        temp = board[i][j];
        board[i][j] = '*';

        Boolean result =  wordExistInBoard(board,(charsAtAdjCells.getValue()).getKey(),(charsAtAdjCells.getValue()).getValue(),word,pos);

        board[i][j] = temp;

        return result;
    }

    public static Pair<Boolean,Pair<Integer,Integer>> checkAdjacentCells(char[][] board, int i, int j, String word, int pos) {


        Pair result = new Pair(false, new Pair<>(-1, -1));

        if(i-1 >= 0){
            if (board[i-1][j] == word.charAt(pos)){
                result = new Pair(true,new Pair(i-1,j));
            }
        }
        if(i+1 < board.length){

            if(board[i+1][j] == word.charAt(pos)){
                result = new Pair<>(true,new Pair(i+1,j));
            }
        }
        if(j-1 >= 0){
            if(board[i][j-1] == word.charAt(pos)){
                result = new Pair<>(true,new Pair<>(i,j-1));
            }
        }
        if(j+1<board[0].length){
            if(board[i][j+1] == word.charAt(pos)){
                result = new Pair(true,new Pair<>(i,j+1));
            }
        }

        
        return result;
    }


}
