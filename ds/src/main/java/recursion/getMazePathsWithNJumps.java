package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.youtube.com/watch?v=ox3TswFFKDI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=31

Allowed jumps are:
v1 (1 vertical unit)
v2 (2 vertical unit)
v3 (3 vertical unit)

h1 (1 horizontal unit)
h2 (2 horizontal unit)
h3 (3 horizontal unit)

d1 (1 diagonal unit)
d2 (2 diagonal unit)
d3 (3 diagonal unit)
 */
public class getMazePathsWithNJumps {

    public static void main(String[] args) {

        int si = 0;
        int sj = 0;
        int di = 2;
        int dj = 2;
        int m  = 3;
        int n  = 3;

        List<String> result = getAllMazePathsWithJump(si, sj, di, dj, m, n);

        System.out.println("Result => "+result);
    }

    private static List<String> getAllMazePathsWithJump(int si, int sj, int di, int dj, int m, int n) {


        if(si == di && sj == dj){
            return new ArrayList<>(Arrays.asList(""));
        }
        if(si >= m || sj >=n){
            return new ArrayList<>();
        }
        List<String> myPaths = new ArrayList<>();

        List<String> h1Paths = getAllMazePathsWithJump(si,sj+1,di,dj,m,n);
        List<String> h2Paths = getAllMazePathsWithJump(si,sj+2,di,dj,m,n);
        List<String> h3Paths = getAllMazePathsWithJump(si,sj+3,di,dj,m,n);

        List<String> v1Paths = getAllMazePathsWithJump(si+1,sj,di,dj,m,n);
        List<String> v2Paths = getAllMazePathsWithJump(si+2,sj,di,dj,m,n);
        List<String> v3Paths = getAllMazePathsWithJump(si+3,sj,di,dj,m,n);

        List<String> d1Paths = getAllMazePathsWithJump(si+1,sj+1,di,dj,m,n);
        List<String> d2Paths = getAllMazePathsWithJump(si+2,sj+2,di,dj,m,n);
        List<String> d3Paths = getAllMazePathsWithJump(si+3,sj+3,di,dj,m,n);

        for(String p: h1Paths){
            myPaths.add("h1"+p);
        }
        for(String p: h2Paths){
            myPaths.add("h2"+p);
        }
        for(String p: h3Paths){
            myPaths.add("h3"+p);
        }


        for(String p: v1Paths){
            myPaths.add("v1"+p);
        }
        for(String p: v2Paths){
            myPaths.add("v2"+p);
        }
        for(String p: v3Paths){
            myPaths.add("v3"+p);
        }

        for(String p: d1Paths){
            myPaths.add("d1"+p);
        }
        for(String p: d2Paths){
            myPaths.add("d2"+p);
        }
        for(String p: d3Paths){
            myPaths.add("d3"+p);
        }

        return myPaths;

    }
}
