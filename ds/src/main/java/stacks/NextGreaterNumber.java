package stacks;


import java.util.Stack;

/*
Given an array of numbers , for every number, find  the next greater number to left and right.

I/p: [1, 3, 12, 5, 15, 11]

O/p: leftNGArr : [-1, -1, -1, 12, -1, 15]
     rightNGArr: [3, 12, 15, 15, -1, -1]

 */
public class NextGreaterNumber {

    static int[] leftNGArr = new int[6];
    static int[] rightNGArr = new int[6];

    public static void main(String[] args) {

        int[] inputArr = new int[] {1, 3, 12, 5, 15, 11};

        getleftNGArr(inputArr);
        getRightNGArr(inputArr);

        System.out.println("Right NG arr");
        for(int i=0; i < rightNGArr.length; i++){
            System.out.print(rightNGArr[i]+",");
        }
        System.out.println();

        System.out.println("Left NG arr");
        for(int i=0; i < leftNGArr.length; i++){
            System.out.print(leftNGArr[i]+",");
        }
    }

    private static void getRightNGArr(int[] inputArr) {

        Stack<Integer> st = new Stack();

        for(int i = inputArr.length-1; i >= 0; i--){

            while (st.size() >0 && st.peek() <= inputArr[i]){
                st.pop();
            }
            if(st.size() == 0){
                st.push(inputArr[i]);
                rightNGArr[i] = -1;
            }
            else {
                rightNGArr[i] = st.peek();
                st.push(inputArr[i]);
            }

        }
    }

    private static void getleftNGArr(int[] inputArr) {

        Stack<Integer> st = new Stack();

        for(int i = 0; i < inputArr.length; i++){

            while (st.size() >0 && st.peek() <= inputArr[i]){
                st.pop();
            }
            if(st.size() == 0){
                st.push(inputArr[i]);
                leftNGArr[i] = -1;
            }
            else {
                leftNGArr[i] = st.peek();
                st.push(inputArr[i]);
            }

        }
    }
}
