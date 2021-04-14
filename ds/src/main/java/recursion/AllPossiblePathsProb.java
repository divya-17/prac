package recursion;

/*
Explaination video:
https://www.youtube.com/watch?v=AqHoXqOgctU

 Find all paths in a m*n grid.

 */
public class AllPossiblePathsProb {

    public static void main(String[] args) {

        int m = 4;
        int n=3;
        int result = allPossiblePathCount(m, n);

        System.out.println(result);
    }

    private static int allPossiblePathCount(int m, int n) {

        if(m == 1 || n== 1){
            return 1;
        }

        return allPossiblePathCount(m-1,n)+allPossiblePathCount(m,n-1);
    }
}
