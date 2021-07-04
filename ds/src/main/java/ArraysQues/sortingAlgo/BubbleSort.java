package ArraysQues.sortingAlgo;

/*

        BUBBLE SORT

 Explaination video: https://www.youtube.com/watch?v=Jdtq5uKz-w4&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=3

 Time Complexity - O(n2)

 */
public class BubbleSort {


    public static void main(String[] args) {

        int inpArr[] = new int [] {2, 7, 4, 1, 5, 3};

        System.out.println("Unsorted Array ");
        for(int i = 0; i < inpArr.length; i++){
            System.out.print(inpArr[i]+",");
        }
        bubbleSort(inpArr);
        System.out.println();
        System.out.println("Sorted Array using Bubble sort");
        for(int i=0; i < inpArr.length;i++){
            System.out.print(inpArr[i]+",");
        }
    }

    private static void bubbleSort(int[] inpArr) {

       for(int j = inpArr.length; j>=0; j--){
           boolean swapFlag =false;
           for(int i =0 ; i < j; i++){
               if(i+1 < j && inpArr[i] > inpArr[i+1]){
                   swap(inpArr,i,i+1);
                   swapFlag=true;
               }
           }
           // Swap flag is taken so that if during any pass there was not even a single pass, we know that our array is
           // already sorted and we don't need to run anymore iterations, so we can simply break from the loop.
           if(swapFlag)break;
       }
    }

    private static void swap(int[] inpArr, int i, int i1) {

        int temp = inpArr[i];
        inpArr[i] = inpArr[i+1];
        inpArr[i+1] = temp;
    }
}
