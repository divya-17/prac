package ArraysQues;

//import javafx.util.Pair;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Stack;

/*

leetcode: https://leetcode.com/problems/word-search/
Explaination: https://www.youtube.com/watch?v=mXWKVqGcL1M

 */
public class WordSearchBackTrack {


    public static void main(String[] args) {

        char [] [] boards = {{'A','B','C','E'},
                             {'S', 'F','C','S'},
                             {'A','D','E','E'}};

        //String word = "ABCCED";
        String word = "ADE";

        Stack stack = new Stack<String>();

        Boolean found = search(boards,word,stack);
        System.out.println("Word found => "+found);


    }

    private static Boolean search(char[][] boards, String word,Stack stack) {

        for(int i=0; i < boards.length; i++){

            for(int j=0; j < boards[0].length; j++){

                if(boards[i][j] == word.charAt(0) && dfs(boards,i,j,word,0,stack)){

                    while (!stack.empty()) {
                        System.out.println(stack.pop());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] boards, int i, int j, String word, int pos,Stack stack) {

        if( pos == word.length()){
            return true;
        }

        if( i == -1 || i == boards.length || j ==-1 || j == boards[0].length || boards[i][j] != word.charAt(pos)){

            return false;
        }
        System.out.println("Checking at i " + i + " j " + j + " char " + boards[i][j]);
        char temp = boards[i][j];

        boards[i][j] = '*';
        //System.out.println(temp+"==>("+i+","+j+")");

        boolean found = dfs(boards, i + 1, j, word, pos + 1,stack) ||
                dfs(boards, i - 1, j, word, pos + 1,stack) ||
                dfs(boards, i, j + 1, word, pos + 1,stack) ||
                dfs(boards, i, j - 1, word, pos + 1,stack);
        boards[i][j] = temp;
        System.out.println(" found is " + found);
        if (found) {
            System.out.println(" Inserting in stack " + i + "," + j + " -> " + boards[i][j]);
            stack.push(i + "," + j + " -> " + boards[i][j]);
        }
        return found;
    }
}
