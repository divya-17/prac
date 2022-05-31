package stacks;

import java.util.Stack;

/*

Celebrity is the one who is known by all but he doesn't know anyone.
matrix[][] given where matrix[i][j] means i knows j.
Find the celebrity in the party. Return -1 if there isn't any celebrity.
PS: No one knows himself.
 */
public class TheCelebrityProblem {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{0,0,1,0},{0,0,1,0},{0,0,0,0},{0,0,1,0}};
        int celebrity = getCelebrity(matrix);
        System.out.println("Celebrity is "+celebrity);
    }

    private static int getCelebrity(int[][] matrix) {

        int size= matrix.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < size; i++){
            stack.push(i);
        }
        while (stack.size() > 1){

            Integer topElem = stack.pop();
            Integer secondTopElem = stack.pop();

            if(matrix[topElem][secondTopElem] == 1){
                stack.push(secondTopElem);
            }
            else if(matrix[topElem][secondTopElem] == 0){
                stack.push(topElem);
            }
        }

        Integer potentialCandidate = stack.pop();
        Boolean celebrityExists = true;

        for (int i = 0; i <size; i++){
            if(matrix[potentialCandidate][i] == 1){
                celebrityExists = false;
            }
            if((i != potentialCandidate) && matrix[i][potentialCandidate] == 0){
                celebrityExists= false;
            }
        }

        if(!celebrityExists){
            return -1;
        }
        return potentialCandidate;
    }
}
