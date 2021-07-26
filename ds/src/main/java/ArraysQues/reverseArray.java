package ArraysQues;

/*
https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/

Given an array, task is to reverse the array

i/p: {4, 5, 1, 2}
o/p: {2, 1, 5, 4}

 */
public class reverseArray {

    public static void main(String[] args) {

        int[] ipArr = new int[] {4, 5, 1, 3, 2};

        System.out.println("Array before reverse ==>");
        printArr(ipArr);
        reverse(ipArr);
        System.out.println("Array after reverse ==>");
        printArr(ipArr);


    }

    private static void reverse(int[] inArr){

        for (int i=0; i < inArr.length/2;i++){
            swap(inArr,i,inArr.length-1-i);
        }

    }

    private static void swap(int[] inArr, int i, int i1) {

        int temp = inArr[i];
        inArr[i] = inArr[i1];
        inArr[i1] = temp;
    }

    private static void printArr(int[] ipArr) {

        for(int i=0 ; i < ipArr.length; i++){
            System.out.print(ipArr[i]+" ");
        }
        System.out.println();
    }

}
