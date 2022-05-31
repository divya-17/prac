package array;

public class MedianOfTwoSortedArr {

    public static void main(String[] args) {

        int[] nums1= new int[] {1, 2};
        int[] nums2 = new int[]{1, 1};

        MedianOfTwoSortedArr obj = new MedianOfTwoSortedArr();
        double result = obj.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Pointer = 0;
        int nums2Pointer = 0;
        int mergedArrPointer = 0;

        int [] mergedArr = new int[nums1.length+nums2.length];

        if(nums1.length == 0){
            return getMedian(nums2);
        }
        else if(nums2.length == 0){
            return getMedian(nums1);
        }

        while(nums1Pointer < nums1.length && nums2Pointer < nums2.length){

            if(nums1[nums1Pointer] < nums2[nums2Pointer]){
                mergedArr[mergedArrPointer] = nums1[nums1Pointer];
                nums1Pointer++;
            }
            else{
                mergedArr[mergedArrPointer] = nums2[nums2Pointer];
                nums2Pointer++;
            }
            mergedArrPointer++;
        }

        while(nums1Pointer < nums1.length){
            mergedArr[mergedArrPointer] = nums1[nums1Pointer];
            nums1Pointer++;
            mergedArrPointer++;
        }

        while(nums2Pointer < nums2.length){
            mergedArr[mergedArrPointer] = nums2[nums2Pointer];
            nums2Pointer++;
            mergedArrPointer++;
        }

        for(int i = 0; i < mergedArr.length; i++){
            System.out.println(mergedArr[i]+",");
        }
        return getMedian(mergedArr);
    }
    public double getMedian(int[] arr){

        if(arr.length %2 !=0){
            return arr[arr.length /2];
        }
        else{
            int middleIndex =  arr.length/2;

            return ((double)(arr[middleIndex]+arr[middleIndex-1])/(double)2);
        }

    }
}
