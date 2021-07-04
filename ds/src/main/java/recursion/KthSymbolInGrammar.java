package recursion;

/*
Leetcode: https://leetcode.com/problems/k-th-symbol-in-grammar/

 */
public class KthSymbolInGrammar {

    public static void main(String[] args) {


        int n = 30;
        int k = 434991989;

        int result = generateGrammar(n,k);
        System.out.println(result);

    }

    private static int generateGrammar(int n, int k) {

        if(n == 1 && k==1){
            return 0;
        }

        int mid = (int) ((Math.pow(2,n-1))/2);

        if(k <= mid){
            return generateGrammar(n-1,k) == 0?0:1;
        }

        else{
            return generateGrammar(n-1,k-mid) == 0?1:0;
        }

    }

}
