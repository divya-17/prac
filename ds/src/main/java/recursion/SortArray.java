package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {


    public static void main(String[] args) {

        List<Integer> inputArr = new ArrayList<>(Arrays.asList(5, 4, 0, 2, 1, 6, 3));

        List<Integer> sortedArr = sortArrayUsingRec(inputArr);

        System.out.println("Sorted Array is => "+sortedArr);
    }

    private static List<Integer> sortArrayUsingRec(List<Integer> inputArr) {

        if(inputArr.size() == 1)
        {
            return inputArr;
        }

        return sortSlicedArr(sortArrayUsingRec(inputArr.subList(0,inputArr.size()-1)),0,inputArr.get(inputArr.size()-1));
    }

    private static List<Integer> sortSlicedArr(List<Integer> subList, int n, int elem) {


        if(n==subList.size() || subList.get(n) > elem){
            subList.add(n,elem) ;
            return subList;
        }

        return sortSlicedArr(subList, n+1, elem);
    }

}
