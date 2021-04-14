package recursion;

/*

Given a m*n matrix and a character and a position in the matrix, fill all the ajacent cells having same value with the new
character provided

https://www.youtube.com/watch?v=JMxl5rk7kGo


ex:

input matrix:

[1, 1, 1, 2, 1
 2, 1, 2, 1, 1
 2, 1, 2, 2, 1
 1, 1, 2, 2, 2]

 pos = [1,2]
 new character = 5

output matrix: [All right and bottom adjacent cells with same value will be replaced with new character 'a']

[1, 1, 1, 2, 1
 2, 1, 5, 1, 1
 2, 1, 5, 5, 1
 1, 1, 5, 5, 5]

 */
public class FloodFillProb {


    public static void main(String[] args) {


        int [][] matrix = {
                            {1, 1, 1, 2, 1},
                            {2, 1, 2, 1, 1},
                            {2, 1, 2, 2, 1},
                            {1, 1, 2, 2, 2}
                            };

//        int [][] matrix = {
//                          {1, 2},
//                          {2, 2}
//                          };
        int i = 1;
        int j = 2;


        System.out.println("Existing matrix ===>");

        for(int x =0 ; x < matrix.length; x++){
            for(int y=0; y < matrix[0].length; y++){
                System.out.print(matrix[x][y]+",");
            }
            System.out.println();
        }

        fillFlood(i, j, 2,5,matrix);

        System.out.println("Modified matrix ===>");


        for(int x =0 ; x < matrix.length; x++){
            for(int y=0; y < matrix[0].length; y++){
                System.out.print(matrix[x][y]+",");
            }
            System.out.println();
        }

    }

    private static void fillFlood(int i, int j, int existingNum, int newNumber, int[][] matrix) {

        if(i > matrix.length-1 || i < 0 || j > matrix[0].length-1 || j< 0 || matrix[i][j] != existingNum){
            return;
        }
        else
        {
            matrix[i][j] = newNumber;
            fillFlood(i+1,j,2,5,matrix);
            fillFlood(i-1,j,2,5,matrix);
            fillFlood(i,j+1,2,5,matrix);
            fillFlood(i,j-1,2,5,matrix);
        }
    }
}
