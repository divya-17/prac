package graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TravellingSalesManProblem {

    private static  List<String> allPossiblePaths;
    private static PriorityQueue distanceQueue = new PriorityQueue();

    public static void main(String[] args) {


        int totalNumberOfVertices = 4;
        int startVertex = 1;
        allPossiblePaths = new ArrayList<>();

        int[][] adjMatrix = new int[][]{{0, 10, 15, 20},
                {5, 0, 25, 10},
                {15, 30, 0, 5},
                {15, 10, 20, 0}};

        getAllPossiblePaths(startVertex,startVertex+",",totalNumberOfVertices,adjMatrix,0);
        System.out.println(allPossiblePaths);
        System.out.println("Minimum distance => "+distanceQueue.poll());


    }

    private static void getAllPossiblePaths(int startVertex, String pathsTravelledSoFar,int totalVertices,int[][] matrix,int totalPathSum) {

        if(pathsTravelledSoFar.split(",").length == totalVertices){
            allPossiblePaths.add(pathsTravelledSoFar+","+startVertex);
            totalPathSum += matrix[Integer.parseInt(pathsTravelledSoFar.split(",")[pathsTravelledSoFar.split(",").length-1])-1][startVertex-1];
//            System.out.println("Path is =>"+pathsTravelledSoFar+","+startVertex);
//            System.out.println("Total sum is =>"+totalPathSum);
            distanceQueue.add(totalPathSum);
            return;
        }

        List<Integer> currPathList = new ArrayList<>();

        for(String i: pathsTravelledSoFar.split(",")){
            currPathList.add(Integer.parseInt(i));
        }

        for(Integer vertex = 1; vertex <= 4; vertex++){
            if(!currPathList.contains(vertex)){

                int previousVertex = Integer.parseInt(pathsTravelledSoFar.split(",")[pathsTravelledSoFar.split(",").length-1]);

                if(pathsTravelledSoFar.endsWith(",")){
                    getAllPossiblePaths(startVertex,pathsTravelledSoFar+vertex,totalVertices,matrix,
                            totalPathSum+matrix[previousVertex-1][vertex-1]);
                }
                else{
                    getAllPossiblePaths(startVertex,pathsTravelledSoFar+","+vertex,totalVertices,matrix,
                            totalPathSum+matrix[previousVertex-1][vertex-1]);

                }
            }
        }
    }
}
