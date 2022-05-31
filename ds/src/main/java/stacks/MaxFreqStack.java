package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*

https://www.geeksforgeeks.org/design-a-stack-which-can-give-maximum-frequency-element/
Given N elements and the task is to implement a stack which removes and returns the maximum frequency element on every pop operation.
If there’s a tie in the frequency then the topmost highest frequency element will be returned.
 */
public class MaxFreqStack {

    public static void main(String[] args) {

        FreqStack stack = new FreqStack();

        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);


    }
}
class FreqStack{

    Map<Integer,Integer> freqMap = new HashMap();
    Map<Integer, Stack<Integer>> freqStack = new HashMap<>();
    int maxFreq = 0;


    public void push(int elem){

        int currFreq = 0;

        if(freqMap.containsKey(elem)){
            freqMap.put(elem,freqMap.get(elem)+1);
            currFreq = freqMap.get(elem);
        }
        else {
            freqMap.put(elem,1);
            currFreq = 1;
        }
        if(currFreq > maxFreq){
            maxFreq = currFreq;
        }

        if(freqStack.containsKey(currFreq)){
            freqStack.get(currFreq).push(elem);
        }
        else {
            Stack<Integer> stack = new Stack();
            stack.push(elem);

            freqStack.put(currFreq,stack);
        }
    }
    public int pop(){

        Stack<Integer> maxFreqStack = freqStack.get(maxFreq);
         int currElem = maxFreqStack.pop();

         if(maxFreqStack.isEmpty()){
             maxFreq = maxFreq-1;
         }
         freqMap.put(currElem,freqMap.get(currElem)-1);
         return currElem;
    }

    @Override
    public String toString() {
        return "FreqStack{" +
                "freqMap=" + freqMap +
                ", freqStack=" + freqStack +
                ", maxFreq=" + maxFreq +
                '}';
    }

}