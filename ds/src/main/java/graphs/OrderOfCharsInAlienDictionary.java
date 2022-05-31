package graphs;

import java.util.*;

/*
https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/

Given sorted dictionary of alien words, find the correct order of characters.
 */
public class OrderOfCharsInAlienDictionary {


    private static Queue<Character> ansQueue = new LinkedList<>();

    public static void main(String[] args) {

        List<String> orderedWordList = new LinkedList<>();


        Map<Character,List<Character>> adjMap = new HashMap<>();

        orderedWordList.add("baa");
        orderedWordList.add("abcd");
        orderedWordList.add("abca");
        orderedWordList.add("cab");
        orderedWordList.add("cad");


        populateAdjMap(orderedWordList,adjMap);
        System.out.println(adjMap);
        Queue<Character> dictQueue = getTopologicalSort(adjMap);

        System.out.println(dictQueue);
    }

    private static Queue<Character> getTopologicalSort(Map<Character, List<Character>> adjMap) {

        Map<Character,Integer> inDegreeMap = new HashMap<>();

        for(Map.Entry<Character,List<Character>> entry: adjMap.entrySet()){

            for(Character c: entry.getValue()){
                if(inDegreeMap.containsKey(c)){
                    inDegreeMap.put(c,inDegreeMap.get(c)+1);
                }
                else{
                    inDegreeMap.put(c,1);
                }
            }
        }
        Queue<Character> charQueue = new LinkedList<>();
        int count = 0;


        for(Map.Entry<Character,List<Character>> entry: adjMap.entrySet()){

            if(!inDegreeMap.containsKey(entry.getKey())){
                charQueue.add(entry.getKey());
                count++;
            }
            while (!charQueue.isEmpty()){
                Character currValue = charQueue.poll();
                ansQueue.add(currValue);
                List<Character> connVertices = adjMap.get(currValue);
                if(connVertices != null) {

                    for (Character vertexChar : connVertices) {
                        int val = inDegreeMap.get(vertexChar);
                        inDegreeMap.put(vertexChar, val - 1);
                        if (inDegreeMap.get(vertexChar) == 0) {
                            count++;
                            charQueue.add(vertexChar);
                        }
                    }
                }
            }
        }

        return ansQueue;

    }

    private static void populateAdjMap(List<String> orderedWordList, Map<Character, List<Character>> adjMap) {

        for(int i = 0; i < orderedWordList.size(); i++){

            if(i+1 < orderedWordList.size()) {
                String s1 = orderedWordList.get(i);
                String s2 = orderedWordList.get(i+1);

                int index = 0;
                while(s1.charAt(index) == s2.charAt(index)){
                    index++;
                }

                Character src = s1.charAt(index);
                Character dst = s2.charAt(index);

                if(adjMap.containsKey(src)){
                    adjMap.get(src).add(dst);
                }
                else {
                    adjMap.put(src,new ArrayList<>(Arrays.asList(dst)));
                }
            }

        }
    }
}
