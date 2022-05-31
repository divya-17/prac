package graphs.stronglyConnectedGraphsAlgo;

import java.util.*;

/*
A graph is called strongly connected graph if we can reach to any vertex of the graph from every other vertex.

If the entire graph is not strongly connected then we need to find the components that are strongly connected.
 */
public class KosarajuAlgo {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> originalGraph = new HashMap<>();
        Map<Integer,List<Integer>> transposeGraph = new HashMap<>();
        List<List<Integer>> stronglyConnectedComponents = new ArrayList<>();

        Map<Integer,Boolean> visitedFlag = new HashMap<>();

        Stack<Integer> traversalStack = new Stack<>();

        constructOriginalGraph(originalGraph);

        Set<Integer> vertices = constructTransposeGraph(originalGraph,transposeGraph);

        initVisitedMap(vertices,visitedFlag);

        dfsTraversal(0,traversalStack,visitedFlag,originalGraph);

        initVisitedMap(vertices,visitedFlag);

        constructStronglyConnnectedComponents(visitedFlag,traversalStack,stronglyConnectedComponents,transposeGraph);

    }

    private static void constructStronglyConnnectedComponents(Map<Integer, Boolean> visitedFlag,
                                                              Stack<Integer> traversalStack,
                                                              List<List<Integer>> stronglyConnectedComponents,
                                                              Map<Integer, List<Integer>> transposeGraph) {

        while (!traversalStack.isEmpty()){

            Integer currNode = traversalStack.pop();

            if(!visitedFlag.get(currNode)){
                List<Integer> scList = new ArrayList<>();
                dfs(currNode,transposeGraph,visitedFlag,scList);
                stronglyConnectedComponents.add(scList);
            }

        }
        System.out.println(stronglyConnectedComponents);
    }

    private static void dfs(Integer currNode,
                            Map<Integer, List<Integer>> transposeGraph,
                            Map<Integer, Boolean> visitedFlag,
                            List<Integer> scList) {

        visitedFlag.put(currNode,true);
        scList.add(currNode);
        List<Integer> connNodes = transposeGraph.get(currNode);
        if(connNodes != null) {
            for (Integer node : connNodes) {
                if (!visitedFlag.get(node))
                    dfs(node, transposeGraph, visitedFlag, scList);
            }
        }
    }

    private static void initVisitedMap(Set<Integer> vertices, Map<Integer, Boolean> visitedFlag) {

        for(Integer vertex: vertices){
            visitedFlag.put(vertex,false);
        }
    }

    
    private static void dfsTraversal(Integer startNode,Stack<Integer> traversalStack,
                                     Map<Integer, Boolean> visitedMap,
                                     Map<Integer, List<Integer>> originalGraph) {
        visitedMap.put(startNode,true);

        List<Integer> connNodes = originalGraph.get(startNode);
        if(connNodes == null){
            traversalStack.push(startNode);
            return;
        }
        for(Integer node: connNodes){
            if(!visitedMap.get(node))
                dfsTraversal(node,traversalStack,visitedMap,originalGraph);
        }
        traversalStack.push(startNode);

    }

    private static void constructOriginalGraph(Map<Integer, List<Integer>> originalGraph) {

        originalGraph.put(0,new ArrayList<>(Arrays.asList(1)));
        originalGraph.put(1,new ArrayList<>(Arrays.asList(2)));
        originalGraph.put(2,new ArrayList<>(Arrays.asList(0,3)));
        originalGraph.put(3,new ArrayList<>(Arrays.asList(4)));
        originalGraph.put(4,new ArrayList<>(Arrays.asList(5,7)));
        originalGraph.put(5,new ArrayList<>(Arrays.asList(6)));
        originalGraph.put(6,new ArrayList<>(Arrays.asList(4,7)));

    }

    private static Set<Integer> constructTransposeGraph(Map<Integer,List<Integer>> originalGraph,
                                                                      Map<Integer,List<Integer>> transposeGraph){
        Set<Integer> vertices = new HashSet<>();

        for(Map.Entry<Integer,List<Integer>> edge: originalGraph.entrySet()){

            vertices.add(edge.getKey());
            for(Integer connEdge: edge.getValue()){
                vertices.add(connEdge);
                if(transposeGraph.containsKey(connEdge)){
                    transposeGraph.get(connEdge).add(edge.getKey());
                }
                else{
                    transposeGraph.put(connEdge,new ArrayList<>(Arrays.asList(edge.getKey())));
                }
            }
        }
        return vertices;
    }
}
