package greedy;

import java.util.*;

/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class BalloonsBurstProb {

    public static void main(String[] args) {

        int totalArrows = 1;
        int startIndex = 0;


        int[][] points = new int[][] {{10,16},{2,8},{1,6},{7,12}};

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1],o2[1]);
            }
        });

        for(int i=1; i < points.length; i++){

            if(points[i][0] > points[startIndex][1]){
                totalArrows++;
                startIndex = i;
            }

        }
        System.out.println(totalArrows);
    }

}
