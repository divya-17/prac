package recursion;

/*
https://www.youtube.com/watch?v=l45md3RYX7c&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=12
 */
public class TowerOfHanoi {

    public static void main(String[] args) {

        int n=4;

        String src = "Source";
        String dest = "Destination";
        String helper = "Helper";

        printSeqOfDiskMovements(src,dest,helper,n);
    }

    private static void printSeqOfDiskMovements(String src, String dest, String helper, int n) {

        if(n==1){
            System.out.println("Moving "+n+" from "+src+" to "+dest);
            return;
        }

        printSeqOfDiskMovements(src, helper,dest,n-1);

        System.out.println("Moving "+n+" from "+src+" to "+dest);

        printSeqOfDiskMovements(helper, dest, src, n-1);

        return;
    }


}
