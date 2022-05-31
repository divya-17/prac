package array.sortingAlgo;


/*

Quick sort uses a partitioning logic in which a pivot elem is selected from the array and all elems less than
the pivot are at the left of the pivot, and all elems at the right of the pivot is greater than it.

Below program shows just the partitioning logic of quick sort
 */
public class PartitioningLogicQuickSort {


    public static void main(String[] args) {

        int [] arr = new int[] {7, 2, 1, 6, 8, 5, 3, 4};

        int pivotElemIndex = 7;

        System.out.println("Array before shift: ");
        printArr(arr);
        shiftElemRelativeToPivot(arr,pivotElemIndex);
        System.out.println("Array after shift: ");
        printArr(arr);

    }

    private static void printArr(int[] arr) {

        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void shiftElemRelativeToPivot(int[] arr, int pivotElemIndex) {

        int partitionIndex = 0;

        for(int i =0; i < arr.length; i++){
            if(arr[i] < arr[pivotElemIndex]){
                swap(i,partitionIndex,arr);
                partitionIndex++;
            }
        }

        swap(partitionIndex,pivotElemIndex,arr);
    }

    private static void swap(int i, int partitionIndex, int[] arr) {

        int temp = arr[i];
        arr[i] = arr[partitionIndex];
        arr[partitionIndex] = temp;
    }
}
