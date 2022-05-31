package StringQues;

/*
VVImp
https://leetcode.com/problems/next-greater-element-iii/
 */
public class NextGreaterElem {

    public static void main(String[] args) {
        NextGreaterElem obj = new NextGreaterElem();
        int n = 2147483486;
        int result = obj.nextGreaterElement(n);

        System.out.println(result);
    }

    private int nextGreaterElement(int n) {

        long ncopy = n;
        int[] numCountArr = new int[10];
        int prevDigit = -1;
        int currDigit = -1;

        while(ncopy > 0){

            currDigit = (int)ncopy%10;
            ncopy = ncopy/10;

            if(currDigit < prevDigit){

                for(int i =0; i < numCountArr.length; i++){
                    if(numCountArr[i] > 0 && i > currDigit) {
                        ncopy = (ncopy*10)+i;
                        numCountArr[i]--;
                        break;
                    }
                }

                numCountArr[currDigit]++;

                for(int j = 0; j < numCountArr.length; j++){
                    while(numCountArr[j] > 0){
                        ncopy = (ncopy*10)+j;
                        numCountArr[j] -- ;
                    }
                }
                break;

            }

            numCountArr[currDigit]++;
            prevDigit = currDigit;
        }


        if(ncopy <= Integer.MAX_VALUE && ncopy != 0) return (int)ncopy;
        else return -1;
    }
}
