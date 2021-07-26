package recursion;

public class TestRec {


    public static void main(String[] args) {

        int n=5;
        int [] arr = new int[] {0,0,0,0,0};
        recFunc(n,arr);

    }

    private static void recFunc(int n,int[] arr) {

        if(n==1){
            arr[0] = 1;
            return;
        }
        arr[n-1] = 1;
        recFunc(n-1,arr);
    }
}
