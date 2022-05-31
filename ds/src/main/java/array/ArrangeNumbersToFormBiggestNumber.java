package array;

import java.util.*;

public class ArrangeNumbersToFormBiggestNumber {

    public static void main(String[] args) {

        List<String> numList = new ArrayList<>(Arrays.asList( "45", "4"));

        long largestNumber = getLargestNumber(numList);
        System.out.println(largestNumber);
    }

    private static long getLargestNumber(List<String> numList) {

      Collections.sort(numList, new Comparator<String>() {
          @Override
          public int compare(String X, String Y) {
              String s1 = X+Y;
              String s2 = Y+X;

              return s1.compareTo(s2) >0?-1:1;
          }
      });

        System.out.println(numList);
      return 0L;
    }
}
