package stacks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 */
public class RootenOrangesProb {

    public static void main(String[] args) {

        int[][] matrix = {{2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};

        int result = orangeRootingTimeUnit(matrix);
        System.out.println("Result is "+result);


    }

    private static int orangeRootingTimeUnit(int[][] matrix) {

        Pair<Boolean, List<Pair>> coordinates = checkPossibilityAndGetStartCoordinates(matrix);
//        System.out.println("Start coordinates are: "+coordinates);

        List<Node> timeSeriesList = new LinkedList<>();

        if (!coordinates.getKey()) {
            return -1;
        } else {

            List<Pair> startCoordinates = coordinates.getValue();
            List<Node> nodeList = new LinkedList<>();
            timeSeriesList = getTimeUnitForRottenOranges(matrix, startCoordinates, -1,nodeList);
        }
//
//        for(Node node: timeSeriesList){
//            System.out.println(node.getCoordinates()+ " -> "+node.timeUnit);
//
//        }

        return timeSeriesList.get(timeSeriesList.size()-1).timeUnit;
    }

    private static List<Node> getTimeUnitForRottenOranges(int[][] inputMatrix, List<Pair> startCoordinates, Integer timeUnit,List<Node> nodeList) {

        List<Pair> coordinateList = new ArrayList<>();

        int incrementedTimeUnit = timeUnit+1;
        for(Pair<Integer,Integer> coordinates: startCoordinates){
            nodeList.add(new Node(new Pair<>(coordinates.getKey(),coordinates.getValue()),incrementedTimeUnit));
            int i = coordinates.getKey();
            int j = coordinates.getValue();
            if(i-1 >=0)
                if(inputMatrix[i-1][j] ==1){
                coordinateList.add(new Pair(i-1,j));
                inputMatrix[i-1][j]=2;
            }
            if(i+1 < inputMatrix.length){
                if(inputMatrix[i+1][j] == 1){
                    coordinateList.add(new Pair(i+1,j));
                    inputMatrix[i+1][j] = 2;
                }
            }
            if(j-1 >= 0){
                if(inputMatrix[i][j-1] == 1){
                    coordinateList.add(new Pair(i,j-1));
                    inputMatrix[i][j-1]=2;
                }
            }
            if(j+1 < inputMatrix[0].length){
                if(inputMatrix[i][j+1] == 1){
                    coordinateList.add(new Pair(i,j+1));
                    inputMatrix[i][j+1]=2;
                }
            }
        }
        if(coordinateList.isEmpty()){
            return nodeList;
        }
        else {
            return getTimeUnitForRottenOranges(inputMatrix, coordinateList,incrementedTimeUnit,nodeList);
        }

    }

    private static Pair<Boolean, List<Pair>> checkPossibilityAndGetStartCoordinates(int[][] matrix) {

        List<Pair> rootenOrangeCoordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 1) {
                    Boolean possibilityFlag = checkPossibility(i, j, matrix);
                    if(!possibilityFlag){
                        return new Pair<>(false,rootenOrangeCoordinates);
                    }
                }
                else {
                    if(matrix[i][j]==2){
                        rootenOrangeCoordinates.add(new Pair(i,j));
                    }
                }
            }
        }
        return new Pair<>(true,rootenOrangeCoordinates);
    }

    private static Boolean checkPossibility(int i, int j, int[][] matrix) {

        Boolean possibilityFlag = false;

        if (i - 1 >= 0) {
            if (matrix[i - 1][j] != 0) {
                possibilityFlag = true;
            }
        }

        if (i + 1 < matrix.length) {
            if (matrix[i + 1][j] != 0) {
                possibilityFlag = true;
            }
        }

        if (j - 1 >= 0) {
            if (matrix[i][j - 1] != 0) {
                possibilityFlag = true;
            }
        }

        if (j + 1 < matrix[0].length) {
            if (matrix[i][j + 1] != 0) {
                possibilityFlag = true;
            }
        }

        return possibilityFlag;
    }


    static class Node{

        private Pair<Integer,Integer> coordinates;
        private Integer timeUnit;

        public Node(Pair<Integer,Integer> coordinates, Integer timeUnit){

            this.coordinates = coordinates;
            this.timeUnit=timeUnit;
        }

        public Pair<Integer, Integer> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Pair<Integer, Integer> coordinates) {
            this.coordinates = coordinates;
        }

        public Integer getTimeUnit() {
            return timeUnit;
        }

        public void setTimeUnit(Integer timeUnit) {
            this.timeUnit = timeUnit;
        }
    }
}
