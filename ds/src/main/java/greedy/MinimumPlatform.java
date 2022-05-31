package greedy;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
 */
public class MinimumPlatform {

    public static void main(String[] args) {

        int arr[] = new int[]{900, 810, 720, 1000, 600, 1200};
        int dep[] = new int[]{910, 1120, 1130, 1200, 1900, 2000};

        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < arr.length && j < dep.length) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }
        System.out.println("Max platform required => "+result);
    }

}
