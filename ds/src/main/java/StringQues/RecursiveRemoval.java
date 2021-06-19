package StringQues;

/*

Recursively remove all adjacent duplicates.
Ex:

String s = "abbaca"
"abbaca" => "aaca" => ca
Output: "ca"

String s = "azxxzy"
"azxxzy" => "azzy" => "ay"
Output: "ay"


 */
public class RecursiveRemoval {

    public static void main(String[] args) {

        String str ="azxxzy";
        String str1 = "abbaca";

        String modifiedStr = removeDuplicate(str1);
        System.out.println(modifiedStr);
    }

    private static String removeDuplicate(String str) {


        for (int i=0; i <str.length()-1;i++){

            if(str.charAt(i) == str.charAt(i+1)){
                str = (str.substring(0,i)+str.substring(i+2));
                return removeDuplicate(str);
            }

        }
        return str;
    }
}
