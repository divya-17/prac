package graphs;

import java.util.*;

/*

Given various stops (in form of vertex ) and cost between those stops in form of edges in a directed graph
find minumum cost path that a person will incur to travel from source to destination if only k max stops is allowed b/w src
and dest.

eg:
Graph:
     0 -> [(1,100),(3,300)]
     1 -> [(2,50),(3,100]
     2 -> [(0,10)(4,10)]
     3 -> [(2,10)]
     4 -> [(1,100)]

if k = 3 Min cost = 220
if k = 2 Min cost = 320

Time complexity => (V+E)
max(E) = V2 (In case all vertex of the graph are connected to each other so worst cast time complexity will be V+V2).
 */
public class CheapestFlightWithKStops {

    private static Map<Integer, List<Map<Integer, Integer>>> flightDetailsMap = new HashMap<>();
    private static Map<Integer,List<Map<Integer, Integer>>> flightDetailMap1 = new HashMap<>();
    //private static Integer maxStopsAllowed = 3;
    private static Integer costToIncur = Integer.MAX_VALUE;
    private static boolean[] visitedArray = new boolean[5];
    private static Integer src = 0;
    private static Integer dest = 4;

    public static void main(String[] args) {


        Map<Integer, List<Integer>> testMap = new HashMap<>();

        testMap.put(1, new ArrayList<>(Arrays.asList(2, 3)));


        flightDetailMap1.put(0, new ArrayList(Arrays.asList(new HashMap() {{
            put(1,100);
            put(3,300);
        }})));

        flightDetailMap1.put(1, new ArrayList(Arrays.asList(new HashMap() {{
            put(3,100);
        }})));

        flightDetailMap1.put(2, new ArrayList(Arrays.asList(new HashMap() {{
            put(4,10);
        }})));

        flightDetailMap1.put(3, new ArrayList(Arrays.asList(new HashMap() {{
            put(2,10);
        }})));

        flightDetailMap1.put(4, new ArrayList(Arrays.asList(new HashMap() {{
            put(1,100);
        }})));



//        flightDetailsMap.put(0, new ArrayList(Arrays.asList(new HashMap<Integer, Integer>() {{
//            put(1, 100);
//        }}, new HashMap<Integer, Integer>() {{
//            put(3, 300);
//        }})));
//        flightDetailsMap.put(1, new ArrayList(Arrays.asList(new HashMap() {{
//            put(2, 50);
//        }}, new HashMap() {{
//            put(3, 100);
//        }})));
//        flightDetailsMap.put(2, new ArrayList(Arrays.asList(new HashMap() {{
//            put(0, 10);
//        }}, new HashMap() {{
//            put(4, 10);
//        }})));
//        flightDetailsMap.put(3, new ArrayList(Arrays.asList(new HashMap() {{
//            put(2, 10);
//        }})));
//        flightDetailsMap.put(4, new ArrayList(Arrays.asList(new HashMap() {{
//            put(1, 100);
//        }})));


        visitedArray[0] = true;
//        dfs(0,maxStopsAllowed,currCost);
//        System.out.println("Min cost of the trip will be "+costToIncur);

        dfs(0,2,0);
        System.out.println("Min cost of thr trip will be "+costToIncur);
    }

    private static void dfs(Integer currVertex,  int maxStopsAllowed, int currCost) {

        System.out.println("Checking for vertex: "+currVertex);

        if ( flightDetailMap1.get(src) == null || currCost > costToIncur) {
            return;
        }

        List<Map<Integer, Integer>> connVertices = flightDetailMap1.get(currVertex);

        System.out.println("Conn vertices is "+connVertices);

        for (Map<Integer, Integer> vertexDetailMap : connVertices) {

            System.out.println("checking for "+vertexDetailMap.entrySet().iterator().next());
            Map.Entry<Integer, Integer> currValue = vertexDetailMap.entrySet().iterator().next();

            currVertex = currValue.getKey();

            if(currVertex != dest && maxStopsAllowed == 0){
                return;
            }

            if (currVertex == dest) {
                costToIncur = Math.min(costToIncur, currCost+currValue.getValue());
                return;
            }

            if(!visitedArray[currValue.getKey()]) {
                visitedArray[currVertex] = true;
                dfs(currVertex,maxStopsAllowed-1,currCost+currValue.getValue());
                visitedArray[currVertex] = false;
                System.out.println("Returning for vertex "+currVertex);
            }

        }
    }

}
