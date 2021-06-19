package popularInterviewProbs;

import popularInterviewProbs.WordSearchI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given an m x n board of characters and a list of strings words, return all words on the board.

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


 */
public class WordSearchII {


    public static void main(String[] args) {


        char[][] inputBoard = {{'o', 'a', 'a', 'n'},
                               {'e', 't', 'a', 'e'},
                               {'i', 'h', 'k', 'r'},
                               {'i', 'f', 'l', 'v'}
            };

        List<String> wordList = new ArrayList<>(Arrays.asList("oath","pea","eat","rain"));

        char[][] inputBoard1 = {{'a','b'},
                                {'c','d'}};

        List<String> wordList1 = new ArrayList<>(Arrays.asList("abcb"));

       // WordSearchI.wordSearch(inputBoard,"eat");

        List<String> finalList = new ArrayList<>();

        for(String word: wordList1){
            Boolean wordExistInBoard = WordSearchI.wordSearch(inputBoard1,word);
            if(wordExistInBoard){
                finalList.add(word);
            }
        }

        System.out.println("Final list is "+finalList);


    }


}
