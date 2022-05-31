package graphs.topologicalSort.DFS;

import java.util.*;

/*
Sorting graph topologically using DFS:
https://www.youtube.com/watch?v=qe_pQCh09yU&list=PLEJXowNB4kPzByLnnFYNSCoqtFz0VKLk5&index=13

 */
public class Main {

    private static Stack<Integer> coursePath = new Stack<>();
    private static boolean cycleDetected = false;
    private static Map<Node, List<Node>> adjNodeList = new HashMap();
    private static Map<Node,List<Node>> cyclicAdjList = new HashMap<>();

    public static void main(String[] args) {

        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        adjNodeList = new HashMap() {{
            put(n0, new ArrayList(Arrays.asList(n2, n3)));
            put(n3, new ArrayList(Arrays.asList(n1)));
            put(n4, new ArrayList(Arrays.asList(n1, n2)));
            put(n5, new ArrayList(Arrays.asList(n0, n2)));

        }};

        //        cyclicAdjList = new HashMap() {{
//            put(n0, new ArrayList(Arrays.asList(n5,n3)));
//            put(n2, new ArrayList(Arrays.asList(n0)));
//            put(n3, new ArrayList(Arrays.asList(n1)));
//            put(n4, new ArrayList(Arrays.asList(n1,n2)));
//            put(n5, new ArrayList(Arrays.asList(n2)));
//        }};


        for(Map.Entry<Node,List<Node>> entry: adjNodeList.entrySet()){
            if(entry.getKey().getColor() == Color.WHITE) {
                getPathForCompletingAllCourse(entry.getKey());
            }
            if(cycleDetected){
                System.out.println("Cycle detected. Not possible to complete all courses");
                break;
            }
        }
        if(!cycleDetected){
            System.out.println("Possible path to complete all courses are: ");
            System.out.println(coursePath);
        }

    }

    private static void getPathForCompletingAllCourse(Node startNode) {

        if(startNode.getColor()== Color.GREY){
            cycleDetected = true;
            return;
        }
        else if (startNode.getColor() == Color.BLACK){
            return;
        }
        startNode.setColor(Color.GREY);

        List<Node> connectingNodes = adjNodeList.get(startNode);

        if(connectingNodes == null){
            coursePath.add(startNode.getValue());
            startNode.setColor(Color.BLACK);
            return;
        }
        for(Node node: connectingNodes){
            getPathForCompletingAllCourse(node);
        }
        coursePath.add(startNode.getValue());
        startNode.setColor(Color.BLACK);
    }

}
