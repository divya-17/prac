package recursion;

/*

Given a value N, find all the binary substrings of size N, such that num of 1s >= num of 0s in all it's prefixes.

Eg: N = 3

Possible binary strs can be:

111
011
101
110
001
100
010
000

Valid patterns are:

111 -> prefix strings will be (111,11,1) -> each have more/equal 1s than 0s
110 -> prefix strings will be (110,11,1) -> each have more/equal 1s than 0s
101 -> prefix strings will be (101,10,1) -> each have more/equal 1s than 0s

O/p: [111,110,101]
 */
public class NbitBinaryNumRecursion {

    public static void main(String[] args) {

        int N = 4;

        getAllValidStrs(0,0,"",N);
    }

    private static void getAllValidStrs(int n0s, int n1s, String outStr, int length) {

        if(n0s+n1s == length){
            System.out.println(outStr);
            return;
        }

        getAllValidStrs(n0s, n1s+1, outStr+"1", length);

        // fill 0s only when 1s > 0s.
        if(n1s > n0s) {
            getAllValidStrs(n0s + 1, n1s, outStr + "0", length);
        }

        return;
    }



}
