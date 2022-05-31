package graphs;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a chess board of size N*N, find the shortest path that needs to be taken for knight to reach from
src cell (sx,sy) to target cell (dx,dy).
 */
public class ShortestPathForKnight {

    private static Pair<Integer,Integer>  sourceCell = new Pair(0,0);
    private static Pair<Integer,Integer> destCell=  new Pair(2,2);

    private static int counter = 0;

    public static void main(String[] args) {

        int [][] chessBoard = new int[3][3];

        for(int[] row: chessBoard){
            Arrays.fill(row,-1);
        }

        Queue<Pair<Integer,Integer>> chessCellQueue = new LinkedList<>();
        chessCellQueue.add(sourceCell);
        chessBoard[sourceCell.getKey()][sourceCell.getValue()] = 0;
        if(sourceCell == destCell)
        {
            System.out.println("Both src and dest are equal. Shortest path will be 0");
        }

        getShortestPathForKnight(chessBoard,chessCellQueue);

        System.out.println(" Shortest path is " +chessBoard[chessBoard.length-1][chessBoard[0].length-1]);
    }

    private static void getShortestPathForKnight(int[][] chessBoard, Queue<Pair<Integer, Integer>> chessCellQueue) {

        while (!chessCellQueue.isEmpty()){

          Pair<Integer,Integer> currPos = chessCellQueue.poll();
          addAllPossiblePaths(chessBoard,currPos,chessCellQueue,counter);

        }

    }

    private static void addAllPossiblePaths(int[][] chessBoard,
                                            Pair<Integer, Integer> currPos,
                                            Queue<Pair<Integer, Integer>> chessCellQueue,
                                            int counter) {

        int x = currPos.getKey();
        int y = currPos.getValue();
        int rowLen = chessBoard.length;
        int colLen = chessBoard[0].length;

        if((x-2) >= 0 && (x-2) < rowLen && (y+1) >= 0 && (y+1) < colLen && chessBoard[x-2][y+1] == -1){
            chessCellQueue.add(new Pair<>(x-2,y+1));
            chessBoard[x-2][y+1]=chessBoard[x][y]+1;
        }
        if((x-2) >=0 && (x-2) < rowLen && (y-1) >= 0 && (y-1) < colLen && chessBoard[x-2][y-1] == -1){
            chessCellQueue.add(new Pair<>(x-2,y-1));
            chessBoard[x-2][y-1]=chessBoard[x][y]+1;
        }
        if((x+1) >=0 && (x+1) < rowLen && (y+2) >=0 && (y+2) < colLen && chessBoard[x+1][y+2] == -1){
            chessCellQueue.add(new Pair<>(x+1,y+2));
            chessBoard[x+1][y+2]=chessBoard[x][y]+1;
        }
        if((x+1) >= 0 && (x+1) < rowLen && (y-2) >=0 && (y-2) < colLen && chessBoard[x+1][y-2] == -1){
            chessCellQueue.add(new Pair<>(x+1,y-2));
            chessBoard[x+1][y-2]=chessBoard[x][y]+1;
        }
        if((x+2) >=0 && (x+2) < rowLen && (y+1) >=0 && (y+1) < colLen && chessBoard[x+2][y+1] == -1){
            chessCellQueue.add(new Pair<>(x+2,y+1));
            chessBoard[x+2][y+1]=chessBoard[x][y]+1;
        }
        if((x-1) >= 0 && (x-1) < rowLen && (y-2) >=0 && (y-2) < colLen && chessBoard[x-1][y-2] == -1){
            chessCellQueue.add(new Pair<>(x-1,y-2));
            chessBoard[x-1][y-2]=chessBoard[x][y]+1;
        }
        if((x-1) >=0 && (x-1) < rowLen && (y+2) >= 0 && (y+2) < colLen && chessBoard[x-1][y+2] == -1){
            chessCellQueue.add(new Pair<>(x-1,y+2));
            chessBoard[x-1][y+2]=chessBoard[x][y]+1;
        }


    }
}
