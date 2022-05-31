package array;

/*
https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
 */
public class MinNumberOfMergeForPalindrome {

    private static int totalMergeOperationCount = 0;

    public static void main(String[] args) {

        int[] inputArr1 = new int[] {1, 4, 3, 2, 5, 1};
        int[] inputArr2 = new int[] {1, 4, 5, 1};
        int[] inputArr3 = new int[] {11, 14, 15, 99};

        int count  = getMinMergeForPalindrom(inputArr3);
        System.out.println(count);
    }

    private static int getMinMergeForPalindrom(int[] inputArr) {

        // 1 length arr are already palindrome
        if(inputArr.length == 1){
            return 0;
        }
        int si = 0;
        int ei = inputArr.length-1;

        while (si < ei){

            if(inputArr[si] == inputArr[ei]){
                si++;
                ei--;
            }
            else if(inputArr[si] < inputArr[ei]){
                inputArr[si+1] = inputArr[si]+inputArr[si+1];
                si++;
                totalMergeOperationCount++;
            }
            else if(inputArr[si] > inputArr[ei]){
                inputArr[ei-1] = inputArr[ei]+inputArr[ei-1];
                ei--;
                totalMergeOperationCount++;
            }
        }

        return totalMergeOperationCount;
    }
}
