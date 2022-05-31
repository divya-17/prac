package practice;

import java.util.*;

//https:leetcode.com/problems/rotting-oranges/submissions/

public class RootenOranges {


    public static void main(String[] args) {

        RootenOranges oranges = new RootenOranges();
        int[][] grid = new int[][] {{0,2,2,1,2,2,1,2,2},{0,2,0,2,1,2,1,1,0}};

        int output = oranges.orangesRotting(grid);
        System.out.println(output);
    }
    public int orangesRotting(int[][] grid) {

        String strtIndex = null;
        Map<String,Boolean> visitedMap = new HashMap();

        Queue<String> rootenOrangesCoordinates = new LinkedList();
        Queue<String> freshOrangesCoordinates = new LinkedList();
        List<String> initialFreshOranges = new ArrayList();

        int elapseTime=0;

        int rootenOrangesCount=0;
        int freshOrangesCount=0;


        for(int row=0; row < grid.length; row++){
            for(int col=0; col < grid[0].length; col++){

                if(grid[row][col] == 2){
                    rootenOrangesCount++;
                    strtIndex =row+"_"+col;
                    System.out.println("Checking for rooten coordinate "+strtIndex);
                    rootenOrangesCoordinates.add(strtIndex);
                    visitedMap.put(strtIndex,true);

                    Set<String> freshOranges = checkAllAdjacentCells(strtIndex,grid,freshOrangesCoordinates,visitedMap);

                    System.out.println("Adding in freshOrangesCoordinates"+freshOranges);
                    freshOrangesCoordinates.addAll(freshOranges);
                }
                else if(grid[row][col] == 1){
                    freshOrangesCount++;
                    initialFreshOranges.add(row+"_"+col);
                }

            }
        }

        if(freshOrangesCount > 1 && rootenOrangesCount==0){
            return -1;
        }
        System.out.println("Rooten list "+rootenOrangesCoordinates);
        System.out.println("Fresh list "+freshOrangesCoordinates);

        while(!freshOrangesCoordinates.isEmpty()){

            elapseTime++;

            int numLen = freshOrangesCoordinates.size();

            while(numLen !=0){

                String currIndex = freshOrangesCoordinates.poll();
                initialFreshOranges.remove(currIndex);

                System.out.println("Adding "+currIndex+" to rooten list");
                System.out.println("Visited map => "+visitedMap.get(currIndex));
                rootenOrangesCoordinates.add(currIndex);
                visitedMap.put(currIndex,true);

                Set<String> freshOranges = checkAllAdjacentCells(currIndex,grid,freshOrangesCoordinates,visitedMap);

                System.out.println("Adding "+freshOranges+" to fresh list");

                freshOrangesCoordinates.addAll(freshOranges);


                numLen--;
            }

        }

        if(initialFreshOranges.size() > 0){
            return -1;
        }

        return elapseTime;

    }


    public Set<String> checkAllAdjacentCells (String currentIndex, int[][] grid, Queue<String> freshOrangesCoordinates,Map<String,Boolean> visitedMap){

        Set<String> freshOrangesPos = new HashSet<>();

        int i = Integer.parseInt(currentIndex.split("_")[0]);
        int j = Integer.parseInt(currentIndex.split("_")[1]);

        System.out.println("Inside check func freshOrangesCoordinates =>"+freshOrangesCoordinates);

        if(i-1 >=0 && grid[i-1][j] == 1 && !visitedMap.containsKey((i-1)+"_"+j) && !freshOrangesCoordinates.contains((i-1)+"_"+j)) {

            freshOrangesPos.add((i-1)+"_"+j);

        }

        if(i+1 < grid.length && grid[i+1][j]==1 && !visitedMap.containsKey((i+1)+"_"+j) && !freshOrangesCoordinates.contains((i+1)+"_"+j)){

            freshOrangesPos.add((i+1)+"_"+j);

        }


        if(j-1 >=0 && grid[i][j-1] == 1 && !visitedMap.containsKey(i+"_"+(j-1)) && !freshOrangesCoordinates.contains(i+"_"+(j-1))){

            freshOrangesPos.add(i+"_"+(j-1));
        }

        if(j+1 < grid[0].length && grid[i][j+1] == 1 && !visitedMap.containsKey(i+"_"+(j+1)) && !freshOrangesCoordinates.contains(i+"_"+(j+1))){


            freshOrangesPos.add(i+"_"+(j+1));

        }

        return freshOrangesPos;

    }
}
