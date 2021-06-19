package recursion;

public class PrintNums {

    public static void main(String[] args) {


        int n=5;
        printNumsRec(n);
        System.out.println("<===============>");
        printNumsRecInReverse(n);


    }

    private static void printNumsRecInReverse(int n) {
        if(n==1 ){
            return;
        }
        System.out.println(n);
        printNumsRecInReverse(n-1);
    }

    private static void printNumsRec(int n) {

        if(n==0 ){
            return;
        }
        printNumsRec(n-1);
        System.out.println(n);
        return;
    }

}
