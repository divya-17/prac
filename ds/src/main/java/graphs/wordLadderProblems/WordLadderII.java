package graphs.wordLadderProblems;

/*
Given a start word , end word and set of words, find all possible shortest sequence to transform start word'
to end word.
*/


import java.util.*;

public class WordLadderII {

    private static Stack<String> seqStack = new Stack<>();
    private static Map<String,Set<String>> transformationGraph = new LinkedHashMap<>();
    private static Stack<String> wordStack = new Stack<>();
    private static List<List<String>> seqlist = new ArrayList<>();
    private static String startWord;
    private static String endWord;

    public static void main(String[] args) {

        startWord = "hit";
        endWord = "cog";
        List<String> wordList = new ArrayList(Arrays.asList("hot","dot","lot","dog","log","cog"));

        getAllPossibleSequence(startWord,endWord,wordList);
    }

    private static void getAllPossibleSequence(String startWord, String endWord, List<String> wordList) {

        HashSet<String> wordSet = new HashSet<>(wordList);
        Map<String,Integer> wordToDepthMap = new HashMap<>();

        initializeVisitedMap(wordSet,wordToDepthMap);

        Queue<String> wordQueue = new LinkedList<>();
        int depth =0;
        int numWordsPerLevel = 0;

        wordQueue.add(startWord);

        while (!wordQueue.isEmpty()){

            depth++;
            numWordsPerLevel = wordQueue.size();
            Set<String> wordPerLevel = new HashSet<>(wordQueue);

            for(String w: wordPerLevel){
                wordToDepthMap.put(w,depth);
            }

            while(numWordsPerLevel != 0){

                String currentWord =wordQueue.poll();


                Set<String> transformedWordList = new HashSet<>();

                for(int chPointer=0; chPointer < currentWord.length(); chPointer++){

                    for(char ch='a'; ch <='z'; ch++){

                        String transformedWord = currentWord.substring(0,chPointer)+ch+currentWord.substring(chPointer+1);

                        if(!transformedWord.equals(currentWord) &&
                                wordSet.contains(transformedWord) && (wordToDepthMap.get(transformedWord) == -1)){

                            wordQueue.add(transformedWord);
                            transformedWordList.add(transformedWord);
                        }
                    }
                }

                if (transformationGraph.containsKey(currentWord)) {
                    transformationGraph.get(currentWord).addAll(transformedWordList);
                }
                else{
                    transformationGraph.put(currentWord,new HashSet(transformedWordList));
                }

                    numWordsPerLevel--;
            }


        }

        System.out.println("Transformation graph is"+transformationGraph);
        printAllPossibleSequence();
    }

        private static void initializeVisitedMap(HashSet<String> wordSet, Map<String, Integer> wordToDepthMap) {

            for(String word: wordSet){
                wordToDepthMap.put(word,-1);
            }

        }

    private static void printAllPossibleSequence() {
        dfs(startWord);
        System.out.println("Seq list is "+seqlist);

    }

    private static void dfs(String currentWord) {

        wordStack.push(currentWord);

        if(currentWord.equals(endWord)){
            seqlist.add((Stack<String>)wordStack.clone());
            wordStack.pop();
            return;
        }

        for(String words: transformationGraph.get(currentWord)){
            dfs(words);
        }
        wordStack.pop();
    }


}
