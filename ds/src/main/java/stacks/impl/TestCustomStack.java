package stacks.impl;

public class TestCustomStack {
    public static void main(String[] args) {

        CustomStack stack = new CustomStack(4);

        try {
            stack.show();
            stack.push(1);
            stack.show();
            stack.push(2);
            stack.show();
            stack.push(3);
            stack.show();
            stack.push(4);
            stack.show();
            //stack.push(5);
            stack.increment(5,100);
            stack.show();
            stack.increment(2, 100);
            stack.show();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
//            stack.show();
//            stack.pop();
//            stack.show();
//            stack.pop();
//            stack.show();
//            stack.pop();
//            stack.show();
        }
        catch (Exception e){
            System.out.println("Exception => "+e);
        }

    }
}
