package binarySearch;

import java.util.Arrays;
import java.util.Collections;

/*
https://www.geeksforgeeks.org/allocate-minimum-number-pages/

 Given page array, and number of students, assign pages of students such that max number of pages assigned
 to a student is minimum

 */
public class AllocateMinNumPages {

    public static void main(String[] args) {

        Integer [] pages = new Integer[] {12, 34, 67, 90};
        int m =2;
        int output = getMaxPagesAssignedPerStudent(pages,m);
        System.out.println(output);
    }

    private static int getMaxPagesAssignedPerStudent(Integer[] pages, int m) {

        int result = -1;

        int start = getMaxOfArr(pages);
        int end  = getSumOfArr(pages);

        while (start <= end){

            int mid = start+(end-start)/2;

            if(isValid(mid,m,pages)){
                result = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return result;
    }

    private static boolean isValid(int mid, int m, Integer[] pages) {

        int currSum=0;
        int i = 0;

        while (m != 0 && i < pages.length){

            if((currSum+pages[i]) <= mid){
                currSum = currSum+pages[i];
            }
            else{
                currSum = pages[i];
                m --;
            }
            i++;
        }

        if(i == pages.length && m!=0){
            return true;
        }
        else{
            return false;
        }

    }



    private static int getSumOfArr(Integer[] pages) {

        int sum=0;
        for(int  i =0; i < pages.length; i++){
            sum = sum+pages[i];
        }
        return sum;
    }

    private static int getMaxOfArr(Integer[] pages) {

        Arrays.sort(pages, Collections.reverseOrder());
        return pages[0];
    }
}
