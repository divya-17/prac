package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*

Given an list of toys kept in a mall, a mother to 10yr old child has 2 conditions to buying
the toys:

cond 1: Toys needs to be picked in the same sequence in which they are kept without skipping any
cond 2: Max number of unique toys can't be more than 2

Now the 10yr old child want to pick max number of toys while respecting the above 2 conditions laid
by her mother
Find the max number of toys that he can have.


 */
public class PickToys {

    public static void main(String[] args) {

        char [] toysArr = new char[] {'a','b','a','c','c','a','b'};

        int k = 2;
        int maxToys = getMaxNumToys(toysArr,k);
        System.out.println(maxToys);
    }

    private static int getMaxNumToys(char[] toysArr,int k) {

        int start =0;
        int maxLen = Integer.MIN_VALUE;

        Map<Character,Integer> charCountMap = new HashMap<>();

        for(int end =0; end< toysArr.length; end++){

            if(charCountMap.containsKey(toysArr[end])){
                charCountMap.put(toysArr[end],charCountMap.get(toysArr[end])+1);
            }
            else{
                charCountMap.put(toysArr[end],1);
            }

            if(charCountMap.size() == k){
                maxLen = Math.max(maxLen,(end-start+1));
            }

            if(charCountMap.size() > k){

                while (charCountMap.size() > k){

                    if(charCountMap.containsKey(toysArr[start])){
                        int v = charCountMap.get(toysArr[start])-1;

                        if(v == 0){
                            charCountMap.remove(toysArr[start]);
                        }
                    }
                    start++;
                }
            }


        }

        return maxLen;

    }
}
