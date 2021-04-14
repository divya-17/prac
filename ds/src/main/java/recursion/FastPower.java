package recursion;

/*

Calculate power using recursion.
a ^ b.


 */
public class FastPower {


    public static void main(String[] args) {

        int a = 3;
        int power = 4;
        int result = fastPower(a,power);

        System.out.println("result is "+result);

    }

    private static int fastPower(int a, int power) {

        // Base condition
        if(power == 0){
            return 1;
        }

        return a* fastPower(a,power-1);
    }
}
