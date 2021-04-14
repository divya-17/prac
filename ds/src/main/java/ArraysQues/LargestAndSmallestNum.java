package ArraysQues;

/*

Find largest and smallest number in an unsorted array:

Input arr = {4,2,5,1,7,3,11}

Smallest num: 1
Largst num: 11

 */
public class LargestAndSmallestNum {


    public static void main(String[] args) {

        int arr [] = {4,2,5,1,7,3,11};

        largestAndSmallestNumber(arr);
    }

    private static void largestAndSmallestNumber(int[] arr) {

        int smallest = arr[0];
        int largst = arr[0];

        for (int i=0; i < arr.length; i++){
            if (arr[i] < smallest){
                smallest = arr[i];
            }
            if(arr[i] > largst){
                largst = arr[i];
            }
        }

        System.out.println("Smallest number is "+smallest);
        System.out.println("Largest number is "+largst);
    }
}
