package ArraysQues.sortingAlgo;

/*
        INSERTION SORT

   Explaination video: https://www.youtube.com/watch?v=i-SKeOcBwko&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=4


    Time complexity - O(n2)

    Insertion sort does better than selection sort and bubble sort in most of the pratical problems as number
    of shifts required is much less what is observed in worst case scenario.

 */
public class InsertionSort {


    public static void main(String[] args) {

        int [] inpArr1 = new int[] {7, 2, 4, 1, 5, 3, 9, 6};
        int [] inpArr2 = new int[] {5, 4, 3, 2, 1};

        System.out.println("Unsorted Array ");
        for(int i = 0; i < inpArr2.length; i++){
            System.out.print(inpArr2[i]+",");
        }

        System.out.println();


        insertionSort(inpArr2);

        System.out.println("Sorted Array using insertion sort");
        for(int i = 0; i < inpArr2.length; i++){
            System.out.print(inpArr2[i]+",");
        }

    }

    private static void insertionSort(int[] inpArr) {

        int j;
        for(int i =1; i < inpArr.length; i++){

            int value = inpArr[i];

            for (j=i-1; j >=0 ; j--){

                if(inpArr[j] > value){
                    inpArr[j+1] = inpArr[j];
                }
                else {
                    break;
                }
            }
            inpArr[j+1] = value;
        }
    }
}
