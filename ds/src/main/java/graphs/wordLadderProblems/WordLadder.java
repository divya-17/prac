package graphs.wordLadderProblems;

import java.util.*;

/*
Given a start word, end word and set of many other words ,find the minimum number of ways in which the
start word can be transformed into the end word by doing just one character transformation at a time and the
transformed word should be present in the set of words.

https://www.youtube.com/watch?v=ZVJ3asMoZ18&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=32
 */
public class WordLadder {

    public static void main(String[] args) {

        String startWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        Set<String> wordSet = new HashSet<String>(wordList);

        int shortestDistance = getMinShortestSeq(startWord, endWord, wordSet);

        System.out.println("Shortest distance is " + shortestDistance);

    }

    private static int getMinShortestSeq(String startWord, String endWord, Set<String> wordSet) {


        int depth = 0;
        int numWordsPerLevel = 0;
        Queue<String> wordQueue = new LinkedList<>();

        if(!wordSet.contains(endWord)){
            return 0;
        }

        wordQueue.add(startWord);

        while (!wordQueue.isEmpty()) {

            depth++;

            numWordsPerLevel = wordQueue.size();

            while (numWordsPerLevel != 0){

                String currentWord = wordQueue.poll();

                for (int charPointer = 0; charPointer < currentWord.length(); charPointer++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String transformedWord = currentWord.substring(0, charPointer) + ch + currentWord.substring(charPointer + 1);
                        if (transformedWord.equals(endWord)) {
                            return depth+1;
                        } else if (transformedWord != currentWord && wordSet.contains(transformedWord)) {
                            // Remove matched word as all words are unique.
                            wordSet.remove(transformedWord);
                            wordQueue.add(transformedWord);

                        }
                    }
                }
                numWordsPerLevel--;

            }

        }

        return 0;
    }
}
