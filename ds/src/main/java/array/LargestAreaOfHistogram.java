package array;

import java.util.*;

/*

Leetcode link:  https://leetcode.com/problems/largest-rectangle-in-histogram/

ex: height = [2, 1, 5, 6, 2, 3]
largest output area = 10.


 */
public class LargestAreaOfHistogram {

    public static void main(String[] args) {

        int[] height = new int [] {2, 1, 5, 6, 2, 3};
        int maxArea = largestHistogramArea(height);
        System.out.println("Max area is: "+maxArea);
    }

    private static int largestHistogramArea(int[] height) {

        Map<Integer,Integer> rightLimitIndexMap = new HashMap<>();
        Map<Integer,Integer> leftLimitIndexMap = new HashMap<>();
        Stack<Integer> nextLowerLimit = new Stack();
        int j;
        int k;

        for (int i = 0; i < height.length;i++){

            nextLowerLimit.push(i);
            for(j = i+1; j < height.length;j++){

                if(height[j] >= height[i]){
                    nextLowerLimit.push(j);
                }
                else{
                    Integer poppedElem = nextLowerLimit.pop();
                    rightLimitIndexMap.put(i,poppedElem);
                    break;
                }
            }
            if(!rightLimitIndexMap.containsKey(i)) {
                rightLimitIndexMap.put(i, height.length-1);
            }

            //Reset the stack
            nextLowerLimit.clear();
        }

        System.out.println("Right Limit: "+rightLimitIndexMap);


        for(int i = height.length-1; i >=0; i--){

            nextLowerLimit.push(i);
            for(k = i-1 ; k >=0; k--){

                if(height[k] >= height[i]){
                    nextLowerLimit.push(k);
                }
                else{
                    Integer poppedElem = nextLowerLimit.pop();
                    leftLimitIndexMap.put(i,poppedElem);
                    break;
                }
            }
            if(!leftLimitIndexMap.containsKey(i)) {
                leftLimitIndexMap.put(i, 0);
            }

            //Reset the stack
            nextLowerLimit.clear();
        }

        System.out.println("Left limit: "+leftLimitIndexMap);



        // Area calc:

        int maxArea = 0;

        for(int i =0 ; i < height.length; i++){

            int currArea = height[i]* ((rightLimitIndexMap.get(i)-leftLimitIndexMap.get(i))+1);
            if(currArea > maxArea){
                maxArea = currArea;
            }
        }

        return maxArea;
    }


}
