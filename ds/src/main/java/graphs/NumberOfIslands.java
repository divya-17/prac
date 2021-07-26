package graphs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {


    public static void main(String[] args) {

        int[][] matrix1 = new int[][] {{1, 1, 1, 1},
                                      {1, 0, 0, 1},
                                      {1, 0, 1, 0},
                                      {0, 0, 0, 0}};

        int[][] matrix = new int[][] {{1, 1, 0, 0, 0},
                                       {0, 1, 0, 0, 1},
                                       {1, 0, 0, 1, 1},
                                       {0, 0, 0, 0, 0},
                                       {1, 0, 1, 0, 1}};
//
//        Set<String> indexEntries = new HashSet<>();
//
//        for(int i =0; i < matrix.length; i++){
//            for(int j=0; j < matrix[0].length; j++){
//                if(matrix[i][j] == 1){
//                    indexEntries.add(i+"_"+j);
//                }
//            }
//        }

//        System.out.println(indexEntries);
        int count = 0;
//        while (indexEntries.iterator().hasNext()){
//
//            String value = indexEntries.iterator().next();
//            int i = Integer.parseInt(value.split("_")[0]);
//            int j = Integer.parseInt(value.split("_")[1]);
//            dfs(i,j,matrix,indexEntries);
//            count++;
//        }
//        System.out.println("Number of islands "+count);


        for(int i =0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] ==1){
                    dfs(i,j,matrix);
                    count++;
                }
            }
        }

        System.out.println("Number of island: "+count);
        //printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for(int i=0; i< matrix.length;i++){
            for(int j=0; j <matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void dfs(int i, int j, int[][] matrix) {

        if(i >= matrix.length ||
                j>= matrix[0].length ||
                i < 0 ||
                j < 0 ||
                matrix[i][j] == 0 ||
                matrix[i][j]==-1){
            return;
        }
        //int temp = matrix[i][j]; -> Do this incase you want to retain the original matrix
        if(matrix[i][j] == 1)
            matrix[i][j] = -1;
//        if(indexEntry.contains(i+"_"+j)){
//            indexEntry.remove(i+"_"+j);
//        }

        dfs(i+1,j,matrix);
        dfs(i-1,j,matrix);
        dfs(i,j-1,matrix);
        dfs(i,j+1,matrix);
        //matrix[i][j] = temp;
    }
}
