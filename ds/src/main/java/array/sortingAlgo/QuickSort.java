package array.sortingAlgo;

/*
    QUICK SORT

Explaination video: https://www.youtube.com/watch?v=COk73cpQbFQ&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=8



 */
public class QuickSort {


    public static void main(String[] args) {

        int arr [] = new int[] {7, 2, 1, 6, 8, 5, 3, 4};

        System.out.println("Array before sorting ");
        printArr(arr);
//        int pIndex = partitionArr(0,7,arr);
//        System.out.println(pIndex);
        quickSort(arr);
        System.out.println("Array after sorting ");
        printArr(arr);

    }

    private static void quickSort(int[] arr) {

        int start = 0;
        int end = arr.length-1;
        sort(start,end,arr);
    }

    private static void printArr(int[] arr) {

        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void sort(int start, int end, int[] arr){

        if(start < end){

            int pIndex = partitionArr(start,end,arr);
            sort(start,pIndex-1,arr);
            sort(pIndex+1,end,arr);
        }
    }

    private static int partitionArr(int start, int end, int[] arr) {

        int pIndex = start;
        int pivotElem = arr[end];
        int pivotElemIndex = end;

        for(int i =start; i < end; i++){
            if(arr[i] <= pivotElem){
                swap(i,pIndex,arr);
                pIndex++;
            }
        }

        swap(pIndex,pivotElemIndex,arr);

        return pIndex;
    }

    private static void swap(int i, int partitionIndex, int[] arr) {

        int temp = arr [i];
        arr[i] = arr[partitionIndex];
        arr[partitionIndex] = temp;
    }

}
