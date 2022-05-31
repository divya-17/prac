package StringQues;

/*
https://leetcode.com/problems/count-and-say/

 */
public class CountAndSayProblem {

    public static void main(String[] args) {


        System.out.println(getResultStr("21"));

        
    }



    public static String getResultStr(String ipStr){

        String newStr = "";
        Character prevChar = '0';
        int count = 0;

        for(int i=0; i < ipStr.length(); i++){

            if(prevChar == '0'){
                prevChar = ipStr.charAt(i);
                count = 1;
            }
            else if(ipStr.charAt(i) == prevChar){
                count++;
            }
            else{
                newStr = newStr+count+prevChar;
                count=1;
                prevChar = ipStr.charAt(i);
            }
        }
        newStr=newStr+count+prevChar;
        return newStr;
    }
}
