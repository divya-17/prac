package graphs.detectCycle.directedGraph;

import java.util.Stack;

public class App {

    public static void main(String[] args) {

        Graph gf = new Graph(5);

        Vertex v0 = new Vertex('0');
        Vertex v1 = new Vertex('1');
        Vertex v2 = new Vertex('2');
        Vertex v3 = new Vertex('3');
        Vertex v4 = new Vertex('4');

        gf.addEdge(v0,v1);
        gf.addEdge(v2,v1);
        gf.addEdge(v2,v3);
        gf.addEdge(v3,v4);
        gf.addEdge(v4,v0);
        gf.addEdge(v4,v2);


        Stack<Integer> graphCyclePath = new Stack<Integer>();

        for(int i=0 ; i < 5; i++){
            if(gf.detectCycle(i)){
                System.out.println("Vertices creating graph cycle are");
                for(Integer v: gf.getGraphCyclePath()){
                    System.out.println(v);
                }
                break;
            }
        }


    }

    public static void printArr(boolean[] arr){
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
