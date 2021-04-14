package ArraysQues;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.min;
import static java.lang.Integer.max;

/*
Given two sorted arrays , find the median of the merged array.

Ex:

(1) arr1 = {1, 3, 8, 9, 15}
    arr2 = {7, 11, 18, 19, 21, 25}

    merged arr = {1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25}

    median = 11

(2) arr1 = {1, 5, 7, 9, 11}
    arr2 = {2, 6, 8, 12, 15}

    merged arr = {1, 2, 5, 6, 7, 8, 9, 11, 12, 15}

    median = (7+8)/2

 */
public class MedianInTwoSortedArray {

    public static void main(String[] args) {

        Integer [] arr1= {1, 3, 8, 9, 15};
        Integer [] arr2= {7, 11, 18, 19, 21, 25};
        int median = getMedian(arr1, arr2);

        System.out.println("Median is "+median);

    }

    private static int getMedian(Integer[] arr1, Integer[] arr2) {

        Integer totalLen = (arr1.length+arr2.length);
        Integer halfSize = (totalLen)/2;
        Integer [] shorterArr;

        //Binary search will be performed on shorter array so storing shorter array separately
        if(arr1.length <= arr2.length){
            shorterArr = arr1;
        }
        else {
            shorterArr = arr2;
        }

        int startIndex = 0;
        int endIndex = shorterArr.length-1;
        int midIndex = (startIndex+endIndex)/2;

        Integer[] arr1LeftPartition = null;
        Integer[] arr1RightPartition = null;
        Integer[] arr2LeftPartition = null;
        Integer[] arr2RightPartition = null;

        while (true){


            arr1LeftPartition = Arrays.copyOfRange(arr1,0,midIndex+1);
            arr1RightPartition = Arrays.copyOfRange(arr1,midIndex+1,arr1.length);

            arr2LeftPartition = Arrays.copyOfRange(arr2,0,(halfSize - arr1LeftPartition.length));
            arr2RightPartition = Arrays.copyOfRange(arr2,(halfSize - arr1LeftPartition.length),arr2.length);


            if(Collections.max(Arrays.asList(arr1LeftPartition)) <= Collections.min(Arrays.asList(arr2RightPartition)) &&
                    (Collections.max(Arrays.asList(arr2LeftPartition)) <= Collections.min(Arrays.asList(arr1RightPartition)))){

                // Equally balanced partition achieved.
                break;
            }
           if(Collections.max(Arrays.asList(arr2LeftPartition)) > Collections.min(Arrays.asList(arr1RightPartition))){

                startIndex = midIndex;
            }
            else {

                endIndex = midIndex;
            }
            midIndex = (startIndex+endIndex)/2;
        }

        System.out.println("Equally balanced partitions are ");

        System.out.println("Arr1 left partition ==>"+Arrays.toString(arr1LeftPartition));
        System.out.println("Arr1 right partition ===>"+Arrays.toString(arr1RightPartition));

        System.out.println("Arr2 left partition ===>"+Arrays.toString(arr2LeftPartition));
        System.out.println("Arr2 right partition ===>"+Arrays.toString(arr2RightPartition));


        int leftPartitionLen = arr1LeftPartition.length+arr2LeftPartition.length;
        int righPartitionLen = arr2LeftPartition.length+arr2RightPartition.length;

        if(leftPartitionLen != righPartitionLen){

            if(leftPartitionLen < righPartitionLen){

                Integer min1 = Collections.min(Arrays.asList(arr1RightPartition));
                Integer min2 = Collections.min(Arrays.asList(arr2RightPartition));
                int median = min(min1, min2);
                return median;
            }
            else if(leftPartitionLen > righPartitionLen){

                Integer max1 = Collections.max(Arrays.asList(arr1LeftPartition));
                Integer max2 = Collections.max(Arrays.asList(arr2LeftPartition));

                int median = max(max1, max2);
                return median;
            }
        }
        else {

            Integer max1 = Collections.max(Arrays.asList(arr1LeftPartition));
            Integer max2 = Collections.max(Arrays.asList(arr2LeftPartition));

            int value1 = max(max1, max2);

            Integer min1 = Collections.min(Arrays.asList(arr1RightPartition));
            Integer min2 = Collections.min(Arrays.asList(arr2RightPartition));

            int value2 = min(min1,min2);

            int median = (value1+value2)/2;

            return median;
        }


        return 0;
    }


}
