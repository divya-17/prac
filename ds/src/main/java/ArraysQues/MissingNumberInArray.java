package ArraysQues;

/*

Find missing number in an array given there is only one missing element and no repetition

Approach : Sum of series of number =  n (n+1)/2 given no duplicates
This approach will work if there are no duplicates and only one number is missing

 */
public class MissingNumberInArray {

    public static void main(String[] args) {


        int arr[] = {1,2,4,5,6};
        int n = arr.length;
        int num = missingNumber(arr,n);
        System.out.println("Missing number is "+num);
    }

    public static int missingNumber(int arr[], int n){

        // Since one elem is missing so ideal length should be n+1 so incremeting 1 in the actual formula
        int total = (n+1) * (n+2)/2;
        int currSum = 0;

        for(int i=0; i < n; i++){
            currSum += arr[i];
        }
        return (total - currSum);
    }
}
