package recursion;


import java.util.Stack;

/*
Delete middle elem of stack using recursion.

middle elem index will be defined by (stack.size/2)+1

 */
public class DeleteMiddleElemStack {

    public static void main(String[] args) {

        Stack<Integer> numStack = new Stack<>();

        numStack.push(10);
        numStack.push(3);
        numStack.push(7);
        numStack.push(11);
        numStack.push(8);

        int middleIndex = (numStack.size()/2)+1;

        System.out.println("Middle index =>"+middleIndex);
        System.out.println("Stack before deletion => "+numStack);
        deleteMiddleElemFromStack(numStack,middleIndex);
        System.out.println("Stack after deletion => "+numStack);
    }

    private static void deleteMiddleElemFromStack(Stack<Integer> numStack, int currIndex) {

        if(currIndex == 1) {
            numStack.pop();
            return;
        }
        int temp = numStack.pop();
        deleteMiddleElemFromStack(numStack, currIndex-1);
        numStack.push(temp);

    }
}
