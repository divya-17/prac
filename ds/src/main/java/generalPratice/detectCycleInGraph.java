package generalPratice;

import java.util.*;

public class detectCycleInGraph {

    private static Map<Character, List<Character>> adjList= new HashMap<>();
    private static boolean[] visitedFlag = new boolean[10];
    private static boolean cycleDetected = false;
    private static Stack<Character> cycleChars = new Stack<>();

    public static void main(String[] args) {

        adjList.put('A',new ArrayList<>(Arrays.asList('B')));
        adjList.put('B',new ArrayList<>());
        adjList.put('C',new ArrayList<>(Arrays.asList('B','D')));
        adjList.put('D',new ArrayList<>(Arrays.asList('E')));
        adjList.put('E',new ArrayList<>(Arrays.asList('A','C')));


        for(Character ch: adjList.keySet()) {
            System.out.println("Checking for: "+ch);
            detectCycle(ch);
            if(cycleDetected) {
                break;
            }

         }

    }

    private static void print(boolean[] visitedFlag) {

        for(int i=0; i < visitedFlag.length;i++){
            System.out.print(visitedFlag[i]+" , ");
        }
    }

    private static void detectCycle(char startVertex) {

        if(visitedFlag[startVertex-'A']){
            System.out.println("Cycle detected for ");
            System.out.println(cycleChars);
            cycleDetected = true;
            return;
        }
        visitedFlag[startVertex-'A'] = true;
        cycleChars.push(startVertex);

        if(adjList.get(startVertex) != null && !adjList.get(startVertex).isEmpty()){

            for(Character ch: adjList.get(startVertex)){
                detectCycle(ch);
            }

        }
        visitedFlag[startVertex-'A'] = false;
        cycleChars.pop();

    }

}
