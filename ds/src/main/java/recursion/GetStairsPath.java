package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://www.youtube.com/watch?v=W6cT68K7Hls&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=28
 */
public class GetStairsPath {


    public static void main(String[] args) {

        List<Integer> possibleStairPaths = new ArrayList(Arrays.asList(1,2,3));
        int n=5;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currCombinations = new ArrayList<>();
        Integer  currentSum = 0;
        getAllPossibleStairPaths(result,currCombinations,currentSum,n,possibleStairPaths);

        System.out.println(result);

    }

    private static void getAllPossibleStairPaths(List<List<Integer>> result ,
                                                 List<Integer> currCombinations,
                                                 Integer currentSum,
                                                 int n,List<Integer> possibleStairPaths) {

        if(currentSum == n){
            //System.out.println("Adding to result "+currCombinations);
            result.add(new ArrayList<>(currCombinations));
            return;
        }
        if(currentSum > n){
            return;
        }

        for(Integer num: possibleStairPaths){
            if(num > n) continue;
            currCombinations.add(num);
            getAllPossibleStairPaths(result,currCombinations,currentSum+num,n,possibleStairPaths);
            currCombinations.remove(num);
        }
    }
}
