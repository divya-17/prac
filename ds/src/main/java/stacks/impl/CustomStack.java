package stacks.impl;

/*
Design a stack with increment operation:

CustomStack stack = new CustomStack
stack.push(1)
[1]

stack.push(2)
[1, 2]

stack.pop()
2

stack.push(2)
[1, 2]

stack.push(3)
[1, 2, 3]

stack.push(4)
Exception of stack full

stack.increment(5,100) -> increment all elems from bottom to pos 5 with the value of 100.
[101,102,103]

stack.increment(2,100)
[201,202,103] -> only 2 elems from bottom will be modified.

stack.pop()
103

stack.pop()
202

stack.pop()
201

stack.pop()
-1

 */
public class CustomStack {

    int size;
    int top;
    int arr[];

    CustomStack(int size){

        this.size = size;
        arr = new int[size];
        top=0;
    }

    public void push(int elem){

        if(top < size) {
            arr[top] = elem;
            top++;
        }else {
            throw  new RuntimeException("Stack full !");
        }
    }

    public void pop(){

        int topElem = -1;
        if(top >= 0) {
            if(top > arr.length-1){
                top = arr.length-1;
            }
            topElem = arr[top];
            top--;
        }
        System.out.println(topElem);

    }

    public void show(){
       for (int i =0; i < arr.length; i++){
           System.out.print(arr[i]+" ");
       }
        System.out.println();
    }

    public void increment(int lowerIndex, int value){

        if (lowerIndex > size)
            lowerIndex = size;

        for(int i = 0 ; i < lowerIndex; i++){
            arr[i] = arr[i]+value;
        }

    }

}
