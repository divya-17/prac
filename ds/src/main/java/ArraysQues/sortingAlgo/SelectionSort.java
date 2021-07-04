package ArraysQues.sortingAlgo;

/*
                SELECTION SORT ALGORITHM:

Explaination video: https://www.youtube.com/watch?v=GUDLRan2DWM&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=2


 Time complexity : O(n2)
 */
public class SelectionSort {


    public static void main(String[] args) {

        int inpArr[] = new int [] {2, 7, 4, 1, 5, 3};

        System.out.println("Unsorted Array ");
        for(int i = 0; i < inpArr.length; i++){
            System.out.print(inpArr[i]+",");
        }
        selectionSort(inpArr);
        System.out.println();
        System.out.println("Sorted Array using Selection sort");
        for(int i=0; i < inpArr.length;i++){
            System.out.print(inpArr[i]+",");
        }

    }

    private static void selectionSort(int[] inpArr) {

        for(int i=0; i< inpArr.length; i++){

            int jmin = i;
            for(int j=i; j < inpArr.length; j++){

               if(inpArr[j] < inpArr[jmin]){
                   jmin = j;
               }
            }

            swapIndex(jmin,i,inpArr);

        }
    }

    private static void swapIndex(int jmin, int i,int[] inpArr) {
        int temp = inpArr[i];
        inpArr[i] = inpArr[jmin];
        inpArr[jmin] = temp;
    }

}
