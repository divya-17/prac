package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getAllMazePathRecursionHypothesis {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        int Di = 2;
        int Dj = 2;
        int Si = 0;
        int Sj = 0;

        List<String> result = getAllMazePaths(Si, Sj, Di, Dj,m,n);

        System.out.println(result);
    }

    private static List<String> getAllMazePaths(int si, int sj, int di, int dj, int m, int n) {

        if(si == di && sj == dj){
            return new ArrayList(Arrays.asList(""));
        }
        if (si >= m || sj >=n){
            return new ArrayList<>();
        }

        List<String> myRes = new ArrayList<>();

        List<String> vPaths = getAllMazePaths(si,sj+1,di,dj,m,n);
        List<String> hPaths = getAllMazePaths(si+1,sj,di,dj,m,n);

        if(!vPaths.isEmpty()) {
            for (String path : vPaths) {
                myRes.add("v" + path);
            }
        }
        if(!hPaths.isEmpty()) {
            for (String path : hPaths) {
                myRes.add("h" + path);
            }
        }

        return myRes;
    }

}
