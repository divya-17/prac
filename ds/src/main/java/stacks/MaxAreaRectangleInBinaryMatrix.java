package stacks;

/*
Given a binary matrix of 1s and 0s, find the area of largest rectangle of 1s.

Ex:
    matrix = [0    1    1    0]
             [1    1    1    1]
             [1    1    1    1]
             [1    1    0    0]

 Ans: Considering each row as base, 4 histograms cab be constructed.

 h1: [0, 1, 1, 0]
 h2: [1, 2, 2, 1]
 h3: [2, 3, 3, 2]
 h4: [3, 4, 0, 0]

 Now we can calculate largest area by using max area of histogram logic.
 */
public class MaxAreaRectangleInBinaryMatrix {

    private static int [][] binaryMatrix;
    private static int [][] histogramMatrix;
    private static MaxAreaHistogram  mah ;

    public static void main(String[] args) {


     mah = new MaxAreaHistogram();
     binaryMatrix = new int[][] {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};

//        binaryMatrix = new int[][]{{1, 0, 0, 1},
//                                   {0, 1, 1, 0},
//                                   {1, 1, 0, 1},
//                                   {1, 1, 1, 1}};

     histogramMatrix=createHistogramMatrix(binaryMatrix);
     Integer maxBinaryMatrixArea =0;

     for(int row=0; row < histogramMatrix.length; row++) {

         int[] inputArr = new int[histogramMatrix[0].length];

         for (int col = 0; col < histogramMatrix[0].length; col++) {
             inputArr[col] =  histogramMatrix[row][col];
         }

         System.out.println("Checking for arr ");
         for(int i =0; i < inputArr.length; i++){
             System.out.print(inputArr[i]+",");
         }
         System.out.println();

         Integer maxArea = mah.calculateMaxAreaHistogram(inputArr);
         System.out.println("Max area is =>"+maxArea);

         if(maxArea > maxBinaryMatrixArea){
             maxBinaryMatrixArea = maxArea;
         }
     }
        System.out.println("Max Binary Area is "+maxBinaryMatrixArea);
    }

    private static int[][] createHistogramMatrix(int[][] binaryMatrix) {

        histogramMatrix = new int[binaryMatrix.length][binaryMatrix[0].length];

        for (int row=0 ; row < binaryMatrix.length; row++){


            for(int col = 0; col < binaryMatrix[0].length; col++) {

                int sum = 0;
                int baseLimit = row;

                while (baseLimit >= 0 && binaryMatrix[baseLimit][col]!=0) {
                    sum++;
                    baseLimit--;
                }

                histogramMatrix[row][col] = sum;

            }
        }

        return histogramMatrix;
    }


}
