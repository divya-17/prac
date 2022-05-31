package array;

/*

Given two sorted arrays along with their respective lengths, merge them without using an extra space
nums1 with have length of m+n where first m elements are the sorted elem of m1 array and last n elems are set to 0
that will help us to accomodate num2 elems in num1.

nums1 = [1, 2, 3, 0, 0, 0] m = 3;
nums2 = [2, 5, 6] n=3

O/p: [1, 2, 2, 3, 5, 6]

nums1 = [1, 3, 7, 9, 10, 0, 0, 0]
num2 = [2, 5, 6]
O/p: [1, 2, 3, 5, 6, 7, 9, 10]
 */

public class MergeTwoSortedArray {


    public static void main(String[] args) {

//        int [] arr1 = new int[] {1, 3, 4, 5, 0, 0, 0};
//        //int [] arr2 = new int[]  {6, 7, 8};
//        int[] arr2 = new int[] {2, 6, 7};


//        int[] arr1 = new int[]{4, 5, 6, 0, 0, 0};
//        int[] arr2 = new int[]{1, 2, 3};
//        int m = 3;
//        int n =3;


//        int [] arr1 = new int[] {1, 2, 3, 0, 0, 0};
//        int[] arr2 = new int[] {2, 5, 6};
//        int m = 3;
//        int n = 3;

        int [] arr1 = new int[] {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int [] arr2 = new int[] {-1, 1, 1, 1, 2, 3};
        int m = 3;
        int n = 6;

        System.out.println("arr 1 before merge");
        printArr(arr1);
        System.out.println("arr 2 before merge");
        printArr(arr2);
        mergeSortedArr(arr1,arr2,m, n);
        System.out.println("arr1 after merge");
        printArr(arr1);
    }

    private static void mergeSortedArr(int[] arr1, int[] arr2,int m, int n) {

        if(n > 0 ){

            int startIndex  = 0;
            int mergedArrLen = arr1.length;
            int arrTwoCurrIndex = 0;
            int firstArrLen = m;

            if(m > 0){
                while (startIndex < firstArrLen && arrTwoCurrIndex < n){

                    if(arr1[startIndex] > arr2[arrTwoCurrIndex]){
                        shiftElem(startIndex,arr2[arrTwoCurrIndex],arr1);
                        firstArrLen++;
                        arrTwoCurrIndex++;
                    }
                    startIndex++;
                }

            }
            if(arrTwoCurrIndex <= arr2.length-1)
                while (startIndex < mergedArrLen){
                    arr1[startIndex] = arr2[arrTwoCurrIndex];
                    startIndex++;
                    arrTwoCurrIndex++;
                }
            }
    }

    private static void shiftElem(int strtIndex, int insertNum, int[] arr) {

        int endIndex = arr.length-1;
        while (endIndex > strtIndex){
            arr[endIndex] = arr[endIndex-1];
            endIndex--;
        }
        arr[strtIndex] = insertNum;

    }

    private static boolean checkValidArr(int array[], int size)
    {
        for (int i = 0; i < size; i++)
        {
            if(array[i] != 0)
            {
                return false;
            }
        }
        return true;
    }

    private static void printArr(int[] arr) {

        for(int i=0; i <arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }

}
