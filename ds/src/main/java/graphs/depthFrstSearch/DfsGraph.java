package graphs.depthFrstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Stack data structure is used in depth first search as it works on logic on LIFO.
 */
public class DfsGraph {



   private Stack stack = new Stack<>();

   public void dfs(Vertex startVertex){

       if(!startVertex.getVisited()){
           stack.push(startVertex);
           dfsWithStack(stack);
       }

   }

    private void dfsWithStack(Stack stack) {

       while (!stack.isEmpty()){

           Vertex vertex = (Vertex)stack.pop();
           vertex.setVisited(true);
           vertex.display();
           List<Vertex> connectedVertices = vertex.getConnectedVertices();
           for(Vertex vertex1: connectedVertices){
               stack.push(vertex1);
           }
       }
    }


}
