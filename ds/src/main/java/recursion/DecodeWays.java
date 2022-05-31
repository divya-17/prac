package recursion;

import java.util.Arrays;

/*
https://leetcode.com/problems/decode-ways/

https://www.youtube.com/watch?v=Ke8TPhHdHMw&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=34
 */

public class DecodeWays {


    private static int totalWays = 0;
    private static int [][] dp;


    public static void main(String[] args) {

        String ipStr = "123";
        String outStr = "";

        dp  = new int[Integer.parseInt(ipStr)+1][Integer.parseInt(ipStr)+1];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int res = getAllDecodedStrsCount(ipStr, outStr);
        System.out.println(res);
    }

    private static int getAllDecodedStrsCount(String ipStr, String outStr) {

        if(ipStr.length() == 0){
            System.out.println(outStr);
            totalWays++;
        }
        else if(ipStr.length() == 1){
            Character ch = ipStr.charAt(0);
            if (ch != 0) {
                int chValue = ch - '0';
                Character chCode = (char) ('A' + chValue - 1);
                return getAllDecodedStrsCount("",outStr+chCode);

            }
        }
        else{

            // First Character
            Character ch = ipStr.charAt(0);
            if (ch != 0) {
                int chValue = ch - '0';
                Character chCode = (char) ('A' + chValue - 1);
                 getAllDecodedStrsCount(ipStr.substring(1), outStr + chCode);

            }

            // First two Characters

            String ch12 = ipStr.substring(0,2);

            int StrValue = Integer.parseInt(ch12);
            if(StrValue <= 26) {
                Character chCode = (char) ('A' + StrValue - 1);
                getAllDecodedStrsCount(ipStr.substring(2), outStr + chCode);


            }

        }
        return totalWays;
    }

    public static int getIntValueForStrCode(String code){

        String intValue = "";

        if(code.isEmpty()){
            return 0;
        }
        for(int i =0; i < code.length(); i++){
            Character ch = code.charAt(i);
            intValue = intValue+(ch-'A'+1);
        }
        return Integer.parseInt(intValue);
    }
}
