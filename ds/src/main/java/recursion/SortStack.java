package recursion;
import java.util.Stack;

public class SortStack {


    public static void main(String[] args) {


        Stack<Integer> inpStack = new Stack<Integer>();

        inpStack.push(0);
        inpStack.push(3);
        inpStack.push(2);
        inpStack.push(5);
        inpStack.push(1);

        System.out.println("Stack before sorting => "+inpStack);

        sortInpStack(inpStack,inpStack.size());

        System.out.println("Stack after sorting => "+inpStack);

    }

    private static Stack<Integer> sortInpStack(Stack<Integer> inpStack, int n) {

        if(n==1){
            return inpStack;
        }

        insertElemInCorrOrder(sortInpStack(inpStack, n-1),inpStack.pop());

        return inpStack;
    }

    private static void insertElemInCorrOrder(Stack<Integer> inpStack, int elemToInsert) {

        if(inpStack.peek() < elemToInsert || inpStack.isEmpty()){
            inpStack.push(elemToInsert);
            return;
        }
        else {
            int temp = inpStack.pop();
            insertElemInCorrOrder(inpStack,elemToInsert);
            inpStack.push(temp);
        }
    }

}
