package recursion;

import java.util.ArrayList;
import java.util.List;

/*
https://www.youtube.com/watch?v=ox3TswFFKDI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=31
 */
public class getAllMazePathsChoiceDiagram {

    private static List<String> result;

    public static void main(String[] args) {

        int Si=0;
        int Sj = 0;
        int Di = 2;
        int Dj = 2;
        int m = 3;
        int n= 3;
        result = new ArrayList<>();

        getAllMazePaths(Si,Sj,Di,Dj,"",m,n);
        System.out.println(result);
    }

    public static void getAllMazePaths(int Si, int Sj, int Di, int Dj, String currPaths,int m, int n){

        if(Si == Di && Sj == Dj){
            result.add(currPaths);
            return;
        }
        if(Si +1 < m && Sj +1 < n){
            getAllMazePaths(Si+1,Sj,Di,Dj,currPaths+"v",m,n);
            getAllMazePaths(Si,Sj+1,Di,Dj,currPaths+"h",m,n);
        }

        if(Si+1 >=m){
            getAllMazePaths(Si,Sj+1,Di,Dj,currPaths+"h",m,n);
        }

        if(Sj+1 >=n){
            getAllMazePaths(Si+1,Sj,Di,Dj,currPaths+"v",m,n);
        }
        return;
    }
}

