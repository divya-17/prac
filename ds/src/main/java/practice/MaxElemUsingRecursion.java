package practice;

public class MaxElemUsingRecursion {

    private static int maxElem = 0;
    public static void main(String[] args) {

        int arr[] = new int[] {22, 33, 4, 19, 7};

         int maxElem = getMaxElem(arr,arr.length-1);
        System.out.println(maxElem);
    }

    private static int getMaxElem(int[] arr, int n) {

        if(n == 0) {
            maxElem = arr[0];
            return maxElem;
        }

        if(arr[n] > getMaxElem(arr,n-1)){
            maxElem = arr[n];
        }
        return maxElem;
    }
}
