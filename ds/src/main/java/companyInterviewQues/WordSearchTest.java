package companyInterviewQues;

/*
Expedia Interview Ques:

Given a matrix of character and a string, search if that string is present in that char matrix.
 */
public class WordSearchTest {


    private static Boolean ans = false;
    public static void main(String[] args) {


        Character[][] chMatrix = new Character[3][4];
        chMatrix[0][0] = 'A';
        chMatrix[0][1] = 'B';
        chMatrix[0][2] = 'C';
        chMatrix[0][3] = 'E';

        chMatrix[1][0] = 'S';
        chMatrix[1][1] = 'F';
        chMatrix[1][2] = 'C';
        chMatrix[1][3] = 'S';

        chMatrix[2][0] = 'A';
        chMatrix[2][1] = 'D';
        chMatrix[2][2] = 'E';
        chMatrix[2][3] = 'E';

        String ipStr ="ABCCED";
        String ipStr1 = "ABFB";


        Boolean result = checkForWordInMatrix(ipStr1,chMatrix,0,0,0);
        System.out.println("String present "+result);

    }

    private static Boolean checkForWordInMatrix(String ipStr, Character[][] chMatrix, int currIndex, int row, int col) {

        if(currIndex == ipStr.length()){
            return true;
        }
        if(row < 0 || row >= chMatrix.length || col < 0 || col >= chMatrix[0].length){
            return false;
        }
        if(chMatrix[row][col] != ipStr.charAt(currIndex)){
            return false;
        }
        if(chMatrix[row][col] == ipStr.charAt(currIndex)){

            Character ch = chMatrix[row][col];
            chMatrix[row][col] = '$';

            ans = checkForWordInMatrix(ipStr,chMatrix,currIndex+1,row+1,col) ||
                    checkForWordInMatrix(ipStr,chMatrix,currIndex+1,row-1,col) ||
                    checkForWordInMatrix(ipStr,chMatrix,currIndex+1,row,col+1) ||
                    checkForWordInMatrix(ipStr,chMatrix,currIndex+1,row,col-1);
            chMatrix[row][col] = ch;
        }
        return ans;
    }
}
