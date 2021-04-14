package ArraysQues;

public class ContainerWithMostWaterProb {

    /*

    Leetcode link: https://leetcode.com/problems/container-with-most-water/

    explaination video: https://www.youtube.com/watch?v=ZHQg07n_tbg

    ex: heights = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    max area: 49.

     */

    public static void main(String[] args) {

        int[] height = new int [] {1,8,6,2,5,4,8,3,7};
        int maxArea = LargestContainerArea(height);
        System.out.println("Max area is: "+maxArea);
    }

    private static int LargestContainerArea(int[] height) {

        int startPointer =0;
        int endPointer = height.length-1;

        int maxArea = 0;
        int currArea = 0;

        while (startPointer < endPointer){

            if(height[startPointer] > height[endPointer]){

                currArea = (endPointer-startPointer)*height[endPointer];
                if(currArea > maxArea){
                    maxArea = currArea;
                }
                endPointer = endPointer -1;
            }


            if(height[endPointer] > height[startPointer]){

                currArea = (endPointer - startPointer) * height[startPointer];

                if(currArea > maxArea){
                    maxArea = currArea;
                }
                startPointer = startPointer +1;
            }

            else if (height[startPointer] == height[endPointer]){

                currArea = (endPointer - startPointer) * height[startPointer];
                if(currArea > maxArea){
                    maxArea = currArea;
                }
                startPointer = startPointer +1;
                endPointer = endPointer -1;
            }
        }
        return maxArea;
    }
}
