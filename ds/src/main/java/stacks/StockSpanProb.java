package stacks;

import javafx.util.Pair;

import java.util.Stack;

/*

Given list of numbers which is stock values at different days, for each day find the length of consecutive days where
stock value was lesser than what it is at that day.

I/p: [100, 80, 60, 70, 60, 75, 85]

O/p:[1, 1, 1, 2, 1, 4, 6]

 */
public class StockSpanProb {

    private static int[] inputArr;
    private static int[] outArr;

    public static void main(String[] args) {

        inputArr = new int[] {100, 80, 60, 70, 60, 75, 85};

        outArr = consecutiveLowCostCountForEachPrice();

        for(int j =0; j < outArr.length; j++){
            System.out.print(outArr[j]+",");
        }
    }

    private static int[] consecutiveLowCostCountForEachPrice() {

        outArr = new int[7];

        Stack<Pair<Integer,Integer>> st = new Stack();

        for(int i =0 ; i < inputArr.length; i++){


            if(st.isEmpty() || st.peek().getKey() > inputArr[i]){
                st.push(new Pair(inputArr[i],1));
                outArr[i]=1;
            }
           else {
               int poppedElemTotalCounter=0;

               while (st.peek().getKey() < inputArr[i]){
                   Pair<Integer, Integer> elem = st.pop();
                   poppedElemTotalCounter = poppedElemTotalCounter+elem.getValue();
               }
               outArr[i] = poppedElemTotalCounter+1;
               st.push(new Pair<>(inputArr[i],poppedElemTotalCounter+1));
            }

        }
        return outArr;

    }
}
